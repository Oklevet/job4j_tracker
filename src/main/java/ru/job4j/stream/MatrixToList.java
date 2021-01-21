package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixToList {
    static List<Integer> transform (Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(a -> Stream.of(a)).collect(Collectors.toList());
    }
}
