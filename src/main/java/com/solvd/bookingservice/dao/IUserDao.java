package com.solvd.bookingservice.dao;
import java.sql.SQLException;
import java.util.List;

public interface IUserDao<T> {
    List<T> getAllUsers() throws SQLException, InterruptedException;
}
