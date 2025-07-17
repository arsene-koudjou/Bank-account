package com.example.Bank.account.kata.service;

import com.example.Bank.account.kata.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AccountService implements IAccountService  {
    private BigDecimal balance = BigDecimal.ZERO;
    private final List<Transaction> transactions = new ArrayList<>();

    public synchronized Transaction deposit(BigDecimal amount) {
        validate(amount);
        balance = balance.add(amount);
        return record(amount);
    }

    public synchronized Transaction withdraw(BigDecimal amount) {
        validate(amount);
        if (amount.compareTo(balance) > 0) throw new IllegalArgumentException("Fonds insuffisants");
        balance = balance.subtract(amount);
        return record(amount.negate());
    }

    public List<Transaction> getStatement() {
        return Collections.unmodifiableList(transactions);
    }

    private void validate(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Doit être > 0");
    }

    private Transaction record(BigDecimal amount) {
        var tx = new Transaction(LocalDateTime.now(), amount, balance);
        transactions.add(tx);
        return tx;
    }
}