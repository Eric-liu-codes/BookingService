package com.solvd.bookingservice.dao.daoclasses;

import com.solvd.bookingservice.dao.IPaymentDao;

import java.sql.SQLException;
import java.util.List;

public class PaymentDAO extends MySQLDAO implements IPaymentDao {
    @Override
    public Object getEntityById(long id) throws SQLException {
        return null;
    }

    @Override
    public boolean updateEntity(Object entity) {
        return false;
    }

    @Override
    public Object createEntity(Object entity) {
        return null;
    }

    @Override
    public void removeEntity(long id) {

    }

    @Override
    public List getAllPayments() {
        return null;
    }

    @Override
    public Object getPaymentByID(long id) {
        return null;
    }

    @Override
    public void createPayment(Object account) {

    }

    @Override
    public void updatePayment(Object account) {

    }

    @Override
    public void deletePayment(Object account) {

    }
}
