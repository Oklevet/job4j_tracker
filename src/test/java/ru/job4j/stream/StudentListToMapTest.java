package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentListToMapTest {
    private List<Student> students;
    private Student st1 = new Student(50, "qwe");
    private Student st2 = new Student(45, "asd");
    private Student st3 = new Student(75, "qwe");
    private Student st4 = new Student(50, "fgh");
    private Student st5 = new Student(50, "zxc");
    private Student st6 = new Student(14, "asd");

    @Before
    public void set() {
        students = List.of(st1, st2, st3, st4, st5, st6);
    }

    @Test
    public void sort() {
        Map<String, Student> expected = new HashMap<>();
        expected.put("asd", st6);
        expected.put("fgh", st4);
        expected.put("qwe", st3);
        expected.put("zxc", st5);
        Map<String, Student> rsl = StudentListToMap.sortList(students);
        assertThat(rsl, is(expected));
    }
}