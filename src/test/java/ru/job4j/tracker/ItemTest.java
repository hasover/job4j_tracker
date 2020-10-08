package ru.job4j.tracker;
import static org.hamcrest.Matchers.is;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void sortItems() {
        List<Item> items = Arrays.asList(new Item(5, "A"),
                                         new Item(2, "B"),
                                         new Item(3, "C"));
        Collections.sort(items, new SortItems());
        assertThat(items, is(Arrays.asList(new Item(2, "B"),
                                            new Item(3, "C"),
                                            new Item(5, "A"))));
    }

    @Test
    public void sortItemsReverse() {
        List<Item> items = Arrays.asList(new Item(5, "A"),
                                         new Item(2, "B"),
                                         new Item(3, "C"));
        Collections.sort(items, new SortItemsByNameReverse());
        assertThat(items, is(Arrays.asList(new Item(3, "C"),
                                           new Item(2, "B"),
                                           new Item(5, "A"))));
    }
}