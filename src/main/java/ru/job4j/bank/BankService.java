package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

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

    public Optional<User> findByPassport(String passport) {
        Optional<User> user = users.keySet()
                                .stream()
                                .filter(x -> x.getPassport().equals(passport))
                                .findFirst();
        return user;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.isEmpty() || destAccount.isEmpty() || srcAccount.get().getBalance() < amount) {
            return rsl;
        }
        destAccount.get().setBalance(destAccount.get().getBalance() + amount);
        srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
        rsl = true;
        return rsl;
    }
}