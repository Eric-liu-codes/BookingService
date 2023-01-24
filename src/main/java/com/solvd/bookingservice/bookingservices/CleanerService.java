package com.solvd.bookingservice.bookingservices;

public class CleanerService {
    private long cleanerServiceID;
    private long roomID;
    private long cleanerID;

    public CleanerService(long cleanerServiceID, long roomID, long cleanerID) {
        this.cleanerServiceID = cleanerServiceID;
        this.roomID = roomID;
        this.cleanerID = cleanerID;
    }

    public long getCleanerServiceID() {
        return cleanerServiceID;
    }

    public void setCleanerServiceID(long cleanerServiceID) {
        this.cleanerServiceID = cleanerServiceID;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public long getCleanerID() {
        return cleanerID;
    }

    public void setCleanerID(long cleanerID) {
        this.cleanerID = cleanerID;
    }
}
