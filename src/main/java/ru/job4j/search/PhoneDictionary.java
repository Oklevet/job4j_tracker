package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private final ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predName = a -> a.getName().equals(key);
        Predicate<Person> predSurname = a -> a.getSurname().equals(key);
        Predicate<Person> predPhone = a -> a.getPhone().equals(key);
        Predicate<Person> predAddress = a -> a.getAddress().equals(key);
        Predicate<Person> combine = predName.or(predSurname).or(predPhone).or(predAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
