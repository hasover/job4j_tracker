package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public class TrackerSingle3 {
    private static final TrackerSingle3 INSTANCE = new TrackerSingle3();
    private MemTracker memTracker;

    private TrackerSingle3() {
        memTracker = new MemTracker();
    }

    public static TrackerSingle3 getInstance() {
        return INSTANCE;
    }

    public MemTracker getMemTracker() {
        return memTracker;
    }
}