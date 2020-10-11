package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list, String name) {
        Predicate<Attachment> predicate = new Predicate<>() {
            @Override
            public boolean test(Attachment o) {
                return o.getName().contains(name);
            }
        };
        return filter(list, predicate);
    }

    public static List<Attachment> filterSize(List<Attachment> list, int size) {
        Predicate<Attachment> predicate = new Predicate<>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > size;
            }
        };
        return filter(list, predicate);
    }

    private static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        List<Attachment> list = Arrays.asList(new Attachment("Aa", 50), new Attachment("Bb", 100));
        System.out.println(filterSize(list, 70));
        System.out.println(filterName(list, "a"));
    }

}