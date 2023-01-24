package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.dao.ICancellationDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class CancellationDAO extends MySQLDAO implements ICancellationDAO {
    static Logger logger = Logger.getLogger(Runner.class.getName());

    @Override
    public Object getEntityById(long id) throws SQLException, InterruptedException {
        return null;
    }
    @Override
    public List getCancellations() throws SQLException, InterruptedException {
        return null;
    }
}
