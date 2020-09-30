package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
       Tracker tracker = new Tracker();
       Item one = new Item();
       one.setId(1);
       one.setName("First");
       tracker.add(one);
       Item found = tracker.findById(1);
        System.out.println(found.getId() + " " + found.getName());
    }
}
