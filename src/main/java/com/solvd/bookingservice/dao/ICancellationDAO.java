package com.solvd.bookingservice.dao;

import java.sql.SQLException;
import java.util.List;

public interface ICancellationDAO<T> {
    List<T> getCancellations()throws SQLException, InterruptedException;
}
