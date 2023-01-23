package com.solvd.bookingservice.dao.daoclasses;

import com.solvd.bookingservice.dao.IBookingDao;

import java.sql.SQLException;
import java.util.List;

public class BookingDAO extends MySQLDAO implements IBookingDao {
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
    public List getAllBookings() {
        return null;
    }

    @Override
    public Object getBookingByID(long id) {
        return null;
    }

    @Override
    public void createBooking(Object account) {

    }

    @Override
    public void updateBooking(Object account) {

    }

    @Override
    public void deleteBooking(Object account) {

    }
}
