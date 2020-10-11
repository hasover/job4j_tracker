package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListFilter {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(-6);
        list.add(10);
        list.add(-4);
        list.add(-1);
        List<Integer> newList = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        newList.forEach(System.out::println);

    }
}
