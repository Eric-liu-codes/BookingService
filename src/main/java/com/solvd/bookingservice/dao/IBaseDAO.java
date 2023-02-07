package com.solvd.bookingservice.dao;

import java.sql.SQLException;

public interface IBaseDAO<T> {
    T getEntityById(long id) throws SQLException, InterruptedException;
    void updateEntity(T entity) throws SQLException, InterruptedException;
    T createEntity(T entity) throws SQLException, InterruptedException;
    void removeEntity(long id) throws SQLException, InterruptedException;
}
