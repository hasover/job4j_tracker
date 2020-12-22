package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public enum TrackerSingle1 {
    INSTANCE;
    final private MemTracker memTracker = new MemTracker();
}
