package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FactorialTest {
    @Test
    public void when3That6() {
        Factorial factorial = new Factorial();
        int expected = 6;
        int result = factorial.calc(3);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void when4That20() {
        Factorial factorial = new Factorial();
        int expected = 24;
        int result = factorial.calc(4);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenIllegalArgumentExceptionThrown() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> factorial.calc(-1)
        );
        assertThat(exception.getMessage()).isEqualTo("Number could not be less then 0");
    }
}