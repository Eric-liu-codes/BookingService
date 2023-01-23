package com.solvd.bookingservice.users;

public class User {
    private long employeeID;
    private long consumerID;
    private String fName;
    private String lName;
    private int age;
    private String experience;
    private long accountID;

    public User(long employeeID, long consumerID, String fName, String lName, int age, String experience, long accountID) {
        this.employeeID = employeeID;
        this.consumerID = consumerID;
        this.fName = fName;
        this.lName = lName;
        this.age = age;
        this.experience = experience;
        this.accountID = accountID;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getConsumerID() {
        return consumerID;
    }

    public void setConsumerID(long consumerID) {
        this.consumerID = consumerID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public long getAccountID() {
        return accountID;
    }

    public void setAccountID(long accountID) {
        this.accountID = accountID;
    }
}
