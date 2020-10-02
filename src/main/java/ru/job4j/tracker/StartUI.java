package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name:");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Item added");
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("List of items:");
        for (Item item: tracker.findAll()) {
            System.out.println(item);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Enter the id:"));
        String name = input.askStr("Enter the new name:");
        Item newItem = new Item(name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Item replaced.");
        } else {
            System.out.println("No item with such id.");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Enter the id:"));
        if (tracker.delete(id)) {
            System.out.println("Item deleted.");
        } else {
            System.out.println("No item with such id.");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askInt("Enter the id:"));
        Item foundItem = tracker.findById(id);
        if (foundItem !=null) {
            System.out.println("Item: " + foundItem);
        } else {
            System.out.println("No item with such id.");
        }
    }

    public static void findItemsByName(Input input, Tracker tracker) {
        String name = input.askStr("Enter the name:");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            System.out.println("List of items:");
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("No items with such id.");
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askInt("Select:"));
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
                StartUI.editItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemById(input, tracker);
            } else if (select == 5) {
                StartUI.findItemsByName(input, tracker);
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