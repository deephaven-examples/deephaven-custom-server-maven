package com.example.foo;

import org.apache.commons.math3.special.Gamma;

/**
 * An example library that provides some math related functions.
 */
public class FooLibrary {

    /**
     * Equivalent to {@code (-b - sqrt(b^2 - 4ac)) / 2a}.
     *
     * @param a the "a" constant
     * @param b the "b" constant
     * @param c the "c" constant
     * @return the left root, or {@link Double#NaN} if none
     * @see <a href="https://en.wikipedia.org/wiki/Quadratic_formula">Quadratic formula</a>
     */
    public static double leftRoot(double a, double b, double c) {
        double discriminantSqrt = Math.sqrt(b * b - 4 * a * c);
        return (-b - discriminantSqrt) / 2 / a;
    }

    /**
     * Equivalent to {@code (-b + sqrt(b^2 - 4ac)) / 2a}.
     *
     * @param a the "a" constant
     * @param b the "b" constant
     * @param c the "c" constant
     * @return the right root, or {@link Double#NaN} if none
     * @see <a href="https://en.wikipedia.org/wiki/Quadratic_formula">Quadratic formula</a>
     */
    public static double rightRoot(double a, double b, double c) {
        double discriminantSqrt = Math.sqrt(b * b - 4 * a * c);
        return (-b + discriminantSqrt) / 2 / a;
    }

    /**
     * Equivalent to {@link Gamma#gamma(double)}.
     *
     * @param x the argument
     * @return the gamma
     */
    public static double gamma(double x) {
        // Call out to a 3rd party library
        return Gamma.gamma(x);
    }
}
