package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс моделирует работу банка по предоставлению некоторых популярных услуг.
 * @author Khasan Akhmetvaleev
 * @version 1.0
 */

public class BankService {
    /**
     * Хранение пользователей и их счетов осуществляется в коллекции HashMap
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в базу банка, если его еще там нет.
     * @param user добавляемый пользователь
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает номер паспорта клиента и счет, который нужно открыть.
     * Клиент должен быть в базе банка, а счет не должен никому принадлежать.
     * @param passport паспорт клиента
     * @param account новый счет
     */

    public void addAccount(String passport, Account account) {
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            return;
        }
        List<Account> accounts = users.get(user.get());
        if (!accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Метод ищет пользователя по паспорту
     * @param passport паспорт пользователя
     * @return возвращает {@code Optional<User>} найденного пользователя,
     * или пустой {@code Optional<User>}, если такого пользователя нет
     */

    public Optional<User> findByPassport(String passport) {
        Optional<User> user = users.keySet()
                                .stream()
                                .filter(x -> x.getPassport().equals(passport))
                                .findFirst();
        return user;
    }

    /**
     * Метод ищет счет по паспорту и реквизиту счета
     * @param passport паспорт коиента
     * @param requisite реквезиты счета
     * @return возвращает {@code Optional<Account>}, который содержит найденный счет,
     * или пустой {@code Optional<Account>}, если такого счета нет
     */

    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isEmpty()) {
            return Optional.empty();
        }
        List<Account> accounts = users.get(user.get());
        Optional<Account> found = accounts
                              .stream()
                              .filter(x -> x.getRequisite().equals(requisite))
                              .findFirst();
        return found;
    }

    /**
     * Метод переводит заданное количество с одного счета на другой.
     * Счета должны быть действительны, а средства на счете достаточны для перевода
     * @param srcPassport паспорт отправителя
     * @param srcRequisite реквизиты счета отправителя
     * @param destPassport паспорт получателя
     * @param destRequisite реквизиты получателя
     * @param amount сумма переаода
     * @return {@code true} если перевод успешен
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isEmpty() || destAccount.isEmpty()
                || srcAccount.get().getBalance() < amount) {
            return rsl;
        }
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
        rsl = true;
        return rsl;
    }
}