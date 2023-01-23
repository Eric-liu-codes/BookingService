package com.solvd.bookingservice.services;

public class Payment {
    private long paymentID;
    private long paymentMethodID;
    private long bookingID;

    public Payment(long paymentID, long paymentMethodID, long bookingID) {
        this.paymentID = paymentID;
        this.paymentMethodID = paymentMethodID;
        this.bookingID = bookingID;
    }

    public long getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(long paymentID) {
        this.paymentID = paymentID;
    }

    public long getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(long paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
    }

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }
}
