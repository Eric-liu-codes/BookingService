package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.dao.IUserDao;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class UserDAO extends MySQLDAO implements IUserDao {
    static Logger logger = Logger.getLogger(Runner.class.getName());
    @Override
    public Object getEntityById(long id) throws SQLException {
        return null;
    }
    @Override
    public List getAllUsers() {
        return null;
    }

}
