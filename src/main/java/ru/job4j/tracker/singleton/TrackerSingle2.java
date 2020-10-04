package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;

    private Tracker tracker;

    private TrackerSingle2() {
        tracker = new Tracker();
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }

    public Tracker getTracker() {
        return tracker;
    }
}