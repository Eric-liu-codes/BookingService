package com.solvd.bookingservice.services;

import com.solvd.bookingservice.bookingservices.Account;
import com.solvd.bookingservice.daoclasses.AccountDAO;

public class AccountServices {
    private final AccountDAO accountDAO;

    public AccountServices() {
        this.accountDAO = new AccountDAO();
    }

    public AccountServices(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    public Account getAccountById(long id) throws InterruptedException {
        return this.accountDAO.getEntityById(id);
    }

    public void updateAccount(Account account) throws InterruptedException {
        this.accountDAO.updateEntity(account);
    }

    public Account createAccount(Account account) throws InterruptedException {
        return this.accountDAO.createEntity(account);
    }

    public void deleteAccount(long id) throws InterruptedException {
        this.accountDAO.removeEntity(id);
    }
}
