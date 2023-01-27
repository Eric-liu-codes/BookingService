package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.bookingservices.Payment;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IPaymentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO extends MySQLDAO implements IPaymentDao {
    private ConnectionPool pool;
    @Override
    public Object getEntityById(long id) throws SQLException, InterruptedException {
        String sql = "SELECT * FROM Payments WHERE paymentID = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        Payment payment = new Payment();
        if(result.next()){
            payment.setPaymentID(result.getLong("paymentID"));
            payment.setPaymentMethodID(result.getLong("paymentMethodID"));
            payment.setBookingID(result.getLong("bookingID"));
        }
        pool.getInstance().releaseConnection(connection);
        return payment;
    }
    @Override
    public List<Payment> getAllPayments() throws InterruptedException, SQLException {
        String sql = "SELECT * FROM Payments";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        List<Payment> payments = new ArrayList<>();
        while(result.next()){
            Payment payment = new Payment();
            payment.setPaymentID(result.getLong("paymentID"));
            payment.setPaymentMethodID(result.getLong("paymentMethodID"));
            payment.setBookingID(result.getLong("bookingID"));
            payments.add(payment);
        }
        pool.getInstance().releaseConnection(connection);
        return payments;
    }
}
