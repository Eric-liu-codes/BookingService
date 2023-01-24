package com.solvd.bookingservice.dao;
import com.solvd.bookingservice.bookingservices.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao<T> {
    List<T> getAllAccounts() throws SQLException, InterruptedException;

    Account getAccountByID(long id) throws SQLException, InterruptedException;

    void createAccount(Account account) throws SQLException, InterruptedException;

    void updateAccount(Account account) throws SQLException, InterruptedException;

    void deleteAccount(Account account) throws InterruptedException, SQLException;
}
