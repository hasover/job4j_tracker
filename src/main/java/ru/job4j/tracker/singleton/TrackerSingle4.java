package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingle4 {
    private Tracker tracker;

    private TrackerSingle4() {
        tracker = new Tracker();
    }

    public static TrackerSingle4 getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingle4 INSTANCE = new TrackerSingle4();
    }

    public Tracker getTracker() {
        return tracker;
    }
}