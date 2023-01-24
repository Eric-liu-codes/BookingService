package com.solvd.bookingservice.bookingservices;

public class PaymentMethod {
    private long paymentMethodID;
    private String name;
    private String type;

    public PaymentMethod(long paymentMethodID, String name, String type) {
        this.paymentMethodID = paymentMethodID;
        this.name = name;
        this.type = type;
    }

    public long getPaymentMethodID() {
        return paymentMethodID;
    }

    public void setPaymentMethodID(long paymentMethodID) {
        this.paymentMethodID = paymentMethodID;
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
}
