package ru.job4j.singletone;

import ru.job4j.tracker.Tracker;

public class TrackerSinglePrivateStaticSF {
    public static Tracker getinstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final Tracker INSTANCE = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSinglePrivateStaticSF.getinstance();
    }
}
