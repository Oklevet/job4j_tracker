package ru.job4j.tracker_ver_2;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
