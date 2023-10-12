package ru.job4j.tracker2;

import java.util.Comparator;

public class ItemsDownComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
