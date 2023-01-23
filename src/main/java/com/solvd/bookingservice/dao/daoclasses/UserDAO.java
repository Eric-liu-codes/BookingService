package com.solvd.bookingservice.dao.daoclasses;

import com.solvd.bookingservice.dao.IUserDao;

import java.sql.SQLException;
import java.util.List;

public class UserDAO extends MySQLDAO implements IUserDao {
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

    @Override
    public List getAllUsers() {
        return null;
    }

    @Override
    public Object getUserByID(long id) {
        return null;
    }

    @Override
    public void createUser(Object account) {

    }

    @Override
    public void updateUser(Object account) {

    }

    @Override
    public void deleteUser(Object account) {

    }
}
