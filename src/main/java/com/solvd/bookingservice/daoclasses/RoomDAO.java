package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.bookingservices.Account;
import com.solvd.bookingservice.bookingservices.Room;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IRoomDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO extends MySQLDAO<Room> implements IRoomDAO {
    private static Logger logger = LogManager.getLogger(Runner.class.getName());
    private ConnectionPool pool;
    public List<Room> getAllRooms() {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        List<Room> rooms = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rooms";
            connection = pool.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Room room = new Room();
                room.setRoomID(resultSet.getLong("roomID"));
                room.setRoomNum(resultSet.getString("roomNum"));
                room.setType(resultSet.getString("type"));
                room.setBookingID(resultSet.getLong("bookingID"));
                rooms.add(room);
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
            return rooms;
        }
    }

    public Room getEntityById(long id) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM ROOMS WHERE roomID = ?", 0);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Room room = createRoomFromResultSet(resultSet);
                return room;
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

    public void updateEntity(Room room) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "UPDATE ROOMS SET roomNum = ?, type = ?, bookingID = ? WHERE roomID = ?");
            statement.setString(1, room.getRoomNum());
            statement.setString(2, room.getType());
            statement.setLong(3, room.getBookingID());
            statement.setLong(4, room.getRoomID());
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
    public Room createEntity(Room room) throws InterruptedException {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO Room (roomID, roomNum, type, bookingID) VALUES (?, ?, ?, ?)");
            statement.setLong(1, room.getRoomID());
            statement.setString(2, room.getRoomNum());
            statement.setString(3, room.getType());
            statement.setLong(4, room.getBookingID());
            if (statement.executeUpdate() > 0) {
                return new Room(room.getRoomID(), room.getRoomNum(), room.getType(), room.getBookingID());
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
            statement = connection.prepareStatement("DELETE FROM Room WHERE roomID = ?");
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
    private Room createRoomFromResultSet(ResultSet resultSet) throws SQLException {
        Room room = new Room();
        room.setRoomID(resultSet.getLong("roomID"));
        room.setRoomNum(resultSet.getString("roomNum"));
        room.setType(resultSet.getString("type"));
        room.setBookingID(resultSet.getLong("bookingID"));
        return room;
    }
}
