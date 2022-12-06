package ru.job4j.stream.exercise;

import java.util.List;
import java.util.stream.Collectors;

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
