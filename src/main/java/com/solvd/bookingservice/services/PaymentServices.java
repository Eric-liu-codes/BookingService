package com.solvd.bookingservice.services;

import com.solvd.bookingservice.bookingservices.Payment;
import com.solvd.bookingservice.daoclasses.PaymentDAO;

public class PaymentServices {
    private final PaymentDAO paymentDAO;

    public PaymentServices() {
        this.paymentDAO = new PaymentDAO();
    }

    public Payment getPaymentById(long id) throws InterruptedException {
        return this.paymentDAO.getEntityById(id);
    }

    public void updatePayment(Payment payment) throws InterruptedException {
        this.paymentDAO.updateEntity(payment);
    }

    public Payment createPayment(Payment payment) throws InterruptedException {
        return this.paymentDAO.createEntity(payment);
    }

    public void deletePayment(long id) throws InterruptedException {
        this.paymentDAO.removeEntity(id);
    }

}
