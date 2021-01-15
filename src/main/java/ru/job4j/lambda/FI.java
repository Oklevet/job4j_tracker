package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 20),
                new Attachment("image 3", 120),
                new Attachment("image 2", 23)
        };
        Comparator<String> cmpText = (left, right) ->  {
            return left.compareTo(right);
        };
        Comparator<String> cmpDescSize = (left, right) -> {
            return right.length() - left.length();
        };
    }
}
