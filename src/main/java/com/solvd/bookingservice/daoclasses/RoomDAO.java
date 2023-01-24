package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.dao.IRoomDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class RoomDAO extends MySQLDAO implements IRoomDAO {
    static Logger logger = Logger.getLogger(Runner.class.getName());
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
    public List getAllRooms() {
        return null;
    }
}
