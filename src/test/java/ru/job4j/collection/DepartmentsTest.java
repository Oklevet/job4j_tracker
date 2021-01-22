package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissedK2() {
        List<String> input = List.of("k2/sk2/ssk2");
        List<String> expect = List.of("k2", "k2/sk2", "k2/sk2/ssk2");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChangeK2() {
        List<String> input = List.of("k2", "k2/sk2", "k2/sk2/ssk2");
        List<String> expect = List.of("k2", "k2/sk2", "k2/sk2/ssk2");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }
}