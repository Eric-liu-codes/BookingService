package com.solvd.bookingservice.jaxb;

import com.solvd.bookingservice.bookingservices.Payment;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement(name = "Account")
public class AccountJAXB {

    @XmlAttribute
    private long accountID;
    @XmlAttribute
    private String username;
    @XmlAttribute
    private String password;
    @XmlAttribute
    private long organisationID;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date registrationDate;
    @XmlElement
    private Payment payment;

    public AccountJAXB(long accountID, String username, String password, long organisationID, Date registrationDate, Payment payment) {
        this.accountID = accountID;
        this.username = username;
        this.password = password;
        this.organisationID = organisationID;
        this.registrationDate = registrationDate;
        this.payment = payment;
    }

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

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
