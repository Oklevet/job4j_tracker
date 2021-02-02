package ru.job4j.collection;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Article {
    public static boolean generateBy(String origin, String line) {
        Set<String> orig = new HashSet<>(Arrays.asList(origin.toLowerCase().split("\\b")));
        List<String> isEmptyStr = Arrays.stream(line.toLowerCase().split(" "))
                .filter(Predicate.not(s -> (orig.contains(s))))
                .collect(Collectors.toList());
        return isEmptyStr.isEmpty();
    }
}
