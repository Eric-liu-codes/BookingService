package com.solvd.bookingservice.dao.daoclasses;

import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IAccountDao;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;


public class AccountDAO extends MySQLDAO implements IAccountDao {

    @Override
    public List getAllAccounts() {
        return null;
    }

    @Override
    public Object getAccountByID(long id) {
        return null;
    }

    @Override
    public void createAccount(Object account) {

    }

    @Override
    public void updateAccount(Object account) {

    }

    @Override
    public void deleteAccount(Object account) {

    }

    @Override
    public Object getEntityById(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean updateEntity(Object entity) {
        return false;
    }

    @Override
    public Object createEntity(Object entity) {
        return null;
    }

    @Override
    public void removeEntity(long id) {

    }
}
