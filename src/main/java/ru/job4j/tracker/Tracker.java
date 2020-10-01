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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items,size);
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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int rsl = indexOf(id);
        if (rsl == -1) {
            return false;
        }
        items[rsl] = item;
        items[rsl].setId(id);
        return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        System.arraycopy(items,index + 1, items, index, size - index);
        items[size--] = null;
        return true;
    }
}