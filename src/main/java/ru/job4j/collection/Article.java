package ru.job4j.collection;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> orig = new HashSet<>(Arrays.asList(origin.toLowerCase().split("\\b")));
        List<String> find = List.of(line.toLowerCase().split(" "));
        for (String s : find) {
            if (!orig.contains(s)) {
                return false;
            }
        }
        return true;
    }
}
