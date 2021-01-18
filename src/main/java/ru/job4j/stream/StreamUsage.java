package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        List<Integer> positives = new ArrayList<>();
        nums.add(11);
        nums.add(-21);
        nums.add(51);
        nums.add(-81);
        nums.add(101);
        positives = nums.stream().filter(x -> x > 0).collect(Collectors.toList());
        positives.forEach(System.out::println);
    }
}
