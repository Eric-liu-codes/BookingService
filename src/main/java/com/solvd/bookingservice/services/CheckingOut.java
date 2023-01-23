package com.solvd.bookingservice.services;

import java.sql.Date;
import java.sql.Timestamp;

public class CheckingOut {
    private long checkingOutID;
    private Date date;
    private Timestamp time;
    private long bookingID;

    public CheckingOut(long checkingOutID, Date date, Timestamp time, long bookingID) {
        this.checkingOutID = checkingOutID;
        this.date = date;
        this.time = time;
        this.bookingID = bookingID;
    }

    public long getCheckingOutID() {
        return checkingOutID;
    }

    public void setCheckingOutID(long checkingOutID) {
        this.checkingOutID = checkingOutID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }
}
