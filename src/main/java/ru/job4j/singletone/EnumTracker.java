package ru.job4j.singletone;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.List;

public enum EnumTracker {
    INSTANCE;
    private Tracker tracker = new Tracker();
    public Tracker getInstance() {
        return tracker;
    }
}
