package com.solvd.bookingservice.bookingservices;

public class FrontDesk {
    private long frontDeskID;
    private String service;

    public FrontDesk(long frontDeskID, String service) {
        this.frontDeskID = frontDeskID;
        this.service = service;
    }

    public long getFrontDeskID() {
        return frontDeskID;
    }

    public void setFrontDeskID(long frontDeskID) {
        this.frontDeskID = frontDeskID;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
