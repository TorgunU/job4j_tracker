package ru.job4j.tracker.input;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new StubOutput();
        Input in = new MockInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenMultiplyInvalidInput() {
        Output output = new StubOutput();
        Input mockInput = new MockInput(
                new String[] {"1", "2", "3"}
        );
        ValidateInput input = new ValidateInput(output, mockInput);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);

        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(2);

        selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(3);
    }

    @Test
    void whenNegativeInvalidInput() {
        Output output = new StubOutput();
        Input mockInput = new MockInput(
                new String[] {"-1"}
        );
        ValidateInput input = new ValidateInput(output, mockInput);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-1);

    }
}