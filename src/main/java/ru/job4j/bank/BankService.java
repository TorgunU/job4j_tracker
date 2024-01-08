package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        users.remove(user);
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> userAccounts = users.get(user);
        if (userAccounts.contains(account)) {
            return;
        }
        userAccounts.add(account);
    }

    public User findByPassport(String passport) {
        User findedUser = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                findedUser = user;
                break;
            }
        }
        return findedUser;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account findedAccount = null;
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> userAccounts = users.get(user);
        for (Account account : userAccounts) {
            if (requisite.equals(account.getRequisite())) {
                findedAccount = account;
                break;
            }
        }
        return findedAccount;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        if (sourceAccount == null) {
            return result;
        }
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (destinationAccount == null) {
            return result;
        }
        double sourceBalance = sourceAccount.getBalance();
        if (sourceBalance < amount) {
            return false;
        }
        sourceBalance -= amount;
        sourceAccount.setBalance(sourceBalance);
        destinationAccount.setBalance(destinationAccount.getBalance() + amount);
        result = true;
        return result;
    }

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}