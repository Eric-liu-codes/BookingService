package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.bookingservices.Account;
import com.solvd.bookingservice.bookingservices.Payment;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IPaymentDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO extends MySQLDAO<Payment> implements IPaymentDao {
    private static Logger logger = LogManager.getLogger(Runner.class.getName());
    private ConnectionPool pool;
    public List<Payment> getAllPayments(){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        List<Payment> payments = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Payments";
            connection = pool.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setPaymentID(resultSet.getLong("paymentID"));
                payment.setPaymentMethodID(resultSet.getLong("paymentMethodID"));
                payment.setBookingID(resultSet.getLong("bookingID"));
                payments.add(payment);
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    pool.releaseConnection(connection);
                }
            } catch (SQLException e) {
                logger.error(e);
            }
            return payments;
        }
    }

    public Payment getEntityById(long id) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM Payments WHERE paymentID = ?", 0);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Payment payment = createPaymentFromResultSet(resultSet);
                return payment;
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    pool.getInstance().releaseConnection(connection);
                }
            } catch (SQLException e) {
                logger.error(e);
            }
        }
        return null;
    }

    public void updateEntity(Payment payment) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "UPDATE Payments SET paymentMethodID = ?, bookingID = ? WHERE paymentID = ?");
            statement.setLong(1, payment.getPaymentMethodID());
            statement.setLong(2, payment.getBookingID());
            statement.setLong(3, payment.getPaymentID());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    pool.getInstance().releaseConnection(connection);
                }
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }
    public Payment createEntity(Payment payment) throws InterruptedException {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO Payment (paymentID, paymentMethodID, bookingID) VALUES (?, ?, ?)");
            statement.setLong(1, payment.getPaymentID());
            statement.setLong(2, payment.getPaymentMethodID());
            statement.setLong(3, payment.getBookingID());
            if (statement.executeUpdate() > 0) {
                return new Payment(payment.getPaymentID(), payment.getPaymentMethodID(), payment.getBookingID());
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    pool.getInstance().releaseConnection(connection);
                }
            } catch (SQLException e) {
                logger.error(e);
            }
        }
        return null;
    }
    public void removeEntity(long id) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement("DELETE FROM Payment WHERE paymentID = ?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    pool.getInstance().releaseConnection(connection);
                }
            } catch (SQLException e) {
                logger.error(e);
            }
        }
    }

    private Payment createPaymentFromResultSet(ResultSet resultSet) throws SQLException {
        Payment payment = new Payment();
        payment.setPaymentID(resultSet.getLong("paymentID"));
        payment.setPaymentMethodID(resultSet.getLong("paymentMethodID"));
        payment.setBookingID(resultSet.getLong("bookingID"));
        return payment;
    }
}
