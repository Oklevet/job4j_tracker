package ru.job4j.tracker;

import java.util.ArrayList;
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

    public Item[] findAll(Item[] items) {
        Item[] itemsNoNull = new Item[items.length];
        int size = 0;
        for (Item i :items) {
            if (i != null) {
                itemsNoNull[size] = i;
                size++;
            }
        }
        if (size == 0) {
            return null;
        }
        return Arrays.copyOf(itemsNoNull, size);
    }

    public Item[] findByName(String name) {
        Item[] itemsN = new Item[items.length];
        int size = 0;
        for (Item i : items) {
            if (i.getName().equals(name)) {
                itemsN[size] = i;
                size++;
            }
        }
        if (size == 0) {
            return null;
        }
        return Arrays.copyOf(itemsN, size);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}