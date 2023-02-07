package com.solvd.bookingservice.dao;
import com.solvd.bookingservice.bookingservices.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountDao<T> {
    List<T> getAllAccounts() throws SQLException, InterruptedException;
}
