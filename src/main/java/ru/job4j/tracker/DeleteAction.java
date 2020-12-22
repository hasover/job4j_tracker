package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Store storeTracker) {
        int id = input.askInt("Enter the id:");
        if (storeTracker.delete(id)) {
            out.println("Item deleted.");
        } else {
            out.println("No item with such id.");
        }
        return true;
    }
}
