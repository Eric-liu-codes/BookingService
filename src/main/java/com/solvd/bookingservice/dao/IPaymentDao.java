package com.solvd.bookingservice.dao;
import java.util.List;

public interface IPaymentDao<T> {
    List<T> getAllPayments();
    T getPaymentByID(long id);
    void createPayment(T account);
    void updatePayment(T account);
    void deletePayment(T account);
}
