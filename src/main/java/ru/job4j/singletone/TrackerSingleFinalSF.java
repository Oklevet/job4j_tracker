package ru.job4j.singletone;

import ru.job4j.tracker.Tracker;

public class TrackerSingleFinalSF {
    private static final Tracker instance = new Tracker();

    public static Tracker getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleFinalSF.getInstance();
    }
}
