package ru.job4j.singletone;

import ru.job4j.tracker.Tracker;

public class TrackerSingle {
    private static Tracker instance;

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
