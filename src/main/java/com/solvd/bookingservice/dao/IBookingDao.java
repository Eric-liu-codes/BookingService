package com.solvd.bookingservice.dao;
import com.solvd.bookingservice.bookingservices.Booking;

import java.sql.SQLException;
import java.util.List;

public interface IBookingDao<T> {
    List<T> getAllBookings() throws InterruptedException, SQLException;
}
