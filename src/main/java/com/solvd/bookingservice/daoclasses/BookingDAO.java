package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.bookingservices.Booking;
import com.solvd.bookingservice.connections.Connection;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IBookingDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO extends MySQLDAO implements IBookingDao {
    private ConnectionPool pool;
    @Override
    public List<Booking> getAllBookings() throws InterruptedException, SQLException {
        String sql = "SELECT * FROM Bookings";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Booking> books = new ArrayList<>();
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
        pool.getInstance().releaseConnection((java.sql.Connection) connection);
        return books;
    }

    @Override
    public Booking getBookingByID(long id) throws InterruptedException, SQLException {
        String sql = "SELECT * FROM Bookings WHERE id = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        Booking book = null;
        if (resultSet.next()) {
            book = new Booking();
            book.setBookingID(resultSet.getLong("book_id"));
            book.setConsumerID(resultSet.getLong("consumer_id"));
            book.setDate(resultSet.getDate("date"));
            book.setTime(resultSet.getTime("time"));
            book.setCancellationID(resultSet.getLong("cancel_id"));
            book.setName(resultSet.getString("name"));
            book.setPrice(resultSet.getString("price"));
            book.setType(resultSet.getString("type"));
            book.setFrontDeskID(resultSet.getLong("front_id"));
        }
        pool.getInstance().releaseConnection((java.sql.Connection) connection);
        return book;
    }

    public void createBooking(Booking book) throws SQLException, InterruptedException {
        String sql = "INSERT INTO Bookings (name, price, type, date, time, consumerID, frontDeskID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getName());
        statement.setString(2, book.getPrice());
        statement.setString(3, book.getType());
        statement.setDate(4, book.getDate());
        statement.setTime(5, book.getTime());
        statement.setLong(6, book.getConsumerID());
        statement.setLong(7, book.getFrontDeskID());
        statement.executeUpdate();
        pool.getInstance().releaseConnection((java.sql.Connection) connection);
    }

    @Override
    public void updateBooking(Booking book) throws SQLException, InterruptedException {
        String sql = "UPDATE Bookings SET name = ?, price = ?, type = ?, date = ?, time = ?, consumerID = ?, frontDeskID = ? WHERE bookingID = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, book.getName());
        statement.setString(2, book.getPrice());
        statement.setString(3, book.getType());
        statement.setDate(4, book.getDate());
        statement.setTime(5, book.getTime());
        statement.setLong(6, book.getConsumerID());
        statement.setLong(7, book.getFrontDeskID());
        statement.setLong(8, book.getBookingID());
        statement.executeUpdate();
        pool.getInstance().releaseConnection((java.sql.Connection) connection);
    }

    @Override
    public void deleteBooking(Booking book) throws InterruptedException, SQLException {
        String sql = "DELETE FROM Bookings WHERE bookingID = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, book.getBookingID());
        statement.executeUpdate();
    }

    @Override
    public Object getEntityById(long id) throws SQLException, InterruptedException {
        return null;
    }
}
