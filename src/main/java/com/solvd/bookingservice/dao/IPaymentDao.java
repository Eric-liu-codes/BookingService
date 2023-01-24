package com.solvd.bookingservice.dao;
import java.sql.SQLException;
import java.util.List;

public interface IPaymentDao<T> {
    List<T> getAllPayments() throws SQLException, InterruptedException;
}
