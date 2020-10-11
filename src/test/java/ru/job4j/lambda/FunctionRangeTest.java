package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FunctionRangeTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result =FunctionRange.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenSquareFunctionThenSquareResults() {
        List<Double> result =FunctionRange.diapason(1, 4, x -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D, 9D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        List<Double> result =FunctionRange.diapason(0, 3, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(1D, 2D, 4D);
        assertThat(result, is(expected));
    }


}