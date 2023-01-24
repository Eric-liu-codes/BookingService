package com.solvd.bookingservice.dao;
import java.sql.SQLException;
import java.util.List;

public interface IRoomDAO<T> {
    List<T> getAllRooms() throws SQLException, InterruptedException;
}
