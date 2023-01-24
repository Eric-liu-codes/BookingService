package com.solvd.bookingservice.dao;

import java.sql.SQLException;
import java.util.List;

public interface IOrganisationDao<T> {
    List<T> getOrganisations() throws SQLException, InterruptedException;
}
