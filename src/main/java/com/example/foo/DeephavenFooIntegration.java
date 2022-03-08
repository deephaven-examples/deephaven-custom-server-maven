package com.example.foo;

import io.deephaven.engine.table.Table;
import io.deephaven.engine.table.impl.InMemoryTable;
import io.deephaven.engine.table.impl.util.KeyedArrayBackedMutableTable;
import io.deephaven.engine.util.config.MutableInputTable;
import io.deephaven.qst.column.Column;
import io.deephaven.qst.table.NewTable;
import io.deephaven.util.QueryConstants;

import java.io.IOException;

import static io.deephaven.function.DoublePrimitives.*;

/**
 * An example of wrapping up {@link FooLibrary} into Deephaven.
 */
public class DeephavenFooIntegration {

    /**
     * Creates a Deephaven {@link Table} filled with random constants for "A", "B", "C". Computes the
     * {@link #leftRoot(double, double, double)} and {@link #rightRoot(double, double, double)}, as well as the
     * {@link #gamma(double)} of the left root.
     *
     * @return the table
     */
    public static Table createTable() {
        return createTableInternal();
    }

    /**
     * Sanitizes the input and outputs for {@link FooLibrary#leftRoot(double, double, double)}.
     *
     * @param a the "a" constant
     * @param b the "b" constant
     * @param c the "c" constant
     * @return the left root, or {@link QueryConstants#NULL_DOUBLE} if none
     */
    public static double leftRoot(double a, double b, double c) {
        if (isNull(a) || isNull(b) || isNull(c)) {
            return QueryConstants.NULL_DOUBLE;
        }
        return nanToNull(FooLibrary.leftRoot(a, b, c));
    }

    /**
     * Sanitizes the input and outputs for {@link FooLibrary#rightRoot(double, double, double)}.
     *
     * @param a the "a" constant
     * @param b the "b" constant
     * @param c the "c" constant
     * @return the right root, or {@link QueryConstants#NULL_DOUBLE} if none
     */
    public static double rightRoot(double a, double b, double c) {
        if (isNull(a) || isNull(b) || isNull(c)) {
            return QueryConstants.NULL_DOUBLE;
        }
        return nanToNull(FooLibrary.rightRoot(a, b, c));
    }

    /**
     * Sanitizes the input and outputs for {@link FooLibrary#gamma(double)}.
     *
     * @param x the argument
     * @return the gamma, or {@link QueryConstants#NULL_DOUBLE} if none
     */
    public static double gamma(double x) {
        return isNull(x) ? QueryConstants.NULL_DOUBLE : nanToNull(FooLibrary.gamma(x));
    }

    private static double nanToNull(double x) {
        return Double.isNaN(x) ? QueryConstants.NULL_DOUBLE : x;
    }

    private static Table createTableInternal() {
        KeyedArrayBackedMutableTable table = KeyedArrayBackedMutableTable.make(createRandomRow(), "Index");
        MutableInputTable mutableInputTable = table.mutableInputTable();
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    mutableInputTable.add(createRandomRow());
                } catch (IOException e) {
                    e.printStackTrace();
                    return;
                }
                try {
                    Thread.sleep(Long.getLong("foo.sleepMillis",100));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }, "MyThread");
        t.start();
        return addRoots(table).sort("Index");
    }

    private static Table addRoots(Table table) {
        return table.update(
                "Left=com.example.foo.DeephavenFooIntegration.leftRoot(A, B, C)",
                "Right=com.example.foo.DeephavenFooIntegration.rightRoot(A, B, C)",
                "Gamma=com.example.foo.DeephavenFooIntegration.gamma(Left)");
    }

    private static Table createRandomRow() {
        int ix = (int)(Math.random() * 100);
        double a = Math.random() * 200 - 100;
        double b = Math.random() * 200 - 100;
        double c = Math.random() * 200 - 100;
        return InMemoryTable.from(NewTable.of(
                Column.of("Index", ix),
                Column.of("A", a),
                Column.of("B", b),
                Column.of("C", c)));
    }
}
