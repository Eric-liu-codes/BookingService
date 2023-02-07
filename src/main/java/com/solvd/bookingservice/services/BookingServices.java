package com.solvd.bookingservice.services;

import com.solvd.bookingservice.bookingservices.Booking;
import com.solvd.bookingservice.daoclasses.BookingDAO;

public class BookingServices {
    private final BookingDAO bookingDAO;

    public BookingServices() {
        this.bookingDAO = new BookingDAO();
    }

    public BookingServices(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }

    public Booking getBookingById(long id) throws InterruptedException {
        return this.bookingDAO.getEntityById(id);
    }

    public void updateBooking(Booking booking) throws InterruptedException {
        this.bookingDAO.updateEntity(booking);
    }

    public Booking createBooking(Booking booking) throws InterruptedException {
        return this.bookingDAO.createEntity(booking);
    }

    public void deleteBooking(long id) throws InterruptedException {
        this.bookingDAO.removeEntity(id);
    }

}
