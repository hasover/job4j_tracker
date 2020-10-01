package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select:");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name:");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("List of items:");
                for (Item item: tracker.findAll()) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.print("Enter the id:");
                int id = Integer.valueOf(scanner.nextLine());
                System.out.print("Enter the new name:");
                String name = scanner.nextLine();
                Item newItem = new Item(name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Item replaced.");
                } else {
                    System.out.println("No item with such id.");
                }
            } else if (select == 3) {
                System.out.print("Enter the id:");
                int id = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Item deleted.");
                } else {
                    System.out.println("No item with such id.");
                }
            } else if (select == 4) {
                System.out.print("Enter the id:");
                int id = Integer.valueOf(scanner.nextLine());
                Item foundItem = tracker.findById(id);
                if (foundItem !=null) {
                    System.out.println("Item: " + foundItem);
                } else {
                    System.out.println("No item with such id.");
                }

            } else if (select == 5) {
                System.out.print("Enter the name:");
                String name = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}