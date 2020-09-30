package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[size];
        int notNull = 0;
        for (int i = 0; i < size; i++) {
            if (items[i] != null) {
                itemsWithoutNull[notNull++] = items[i];
            }
        }
        return Arrays.copyOf(itemsWithoutNull,notNull);
    }

    public Item[] findByName(String key) {
        Item[] itemsSameName = new Item[size];
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                itemsSameName[newSize++] = items[i];
            }
        }
        return Arrays.copyOf(itemsSameName,newSize);
    }
}