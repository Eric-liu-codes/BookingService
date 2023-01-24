package com.solvd.bookingservice.dao;

import java.sql.SQLException;

public interface IBaseDAO<T> {
    T getEntityById(long id) throws SQLException, InterruptedException;
}
