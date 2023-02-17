package com.bank.service;

import com.bank.BankAccount;
import com.bank.service.impl.BankServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BankServiceTest {

    private BankAccount bankAccount;
    private BankService bankService;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount("Ismail","1");
        bankService = new BankServiceImpl();
    }

    @Test
    void testWithdraw() {
        bankAccount.setBalance(500);
        bankService.withdraw(bankAccount,300);
        double balance = bankAccount.getBalance();
        Assertions.assertEquals(200,balance);
    }

}