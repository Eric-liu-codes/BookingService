package com.solvd.bookingservice.services;

import com.solvd.bookingservice.bookingservices.Room;
import com.solvd.bookingservice.daoclasses.RoomDAO;

public class RoomServices {
    private final RoomDAO roomDAO;

    public RoomServices() {
        this.roomDAO = new RoomDAO();
    }

    public Room getRoomById(long id) throws InterruptedException {
        return this.roomDAO.getEntityById(id);
    }

    public void updateRoom(Room room) throws InterruptedException {
        this.roomDAO.updateEntity(room);
    }

    public Room createRoom(Room room) throws InterruptedException {
        return this.roomDAO.createEntity(room);
    }

    public void deleteRoom(long id) throws InterruptedException {
        this.roomDAO.removeEntity(id);
    }

}
