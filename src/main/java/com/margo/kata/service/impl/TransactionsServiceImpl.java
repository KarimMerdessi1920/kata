package com.margo.kata.service.impl;

import com.margo.kata.dao.AccountRepository;
import com.margo.kata.dao.TransactionRepository;
import com.margo.kata.model.Account;
import com.margo.kata.model.Transaction;
import com.margo.kata.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionsServiceImpl implements TransactionsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public boolean withdraw(double amount, String iban) {
        Account account = accountRepository.findByIban(iban);
        double balanceAfter = account.getBalance() - amount;
        if (balanceAfter >= account.getAccountMinimumBalance()) {
            Transaction t = new Transaction();
            t.setAccountIban(iban);
            t.setLabel("WITHDRAWAL");
            t.setTransactionDate(new Date());
            t.setTransactionValue(-1 * amount);
            t.setBalanceAfter(balanceAfter);
            transactionRepository.save(t);
            account.setBalance(balanceAfter);
            accountRepository.save(account);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save(double amount, String iban, String label) {
        Account account = accountRepository.findByIban(iban);
        double balanceAfter = account.getBalance() + amount;
        Transaction t = new Transaction();
        t.setAccountIban(iban);
        t.setLabel(label);
        t.setTransactionDate(new Date());
        t.setTransactionValue(amount);
        t.setBalanceAfter(balanceAfter);
        transactionRepository.save(t);
        account.setBalance(balanceAfter);
        accountRepository.save(account);
    }
}
