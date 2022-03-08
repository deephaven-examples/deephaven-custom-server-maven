package com.example.foo;

import org.junit.jupiter.api.Test;

import static io.deephaven.util.QueryConstants.NULL_DOUBLE;
import static org.assertj.core.api.Assertions.assertThat;

public class DeephavenFooIntegrationTest {

    @Test
    void leftRoot1() {
        assertThat(DeephavenFooIntegration.leftRoot(1, 0, -1)).isEqualTo(-1);
    }

    @Test
    void rightRoot1() {
        assertThat(DeephavenFooIntegration.rightRoot(1, 0, -1)).isEqualTo(1);
    }

    @Test
    void leftRoot2() {
        assertThat(DeephavenFooIntegration.leftRoot(1, 0, 0)).isEqualTo(0);
    }

    @Test
    void rightRoot2() {
        assertThat(DeephavenFooIntegration.rightRoot(1, 0, 0)).isEqualTo(0);
    }

    @Test
    void leftRoot3() {
        assertThat(DeephavenFooIntegration.leftRoot(1, 0, 1)).isEqualTo(NULL_DOUBLE);
    }

    @Test
    void rightRoot3() {
        assertThat(DeephavenFooIntegration.rightRoot(1, 0, 1)).isEqualTo(NULL_DOUBLE);
    }

    @Test
    void gamma0() {
        assertThat(DeephavenFooIntegration.gamma(0)).isEqualTo(NULL_DOUBLE);
    }

    @Test
    void gamma1() {
        assertThat(DeephavenFooIntegration.gamma(1)).isEqualTo(1);
    }

    @Test
    void gamma2() {
        assertThat(DeephavenFooIntegration.gamma(2)).isEqualTo(1);
    }

    @Test
    void gamma3() {
        assertThat(DeephavenFooIntegration.gamma(3)).isEqualTo(2);
    }

    @Test
    void gamma4() {
        assertThat(DeephavenFooIntegration.gamma(4)).isEqualTo(6);
    }

    @Test
    void gammaNull() {
        assertThat(DeephavenFooIntegration.gamma(NULL_DOUBLE)).isEqualTo(NULL_DOUBLE);
    }

    @Test
    void leftRootAIsNull() {
        assertThat(DeephavenFooIntegration.leftRoot(NULL_DOUBLE, 0, -1)).isEqualTo(NULL_DOUBLE);
    }

    @Test
    void leftRootBIsNull() {
        assertThat(DeephavenFooIntegration.leftRoot(1, NULL_DOUBLE, -1)).isEqualTo(NULL_DOUBLE);
    }

    @Test
    void leftRootCIsNull() {
        assertThat(DeephavenFooIntegration.leftRoot(1, 0, NULL_DOUBLE)).isEqualTo(NULL_DOUBLE);
    }

    @Test
    void rightRootAIsNull() {
        assertThat(DeephavenFooIntegration.rightRoot(NULL_DOUBLE, 0, -1)).isEqualTo(NULL_DOUBLE);
    }

    @Test
    void rightRootBIsNull() {
        assertThat(DeephavenFooIntegration.rightRoot(1, NULL_DOUBLE, -1)).isEqualTo(NULL_DOUBLE);
    }

    @Test
    void rightRootCIsNull() {
        assertThat(DeephavenFooIntegration.rightRoot(1, 0, NULL_DOUBLE)).isEqualTo(NULL_DOUBLE);
    }
}
