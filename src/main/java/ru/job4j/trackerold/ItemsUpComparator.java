package ru.job4j.trackerold;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class ItemsUpComparator implements Comparator<ru.job4j.tracker.Item> {

    @Override
    public int compare(ru.job4j.tracker.Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
