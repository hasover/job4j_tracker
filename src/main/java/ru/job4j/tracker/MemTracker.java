package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MemTracker implements Store {
    private final List<Item> items = new ArrayList();
    private int ids = 1;

    @Override
    public void init() {

    }

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findAll() {
        return items;
    }

    public List<Item> findByName(String key) {
        List<Item> itemsSameName = new ArrayList<>();
        for (Item item: items) {
            if (item.getName().equals(key)) {
                itemsSameName.add(item);
            }
        }
        return itemsSameName;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId() == id) {
               return i;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int rsl = indexOf(id);
        if (rsl == -1) {
            return false;
        }
        item.setId(id);
        items.set(rsl, item);
        return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        items.remove(index);
        return true;
    }

    @Override
    public void close() throws Exception {

    }
}