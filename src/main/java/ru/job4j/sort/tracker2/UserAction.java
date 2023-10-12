package ru.job4j.sort.tracker2;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
