package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int maxLength = Math.max(o1.length(), o2.length());
        for (int i = 0; i < maxLength; i++) {
            if(o1.length() == i && o2.length() == i) {
                return 0;
            } else if (o1.length() == i) {
                return 0 - o2.charAt(i);
            } else if (o2.length() == i) {
                return o1.charAt(i);
            }
            int ccomp = Character.compare(o1.charAt(i), o2.charAt(i));
            if (ccomp != 0) {
                return ccomp;
            }
        }
        return 0;
    }
}
