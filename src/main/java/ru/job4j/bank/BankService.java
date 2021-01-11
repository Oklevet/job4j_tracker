package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Добавление нового счёта к списку счетов клиента
     * @param passport поиск клиента по паспортным данным
     * @param account добавляемый новый счет
     */
    public void addAccount(String passport, Account account) {
        if (findByRequisite(findByPassport(passport).getPassport(),
                account.getRequisite()) == null) {
            users.get(findByPassport(passport)).add(account);
        }
    }

    /**
     * Выполняется поиск клиента по паспортным данным
     * @param passport паспортные данные искомого клиента
     * @return искомый клиент
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Поиск аккаунта по его реквизитам.
     * Выполнение валидации на пример отсутствия искомого счета или клиента
     * @param passport на основе паспорта производится поиск клиента
     * @param requisite на основе реквизитов выполняется поиска счёта
     * @return искомый аккаунт
     */
    public Account findByRequisite(String passport, String requisite) {
        List<Account> accounts = users.get(findByPassport(passport));
        if (accounts == null) {
            return null;
        }
        for (Account acc : accounts) {
            if (acc.getRequisite().equals(requisite)) {
                return acc;
            }
        }
        return null;
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
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);

        if (srcAccount != null && srcAccount.getBalance() >= amount
                && findByRequisite(destPassport, destRequisite) != null) {
            findByRequisite(srcPassport, srcRequisite).setBalance(srcAccount.getBalance() - amount);
            findByRequisite(destPassport, destRequisite).setBalance(destAccount.getBalance()
                    + amount);
            return true;
        }
        return false;
    }
}
