package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public class TrackerSingle2 {
    private static TrackerSingle2 instance;

    private MemTracker memTracker;

    private TrackerSingle2() {
        memTracker = new MemTracker();
    }

    public static TrackerSingle2 getInstance() {
        if (instance == null) {
            instance = new TrackerSingle2();
        }
        return instance;
    }

    public MemTracker getMemTracker() {
        return memTracker;
    }
}