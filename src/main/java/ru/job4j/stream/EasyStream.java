package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    final private List<Integer> stream;

    private EasyStream(List<Integer> source) {
        stream = new ArrayList<>(source);
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);

    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> mapList = new ArrayList<>();
        if (!stream.isEmpty()) {
            for (Integer i : stream) {
                mapList.add(fun.apply(i));
            }
        }
        return new EasyStream(mapList);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> filterList = new ArrayList<>();
        if (!stream.isEmpty()) {
            for (Integer i : stream) {
                if (fun.test(i)) {
                    filterList.add(i);
                }
            }
        }
        return new EasyStream(filterList);
    }

    public List<Integer> collect() {
        return new ArrayList<>(stream);
    }
}
