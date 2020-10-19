package ru.job4j.stream;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import java.util.List;

import static org.junit.Assert.*;

public class MatrixToListTest {
    @Test
    public void convert() {
        Integer[][] array = {{4, 7, 6}, {5, 9}, {1}};
        assertThat(MatrixToList.toList(array), is(List.of(4, 7, 6, 5, 9, 1)));
    }

}