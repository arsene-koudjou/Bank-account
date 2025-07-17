package com.example.Bank.account.kata.model;

import jdk.jfr.DataAmount;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
public class Transaction {
    private final LocalDateTime date;
    private final BigDecimal amount;
    private final BigDecimal balance;

    public Transaction(LocalDateTime date, BigDecimal amount, BigDecimal balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }
}
