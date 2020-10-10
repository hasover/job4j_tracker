package ru.job4j.lambda;

import java.util.Comparator;

public class StringComparator {
    public static void main(String[] args) {
        Comparator<String> comparator = (left, right) -> {
            System.out.println("Compare - " + left.length() + " : " + right.length());
            return Integer.compare(right.length(), left.length());
        };
    }
}
