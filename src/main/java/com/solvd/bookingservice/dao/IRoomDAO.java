package com.solvd.bookingservice.dao;
import java.util.List;

public interface IRoomDAO<T> {
    List<T> getAllRooms();
    T getRoomByID(long id);
    void createRoom(T account);
    void updateRoom(T account);
    void deleteRoom(T account);
}
