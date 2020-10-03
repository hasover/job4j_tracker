package ru.job4j.tracker;

public class EditAction implements UserAction {

    private final Output out;

    public EditAction(Output out) {
        this.out = out;
    }
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
            out.println("Item replaced.");
        } else {
            out.println("No item with such id.");
        }
        return true;
    }
}
