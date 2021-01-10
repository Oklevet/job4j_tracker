package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        String[] s1 = o1.split("\\.");
        int a1 = Integer.parseInt(s1[0]);
        String[] s2 = o2.split("\\.");
        int a2 = Integer.parseInt(s2[0]);

        return Integer.compare(a1, a2);
    }
}