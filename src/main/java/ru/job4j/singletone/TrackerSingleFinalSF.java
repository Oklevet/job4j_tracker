package ru.job4j.singletone;

import ru.job4j.tracker.Tracker;

public class TrackerSingleFinalSF {
    private static final Tracker INSTANCE = new Tracker();

    public static Tracker getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSingleFinalSF.getInstance();
    }
}
