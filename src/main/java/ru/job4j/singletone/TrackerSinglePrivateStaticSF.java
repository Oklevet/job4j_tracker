package ru.job4j.singletone;

import ru.job4j.tracker.Tracker;

public class TrackerSinglePrivateStaticSF {
    public static Tracker getinstance() {
        return Holder.instance;
    }

    private static final class Holder {
        private static final Tracker instance = new Tracker();
    }

    public static void main(String[] args) {
        Tracker tracker = TrackerSinglePrivateStaticSF.getinstance();
    }
}
