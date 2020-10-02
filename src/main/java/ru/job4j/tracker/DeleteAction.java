package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the id:");
        if (tracker.delete(id)) {
            System.out.println("Item deleted.");
        } else {
            System.out.println("No item with such id.");
        }
        return true;
    }
}
