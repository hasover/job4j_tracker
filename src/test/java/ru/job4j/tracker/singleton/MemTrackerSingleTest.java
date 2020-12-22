package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class MemTrackerSingleTest {
    @Test
    public void whenTestSingle1() {
        TrackerSingle1 one = TrackerSingle1.INSTANCE;
        TrackerSingle1 two = TrackerSingle1.INSTANCE;
        assertThat(one, is(two));
    }

    @Test
    public void whenTestSingle2() {
        TrackerSingle2 one = TrackerSingle2.getInstance();
        TrackerSingle2 two = TrackerSingle2.getInstance();
        assertThat(one, is(two));
    }

    @Test
    public void whenTestSingle3() {
        TrackerSingle3 one = TrackerSingle3.getInstance();
        TrackerSingle3 two = TrackerSingle3.getInstance();
        assertThat(one, is(two));
    }

    @Test
    public void whenTestSingle4() {
        TrackerSingle4 one = TrackerSingle4.getInstance();
        TrackerSingle4 two = TrackerSingle4.getInstance();
        assertThat(one, is(two));
    }

}