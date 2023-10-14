package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int resultArraySize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                result[resultArraySize] = items[i];
                resultArraySize++;
            }
        }
        result = Arrays.copyOf(result, resultArraySize);
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int resultArraySize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                result[resultArraySize] = items[i];
                resultArraySize++;
            }
        }
        result = Arrays.copyOf(result, resultArraySize);
        return result;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        item.setId(items[index].getId());
        items[index] = item;
        return true;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}