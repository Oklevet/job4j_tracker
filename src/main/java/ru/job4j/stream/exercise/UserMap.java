package ru.job4j.stream.exercise;

import java.util.List;
import java.util.stream.Collectors;

/**
 * https://job4j.ru/edu/task_code?topicId=3&taskCodeId=78&solutionId=21971
 * Летит ошибка в компиляторе на сайте. В самой IDEA тест пройден.
 *
 * error: invalid flag: /root/job4j_edu/sandbox/0873958f763d8a3901764d7a70d655c5/
 * Usage: javac <options> <source files>
 * use --help for a list of possible options
 */
public class UserMap {
    public static class User {
        private int age;

        public User(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }
    }

    public static List<User> map(List<Integer> ages) {
        return ages.stream()
                .map(a -> new User(a))
                .collect(Collectors.toList());
    }
}
