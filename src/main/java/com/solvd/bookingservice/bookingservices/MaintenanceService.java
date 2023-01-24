package com.solvd.bookingservice.bookingservices;

public class MaintenanceService {
    private long maintenanceServiceID;
    private long roomID;
    private long maintenanceID;

    public MaintenanceService(long maintenanceServiceID, long roomID, long maintenanceID) {
        this.maintenanceServiceID = maintenanceServiceID;
        this.roomID = roomID;
        this.maintenanceID = maintenanceID;
    }

    public long getMaintenanceServiceID() {
        return maintenanceServiceID;
    }

    public void setMaintenanceServiceID(long maintenanceServiceID) {
        this.maintenanceServiceID = maintenanceServiceID;
    }

    public long getRoomID() {
        return roomID;
    }

    public void setRoomID(long roomID) {
        this.roomID = roomID;
    }

    public long getMaintenanceID() {
        return maintenanceID;
    }

    public void setMaintenanceID(long maintenanceID) {
        this.maintenanceID = maintenanceID;
    }
}
