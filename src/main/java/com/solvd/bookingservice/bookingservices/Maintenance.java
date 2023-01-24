package com.solvd.bookingservice.bookingservices;

public class Maintenance {
    private long maintenanceID;
    private String type;
    private String reason;

    public Maintenance(long maintenanceID, String type, String reason) {
        this.maintenanceID = maintenanceID;
        this.type = type;
        this.reason = reason;
    }

    public long getMaintenanceID() {
        return maintenanceID;
    }

    public void setMaintenanceID(long maintenanceID) {
        this.maintenanceID = maintenanceID;
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
