package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askInt("Select:"));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name:");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Item added");
            } else if (select == 1) {
                System.out.println("List of items:");
                for (Item item: tracker.findAll()) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                int id = Integer.valueOf(input.askInt("Enter the id:"));
                String name = input.askStr("Enter the new name:");
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Item replaced.");
                } else {
                    System.out.println("No item with such id.");
                }
            } else if (select == 3) {
                int id = Integer.valueOf(input.askInt("Enter the id:"));
                if (tracker.delete(id)) {
                    System.out.println("Item deleted.");
                } else {
                    System.out.println("No item with such id.");
                }
            } else if (select == 4) {
                int id = Integer.valueOf(input.askInt("Enter the id:"));
                Item foundItem = tracker.findById(id);
                if (foundItem !=null) {
                    System.out.println("Item: " + foundItem);
                } else {
                    System.out.println("No item with such id.");
                }

            } else if (select == 5) {
                String name = input.askStr("Enter the name:");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    System.out.println("List of items:");
                    for (Item item: items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("no items with such name.");
                }
            } else if (select ==6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");

    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}