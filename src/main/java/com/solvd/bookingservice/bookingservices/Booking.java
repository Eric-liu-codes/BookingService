package com.solvd.bookingservice.bookingservices;

import java.sql.Date;
import java.sql.Time;

public class Booking {
    private long bookingID;
    private String name;
    private String price;
    private String type;
    private Date date;
    private Time time;
    private long consumerID;
    private long cancellationID;
    private long frontDeskID;

    public Booking(long bookingID, String name, String price, String type, Date date, Time time, long consumerID, long cancellationID, long frontDeskID) {
        this.bookingID = bookingID;
        this.name = name;
        this.price = price;
        this.type = type;
        this.date = date;
        this.time = time;
        this.consumerID = consumerID;
        this.cancellationID = cancellationID;
        this.frontDeskID = frontDeskID;
    }

    public Booking() {}

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public long getConsumerID() {
        return consumerID;
    }

    public void setConsumerID(long consumerID) {
        this.consumerID = consumerID;
    }

    public long getCancellationID() {
        return cancellationID;
    }

    public void setCancellationID(long cancellationID) {
        this.cancellationID = cancellationID;
    }

    public long getFrontDeskID() {
        return frontDeskID;
    }

    public void setFrontDeskID(long frontDeskID) {
        this.frontDeskID = frontDeskID;
    }
}
