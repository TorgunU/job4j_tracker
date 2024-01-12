package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemComparatorTest {
    @Test
    void whenAscendingSort() {
        List<Item> itemList = new LinkedList<>(Arrays.asList(
                new Item("DoSomething"),
                new Item("Work"),
                new Item("Sleep"),
                new Item("Awake")
        ));
        List<Item> expected = new LinkedList<>(Arrays.asList(
                new Item("Awake"),
                new Item("DoSomething"),
                new Item("Sleep"),
                new Item("Work")
        ));

        itemList.sort(new ItemAscByName());
        assertThat(itemList).isEqualTo(expected);
    }

    @Test
    void whenDescendingSort() {
        List<Item> itemList = new LinkedList<>(Arrays.asList(
                new Item("Sleep"),
                new Item("DoSomething"),
                new Item("Work"),
                new Item("Awake")
                ));
        List<Item> expected = new LinkedList<>(Arrays.asList(
                new Item("Work"),
                new Item("Sleep"),
                new Item("DoSomething"),
                new Item("Awake")
        ));

        itemList.sort(new ItemDescByName());
        assertThat(itemList).isEqualTo(expected);
    }
}