package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class functionTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenQuadResults() {
        List<Double> result = function.diapason(2, 5, x -> x * x + 1);
        List<Double> expected = Arrays.asList(5D, 10D, 17D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionThenExponentResults() {
        List<Double> result = function.diapason(3, 6, x -> Math.pow(2, x) + 1);
        List<Double> expected = Arrays.asList(9D, 17D, 33D);
        assertThat(result, is(expected));
    }
}