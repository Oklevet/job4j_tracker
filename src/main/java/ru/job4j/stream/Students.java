package ru.job4j.stream;

import java.util.Objects;

public class Students {
    private int score;
    private String surname;

    @Override
    public String toString() {
        return "Students{" +
                "score=" + score +
                ", surname='" + surname + '\'' +
                '}';
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScore() {
        return score;
    }

    public String getSurname() {
        return surname;
    }

    public Students(String surname, int score) {
        this.score = score;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Students student = (Students) o;
        return score == student.score &&
                surname.equals(student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, surname);
    }
}
