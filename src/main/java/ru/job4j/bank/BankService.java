package ru.job4j.bank;

import java.util.*;

/**
 * Класс описывает методы работы банка
 * @author NIK STARTSEV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение клиентов банка осуществляется в коллекции типа HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавление нового клиента в БД банка
     * @param user новый клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Добавление нового счёта к списку счетов клиента
     * @param passport поиск клиента по паспортным данным
     * @param account добавляемый новый счет
     */
    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Выполняется поиск клиента по паспортным данным
     * @param passport паспортные данные искомого клиента
     * @return искомый клиент
     */
    public Optional<User> findByPassport(String passport) {
        Optional<User> rsl = users.keySet().stream()
                .filter(k -> k.getPassport().equals(passport))
                .findFirst();
        return rsl;
    }

    /**
     * Поиск аккаунта по его реквизитам.
     * Выполнение валидации на пример отсутствия искомого счета или клиента
     * @param passport на основе паспорта производится поиск клиента
     * @param requisite на основе реквизитов выполняется поиска счёта
     * @return искомый аккаунт
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(val -> users.get(val).stream()
                .filter(acc -> acc.getRequisite().equals(requisite))
                .findFirst());
    }

    /**
     * Выполняется перевод указанной суммы(amount) с одного счёта(src) на другой(dest)
     * производится валидация на пример нехватки средств на аккаунте, а так же неверно указанные
     * паспортные данные и реквизиты обоих счетов
     * @param srcPassport паспортные данные счета с которого переводят
     * @param srcRequisite реквизиты счета с которого переводят
     * @param destPassport паспортные данные счета на который переводят
     * @param destRequisite реквизиты счета на который переводят
     * @param amount сумма перевода
     * @return true - перевод выполнен, false - транзакция не прошла
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount.isPresent() && srcAccount.get().getBalance() >= amount
                && destAccount.isPresent()) {
            findByRequisite(srcPassport, srcRequisite).get()
                    .setBalance(srcAccount.get().getBalance() - amount);
            findByRequisite(destPassport, destRequisite).get()
                    .setBalance(destAccount.get().getBalance()
                    + amount);
            return true;
        }
        return false;
    }
}
