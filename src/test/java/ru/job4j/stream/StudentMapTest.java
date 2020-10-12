package ru.job4j.stream;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StudentMapTest {

    @Test
    public void testStudentMap() {
        Student ivanov = new Student(10, "Ivanov");
        Student petrov = new Student(30, "Petrov");
        Student sidorov = new Student(50, "Sidorov");
        Student ivanov2 = new Student(70, "Ivanov");
        List<Student> students = List.of(ivanov, petrov, sidorov, ivanov2);
        Map<String, Student> studentMap = StudentMap.toMap(students);
        boolean result = studentMap.get("Ivanov").equals(ivanov2)
                         && studentMap.get("Petrov").equals(petrov)
                         && studentMap.get("Sidorov").equals(sidorov);
        assertThat(result, is(true));

    }

}