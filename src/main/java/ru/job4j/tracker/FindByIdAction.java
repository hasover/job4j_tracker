package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter the id:");
        Item foundItem = tracker.findById(id);
        if (foundItem !=null) {
            System.out.println("Item: " + foundItem);
        } else {
            System.out.println("No item with such id.");
        }
        return true;
    }
}
