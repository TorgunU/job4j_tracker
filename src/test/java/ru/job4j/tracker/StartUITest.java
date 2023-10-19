package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {
    @Test
    void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName()).isEqualTo(expected.getName());
    }

    @Test
    void whenTwoItemCreated() {
        String[] answers = {"Fix bug", "Push commit"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        StartUI.createItem(input, tracker);
        Item[] result = tracker.findAll();
        Item[] expected =
                {
                        new Item("Fix bug"),
                        new Item("Push commit")
                };
        assertThat(result[0].getName()).isEqualTo(expected[0].getName());
        assertThat(result[1].getName()).isEqualTo(expected[1].getName());
    }
}