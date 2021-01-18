package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class function {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> answer = new ArrayList<>();
        for (int i = start; i < end; i++) {
            answer.add(func.apply((double) i));
        }
        return answer;
    }
}