package ru.job4j.tracker;

public class CreateAction implements  UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create an item";
    }

    @Override
    public boolean execute(Input input, Store storeTracker) {
        out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        storeTracker.add(item);
        out.println("Item added");
        return true;
    }
}
