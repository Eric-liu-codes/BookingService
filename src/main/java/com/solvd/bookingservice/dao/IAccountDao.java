package com.solvd.bookingservice.dao;
import java.util.List;

public interface IAccountDao<T> {
    List<T> getAllAccounts();
    T getAccountByID(long id);
    void createAccount(T account);
    void updateAccount(T account);
    void deleteAccount(T account);
}
