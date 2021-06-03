package ru.job4j.trackerold;

import ru.job4j.tracker.Item;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<ru.job4j.tracker.Item> items = new ArrayList<ru.job4j.tracker.Item>();
    private int ids = 1;

    public ru.job4j.tracker.Item add(ru.job4j.tracker.Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public List<ru.job4j.tracker.Item> findAll() {
        return items;
    }

    public List<ru.job4j.tracker.Item> findByName(String name) {
        List<ru.job4j.tracker.Item> itemsN = new ArrayList<>();
        int size = 0;
        for (ru.job4j.tracker.Item i : items) {
            if (i.getName().equals(name)) {
                itemsN.add(i);
            }
        }
        return itemsN;
    }

    private int indexOf(int id) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public ru.job4j.tracker.Item findById(int id) {
        int i = indexOf(id);
        return i != -1 ? items.get(i) : null;
    }

    public boolean replace(int id, Item item) {
        int i = indexOf(id);
        if (i == -1) {
            return false;
        }
        item.setId(id);
        items.set(i, item);
        return true;
    }

    public boolean delete(int id) {
        int i = indexOf(id);
        if (i == -1) {
            return false;
        }
        items.remove(i);
        return true;
    }
}