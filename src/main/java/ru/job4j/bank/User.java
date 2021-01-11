package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает клиентов банка
 * @author NIK STARTSEV
 * @version 1.0
 */
public class User {
    /**
     * параметры клиентов банка: номер паспорта, ФИО
     */
    private String passport;
    private String username;

    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод принимает на вход значение паспорта из списка
     * имеющихся в банке и осуществляет сравнение.
     * @param o passport из списка имеющихся
     * @return true - совпадение по искомому паспорту подтверждено. false - нет совпадения.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Получение хэшкода объекта паспорт
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
