package com.solvd.bookingservice.dao;
import com.solvd.bookingservice.bookingservices.Booking;

import java.sql.SQLException;
import java.util.List;

public interface IBookingDao<T> {
    List<T> getAllBookings() throws InterruptedException, SQLException;
    T getBookingByID(long id) throws InterruptedException, SQLException;
    void createBooking(Booking book) throws SQLException, InterruptedException;

    void updateBooking(Booking book) throws SQLException, InterruptedException;

    void deleteBooking(Booking book) throws InterruptedException, SQLException;
}
