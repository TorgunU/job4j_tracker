package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class FactorialTest {
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