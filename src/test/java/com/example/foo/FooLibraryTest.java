package com.example.foo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FooLibraryTest {

    @Test
    void leftRoot1() {
        assertThat(FooLibrary.leftRoot(1, 0, -1)).isEqualTo(-1);
    }

    @Test
    void rightRoot1() {
        assertThat(FooLibrary.rightRoot(1, 0, -1)).isEqualTo(1);
    }

    @Test
    void leftRoot2() {
        assertThat(FooLibrary.leftRoot(1, 0, 0)).isEqualTo(0);
    }

    @Test
    void rightRoot2() {
        assertThat(FooLibrary.rightRoot(1, 0, 0)).isEqualTo(0);
    }

    @Test
    void leftRoot3() {
        assertThat(FooLibrary.leftRoot(1, 0, 1)).isNaN();
    }

    @Test
    void rightRoot3() {
        assertThat(FooLibrary.rightRoot(1, 0, 1)).isNaN();
    }

    @Test
    void gamma0() {
        assertThat(FooLibrary.gamma(0)).isNaN();
    }

    @Test
    void gamma1() {
        assertThat(FooLibrary.gamma(1)).isEqualTo(1);
    }

    @Test
    void gamma2() {
        assertThat(FooLibrary.gamma(2)).isEqualTo(1);
    }

    @Test
    void gamma3() {
        assertThat(FooLibrary.gamma(3)).isEqualTo(2);
    }

    @Test
    void gamma4() {
        assertThat(FooLibrary.gamma(4)).isEqualTo(6);
    }
}
