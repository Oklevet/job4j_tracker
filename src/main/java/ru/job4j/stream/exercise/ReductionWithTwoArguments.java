package ru.job4j.stream.exercise;

import java.util.List;

/**
 * https://job4j.ru/edu/task_code?topicId=3&taskCodeId=100&solutionId=21779
 * Летит ошибка в компиляторе на сайте. В самой IDEA тест пройден.
 *
 * error: invalid flag: /root/job4j_edu/sandbox/0873958f763d8a3901764d7a70d655c5/
 * Usage: javac <options> <source files>
 * use --help for a list of possible options
 */
public class ReductionWithTwoArguments {
    public static Integer collect(List<Integer> list) {
        return list.stream()
                .reduce(5, (a, b) -> a * b);
    }
}
