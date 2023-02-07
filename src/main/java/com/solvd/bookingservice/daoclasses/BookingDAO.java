package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.bookingservices.Account;
import com.solvd.bookingservice.bookingservices.Booking;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IBookingDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class BookingDAO extends MySQLDAO<Booking> implements IBookingDao {
    private static Logger logger = LogManager.getLogger(Runner.class.getName());
    private ConnectionPool pool;
    @Override
    public List<Booking> getAllBookings() throws InterruptedException, SQLException {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        List<Booking> books = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Bookings";
            connection = pool.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Booking book = new Booking();
                book.setBookingID(resultSet.getLong("book_id"));
                book.setConsumerID(resultSet.getLong("consumer_id"));
                book.setDate(resultSet.getDate("date"));
                book.setTime(resultSet.getTime("time"));
                book.setCancellationID(resultSet.getLong("cancel_id"));
                book.setName(resultSet.getString("name"));
                book.setPrice(resultSet.getString("price"));
                book.setType(resultSet.getString("type"));
                book.setFrontDeskID(resultSet.getLong("front_id"));
                books.add(book);
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
            return books;
        }
    }

    @Override
    public Booking getEntityById(long id) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM Booking WHERE bookingID = ?", 0);
            statement.setLong(1, id);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Booking booking = createEntityFromResultSet(resultSet);
                return (Booking) booking;
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

    public void updateEntity(Booking entity) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "UPDATE Booking SET name = ?, price = ?, type = ?, date = ?, time = ?, consumerID = ?, cancellationID = ?, frontDeskID = ? WHERE bookingID = ?");
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getPrice());
            statement.setString(3, entity.getType());
            statement.setDate(4, entity.getDate());
            statement.setTime(5, entity.getTime());
            statement.setLong(6, entity.getConsumerID());
            statement.setLong(7, entity.getCancellationID());
            statement.setLong(8, entity.getFrontDeskID());
            statement.setLong(9, entity.getBookingID());
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

    public Booking createEntity(Booking entity) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO Booking (bookingID, name, price, type, date, time, consumerID, cancellationID, frontDeskID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setLong(1, entity.getBookingID());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getPrice());
            statement.setString(4, entity.getType());
            statement.setDate(5, entity.getDate());
            statement.setTime(6, entity.getTime());
            statement.setLong(7, entity.getConsumerID());
            statement.setLong(8, entity.getCancellationID());
            statement.setLong(9, entity.getFrontDeskID());
            statement.executeUpdate();
            return new Booking(entity.getBookingID(), entity.getName(), entity.getPrice(), entity.getType(), entity.getDate(), entity.getTime(), entity.getConsumerID(), entity.getCancellationID(), entity.getFrontDeskID());
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
        return null;
    }

    public void removeEntity(long id) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement("DELETE FROM Booking WHERE bookingID = ?");
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

    private Booking createEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Booking booking = null;
        if (resultSet.next()) {
            booking = new Booking();
            booking.setBookingID(resultSet.getLong("bookingID"));
            booking.setName(resultSet.getString("name"));
            booking.setPrice(resultSet.getString("price"));
            booking.setType(resultSet.getString("type"));
            booking.setDate(resultSet.getDate("date"));
            booking.setTime(resultSet.getTime("time"));
            booking.setConsumerID(resultSet.getLong("consumerID"));
            booking.setCancellationID(resultSet.getLong("cancellationID"));
            booking.setFrontDeskID(resultSet.getLong("frontDeskID"));
        }
        return booking;
    }

}
