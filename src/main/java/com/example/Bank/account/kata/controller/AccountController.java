package com.example.Bank.account.kata.controller;

import com.example.Bank.account.kata.model.Transaction;
import com.example.Bank.account.kata.model.TransactionRequest;
import com.example.Bank.account.kata.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService service;
    @Autowired
    public AccountController(AccountService service) { this.service = service; }

    @PostMapping("/deposit")
    public Transaction deposit(@RequestBody @Valid TransactionRequest req) {
        return service.deposit(req.amount());
    }

    @PostMapping("/withdraw")
    public Transaction withdraw(@RequestBody @Valid TransactionRequest req) {
        return service.withdraw(req.amount());
    }

    @GetMapping("/statement")
    public List<Transaction> getStatement() {
        return service.getStatement();
    }
}