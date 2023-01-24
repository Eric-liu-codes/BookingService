package com.solvd.bookingservice.dao;

import java.sql.SQLException;
import java.util.List;

public interface IServiceDao<T> {
    List<T> getServices() throws SQLException, InterruptedException;
}
