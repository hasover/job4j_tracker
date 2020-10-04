package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    private Tracker tracker;

    private TrackerSingle3() {
        tracker = new Tracker();
    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }

    public Tracker getTracker() {
        return tracker;
    }
}