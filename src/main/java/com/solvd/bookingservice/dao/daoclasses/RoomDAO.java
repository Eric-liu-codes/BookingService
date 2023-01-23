package com.solvd.bookingservice.dao.daoclasses;

import com.solvd.bookingservice.dao.IRoomDAO;

import java.sql.SQLException;
import java.util.List;

public class RoomDAO extends MySQLDAO implements IRoomDAO {
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

    @Override
    public Object getRoomByID(long id) {
        return null;
    }

    @Override
    public void createRoom(Object account) {

    }

    @Override
    public void updateRoom(Object account) {

    }

    @Override
    public void deleteRoom(Object account) {

    }
}
