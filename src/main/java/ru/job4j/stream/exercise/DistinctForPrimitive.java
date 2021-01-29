package ru.job4j.stream.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://job4j.ru/edu/task_code?topicId=3&taskCodeId=87&solutionId=0
 * Для чего понадобилось боксить примитивный тип? Из-за Integer в возврате?
 * вроде бы до этого работало, или я не замечал.
 *
 * Летит ошибка в компиляторе на сайте. В самой IDEA тест пройден.
 *
 * error: invalid flag: /root/job4j_edu/sandbox/0873958f763d8a3901764d7a70d655c5/
 * Usage: javac <options> <source files>
 * use --help for a list of possible options
 */
public class DistinctForPrimitive {
    public static List<Integer> collect(int[] data) {
        return Arrays.stream(data)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
    }
}
