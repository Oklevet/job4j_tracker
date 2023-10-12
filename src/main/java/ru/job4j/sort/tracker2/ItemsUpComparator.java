package ru.job4j.sort.tracker2;

import java.util.Comparator;

public class ItemsUpComparator implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
