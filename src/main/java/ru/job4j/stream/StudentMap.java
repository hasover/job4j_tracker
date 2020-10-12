package ru.job4j.stream;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    public static Map<String, Student> toMap(List<Student> students) {
        return students
                .stream()
                .collect(Collectors.toMap(Student::getSurname, x -> x, (exist, replace) -> replace));
    }
}
