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
        Item rsl = null;
        Item[] sortedItems = findAll();
        for (Item item : sortedItems) {
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] result = new Item[items.length];
        int size = 0;
        for (Item item : items) {
            if (item != null) {
                result[size] = item;
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item[] findByName(String key) {
        Item[] sortedItems = findAll();
        Item[] result = new Item[sortedItems.length];
        int size = 0;
        for (Item item : sortedItems) {
            if (item.getName().equals(key)) {
               result[size] = item;
               size++;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }
}