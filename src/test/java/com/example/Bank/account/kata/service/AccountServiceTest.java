package com.example.Bank.account.kata.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountServiceTest {
    private AccountService service;

    @BeforeEach
    void init() {
        service = new AccountService();
    }

    @Test @DisplayName("Dépôt positif augmente le solde")
    void testDeposit() {
        var tx = service.deposit(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), tx.getBalance());
        assertEquals(1, service.getStatement().size());
    }

    @Test
    @DisplayName("Retrait possible si fonds suffisants")
    void testWithdraw() {
        service.deposit(BigDecimal.valueOf(200));
        var tx = service.withdraw(BigDecimal.valueOf(150));
        assertEquals(BigDecimal.valueOf(50), tx.getBalance());
    }

    @Test @DisplayName("Erreur si retrait > solde")
    void testWithdrawInsufficient() {
        assertThrows(IllegalArgumentException.class, () -> service.withdraw(BigDecimal.TEN));
    }
}
