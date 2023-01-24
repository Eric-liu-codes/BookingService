package com.solvd.bookingservice.bookingservices;
import java.util.Date;
public class Account {
    private long accountID;
    private String username;
    private String password;
    private long organisationID;

    public Account(long accountID, String username, String password, long organisationID) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.organisationID = organisationID;
    }

    public Account() {}

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(long organisationID) {
        this.organisationID = organisationID;
    }

    public void setRegistrationDate(Date date) {

    }
}
