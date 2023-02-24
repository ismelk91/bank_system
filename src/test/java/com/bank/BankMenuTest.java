package com.bank;

import com.bank.service.BankService;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.mockito.Mockito.*;

class BankMenuTest {

    BankMenu bankMenu;
    BankAccount bankAccount;
    BankService bankService;

    @BeforeEach
    void setUp() {
        bankService = mock(BankService.class);
        bankAccount = new BankAccount("Ismail", "1");
        bankMenu = new BankMenu(bankService, bankAccount);
        bankAccount.setBalance(1000);
    }

    @Test
    void testDeposit() {
        String userInput = "b\n1000\ne";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        bankMenu.menu();
        verify(bankService,times(1)).deposit(bankAccount,1000);
    }


    @Test
    void testWithdraw() {
        String userInput = "c\n200\ne";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        bankMenu.menu();
        verify(bankService,times(1)).withdraw(bankAccount,200);
    }

    @Test
    void testWithdrawThrowsRuntimeException() {
        String userInput = "c\n200\ne";
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
        doThrow(new RuntimeException()).when(bankService).withdraw(any(),anyDouble());
        bankMenu.menu();
    }






}