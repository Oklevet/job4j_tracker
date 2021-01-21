package ru.job4j.stream;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentListToMap {
    Map<String, Student> students = new HashMap<>();
    static Map<String, Student> sortList(List<Student> studs) {
        return studs.stream()
                .collect(Collectors.toMap(Student::getSurname, obj -> obj
                    ,(existing, replacement) -> replacement));
    }
}
