package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {
    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> isPos) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (isPos.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
