package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the id:");
        Item foundItem = tracker.findById(id);
        if (foundItem != null) {
            out.println("Item: " + foundItem);
        } else {
            out.println("No item with such id.");
        }
        return true;
    }
}
