package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        return Integer.compare(extractNumber(left), extractNumber(right));
    }
    private int extractNumber(String string) {
        int i = 0;
        String str = "";
        while(Character.isDigit(string.charAt(i))) {
            str +=string.charAt(i);
            i++;
        }
        return Integer.valueOf(str);
    }
}