package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class FI {
    public static void main(String[] args) {
        Attachment[] atts = {
                new Attachment("image 1", 28),
                new Attachment("image 3", 20),
                new Attachment("image 2", 23)
        };
        Comparator<Attachment> cmpText = (left, right) ->  {
            System.out.println("compare - from " + right.getSize()
                    + "(maximum) to " + left.getSize() + "(minimum)");
            return left.getSize() - (right.getSize());
        };
        Comparator<Attachment> cmpDescSize = (left, right) -> {
            System.out.println("compare - from " + right.getName().length()
                    + "(maximum) to " + left.getName().length() + "(minimum)");
            return right.getName().length() - left.getName().length();
        };
        Comparator<Attachment> comparator = (left, right)
                -> left.getSize() - right.getSize();
        Arrays.sort(atts, cmpText);
        for (Attachment a : atts) {
            System.out.println(a);
        }
    }
}
