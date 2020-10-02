package ru.job4j.tracker;

public class EditAction implements UserAction {
    @Override
    public String name() {
        return "Edit item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the id:");
        String name = input.askStr("Enter the new name:");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Item replaced.");
        } else {
            System.out.println("No item with such id.");
        }
        return true;
    }
}
