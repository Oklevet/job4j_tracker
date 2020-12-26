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

    public Item[] findAll(Item[] items) {
        return Arrays.copyOf(items, this.size);
    }

    public Item[] findByName(String name) {
        Item[] itemsN = new Item[this.size];
        int size = 0;
        for (int i = 0; i < this.size; i++) {
            if (items[0].getName().equals(name)) {
                itemsN[size] = items[i];
                size++;
            }
        }
        return Arrays.copyOf(itemsN, size);
    }

    private int indexOf(int id) {
        for (int i = 0; i < this.size; i++) {
            if (items[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Item findById(int id) {
        int i = indexOf(id);
        return i != -1 ? items[i] : null;
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        if (i == -1) {
            return false;
        }
        item.setId(id);
        items[i] = item;
        return true;
    }
}