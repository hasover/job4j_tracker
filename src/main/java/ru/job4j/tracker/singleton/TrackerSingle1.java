package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public enum TrackerSingle1 {
    INSTANCE;
    final private Tracker tracker = new Tracker();
}
