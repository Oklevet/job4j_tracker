package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class SearchAtt {
    private static List<Attachment> filter(List<Attachment> list,
                                           UnaryOperator<List<Attachment>> func) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            rsl.add(func.apply(att));
        }
        return rsl;
    }

    public static List<Attachment> filterSize(List<Attachment> list) {
        UnaryOperator<List<Attachment>> func = new UnaryOperator<List<Attachment>>() {
            @Override
            public List<Attachment> apply(List<Attachment> attachments) {
                if (attachments.getSize() > 100) {
                    return attachments;
                }
                return null;
            }
        };
        return filter(list, func);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        UnaryOperator<List<Attachment>> func = new UnaryOperator<List<Attachment>>() {
            @Override
            public List<Attachment> apply(List<Attachment> attachments) {
                if (attachments.getName().contains("bug")) {
                    return attachments;
                }
                return null;
            }
        };
        return filter(list, func);
    }
}
