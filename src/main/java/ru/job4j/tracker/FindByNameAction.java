package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Store storeTracker) {
        String name = input.askStr("Enter the name:");
        List<Item> items = storeTracker.findByName(name);
        if (items.size() > 0) {
            out.println("List of items:");
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("No items with such id.");
        }
        return true;
    }
}
