package com.example.Bank.account.kata.service;

import com.example.Bank.account.kata.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface IAccountService {
    Transaction deposit(BigDecimal amount);
    Transaction withdraw(BigDecimal amount);
    List<Transaction> getStatement();
}
