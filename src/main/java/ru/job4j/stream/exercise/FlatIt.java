package ru.job4j.stream.exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  https://job4j.ru/edu/task_code?topicId=3&taskCodeId=14&solutionId=21783
 *  Как здесь следовало применить flatMap?
 */
public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {
        List<Integer> arr = new ArrayList<>();
        it.forEachRemaining(iter -> iter.forEachRemaining(arr::add));
        return arr;
    }
}
