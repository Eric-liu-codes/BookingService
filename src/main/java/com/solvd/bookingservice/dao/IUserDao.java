package com.solvd.bookingservice.dao;
import java.util.List;

public interface IUserDao<T> {
    List<T> getAllUsers();
    T getUserByID(long id);
    void createUser(T account);
    void updateUser(T account);
    void deleteUser(T account);
}
