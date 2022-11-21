package com.margo.kata.service;

public interface TransactionsService {

    boolean withdraw(double amount, String iban);

    void save(double amount, String iban, String label);

}
