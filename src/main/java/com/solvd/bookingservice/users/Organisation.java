package com.solvd.bookingservice.users;

public class Organisation {
    private long organisationID;
    private String name;
    private String type;
    private String location;

    public Organisation(long organisationID, String name, String type, String location) {
        this.organisationID = organisationID;
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public long getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(long organisationID) {
        this.organisationID = organisationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
