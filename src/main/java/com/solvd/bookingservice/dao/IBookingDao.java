package com.solvd.bookingservice.dao;
import java.util.List;

public interface IBookingDao<T> {
    List<T> getAllBookings();
    T getBookingByID(long id);
    void createBooking(T account);
    void updateBooking(T account);
    void deleteBooking(T account);
}
