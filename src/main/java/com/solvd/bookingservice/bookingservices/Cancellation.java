package com.solvd.bookingservice.bookingservices;

public class Cancellation {
    private long cancellationID;
    private String type;
    private String reason;

    public Cancellation(long cancellationID, String type, String reason) {
        this.cancellationID = cancellationID;
        this.type = type;
        this.reason = reason;
    }

    public long getCancellationID() {
        return cancellationID;
    }

    public void setCancellationID(long cancellationID) {
        this.cancellationID = cancellationID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
