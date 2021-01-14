package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                 tmp.add(start + el);
                 start += el + "/";
            }
        }
        for (String s : tmp) {
            System.out.println(s);
        }
        return new ArrayList<>(tmp);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Comparator comp = new DepDescComp();
        Collections.sort(orgs, comp);
    }
}
