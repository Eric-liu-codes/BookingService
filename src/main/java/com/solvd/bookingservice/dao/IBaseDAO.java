package com.solvd.bookingservice.dao;

import java.sql.SQLException;

public interface IBaseDAO<T> {
    T getEntityById(long id) throws SQLException;
    boolean updateEntity(T entity);
    T createEntity(T entity);
    void removeEntity(long id);
}
