package ru.job4j.search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public ArrayList<Person> find(String key) {
        var result = new ArrayList<Person>();
        Predicate<Person> compareName = person -> person.getName().contains(key);
        Predicate<Person> compareSurname = person -> person.getSurname().contains(key);
        Predicate<Person> compareAddress = person -> person.getAddress().contains(key);
        Predicate<Person> comparePhone = person -> person.getPhone().contains(key);
        Predicate<Person> combine = compareName.
                                    or(compareSurname)
                                    .or(compareAddress)
                                    .or(comparePhone);
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}