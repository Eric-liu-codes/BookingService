package com.solvd.bookingservice.services;

public class Room {
    private long roomID;
    private String roomNum;
    private String type;
    private long bookingID;

    public Room(long roomID, String roomNum, String type, long bookingID) {
        this.roomID = roomID;
        this.roomNum = roomNum;
        this.type = type;
        this.bookingID = bookingID;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getBookingID() {
        return bookingID;
    }

    public void setBookingID(long bookingID) {
        this.bookingID = bookingID;
    }
}
