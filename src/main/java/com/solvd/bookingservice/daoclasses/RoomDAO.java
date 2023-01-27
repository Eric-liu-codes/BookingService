package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.bookingservices.Room;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IRoomDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAO extends MySQLDAO implements IRoomDAO {
    private ConnectionPool pool;
    @Override
    public Object getEntityById(long id) throws SQLException, InterruptedException {
        String sql = "SELECT * FROM Rooms WHERE roomID = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        Room room = null;
        if (resultSet.next()) {
            room = new Room();
            room.setRoomID(resultSet.getLong("roomID"));
            room.setRoomNum(resultSet.getString("roomNum"));
            room.setType(resultSet.getString("type"));
            room.setBookingID(resultSet.getLong("bookingID"));
        }
        pool.getInstance().releaseConnection(connection);
        return room;
    }
    @Override
    public List<Room> getAllRooms() throws InterruptedException, SQLException {
        String sql = "SELECT * FROM Rooms";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Room> rooms = new ArrayList<>();
        while (resultSet.next()) {
            Room room = new Room();
            room.setRoomID(resultSet.getLong("roomID"));
            room.setRoomNum(resultSet.getString("roomNum"));
            room.setType(resultSet.getString("type"));
            room.setBookingID(resultSet.getLong("bookingID"));
            rooms.add(room);
        }
        pool.getInstance().releaseConnection(connection);
        return rooms;
    }
}
