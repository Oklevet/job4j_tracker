package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        names.forEach(System.out::println);         //неформатируемый вывод

        // StringIndexOutOfBoundsException
        //names.stream().map((x) -> x.substring(0, 10)).forEach(System.out::println);
    }
}
