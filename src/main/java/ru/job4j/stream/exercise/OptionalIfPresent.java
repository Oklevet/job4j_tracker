package ru.job4j.stream.exercise;

import java.util.Arrays;
import java.util.OptionalInt;

public class OptionalIfPresent {
    public static void ifPresent(int[] data) {
        OptionalInt mx = max(data);
        if (mx.isPresent()) {
            System.out.println("Max: " + mx.getAsInt());
        }
        /**
         * alternative
         * max(data).stream()
         *                 .findFirst()
         *                 .isPresent(x -> System.out.println("Max: " + x.getAsInt()));
         */

    }

    private static OptionalInt max(int[] data) {
        OptionalInt m = Arrays.stream(data).reduce(Integer::max);
        return m;
    }
}
