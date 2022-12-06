package ru.job4j.stream.exercise;

import java.util.List;

public class ReductionWithTwoArguments {
    public static Integer collect(List<Integer> list) {
        return list.stream()
                .reduce(5, (a, b) -> a * b);
    }
}
