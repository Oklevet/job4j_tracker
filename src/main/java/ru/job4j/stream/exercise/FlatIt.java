package ru.job4j.stream.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Integer> arr = new ArrayList<>();
        it.forEachRemaining(iter -> iter.forEachRemaining(arr::add));
        return arr;
    }
}
