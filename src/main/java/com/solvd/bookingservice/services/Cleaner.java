package com.solvd.bookingservice.services;

public class Cleaner {
    private long cleanerID;
    private String cleanService;

    public Cleaner(long cleanerID, String cleanService) {
        this.cleanerID = cleanerID;
        this.cleanService = cleanService;
    }

    public long getCleanerID() {
        return cleanerID;
    }

    public void setCleanerID(long cleanerID) {
        this.cleanerID = cleanerID;
    }

    public String getCleanService() {
        return cleanService;
    }

    public void setCleanService(String cleanService) {
        this.cleanService = cleanService;
    }
}
