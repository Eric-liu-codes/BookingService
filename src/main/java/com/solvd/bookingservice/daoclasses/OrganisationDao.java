package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.bookingservices.Organisation;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IOrganisationDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganisationDao extends MySQLDAO implements IOrganisationDao {
    private ConnectionPool pool;

    @Override
    public Object getEntityById(long id) throws SQLException, InterruptedException {
        String sql = "SELECT * FROM Organisations WHERE organisationID = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        Organisation organisation = new Organisation();
        if (result.next()) {
            organisation.setOrganisationID(result.getLong("organisationID"));
            organisation.setName(result.getString("name"));
            organisation.setType(result.getString("type"));
            organisation.setLocation(result.getString("location"));
        }
        pool.getInstance().releaseConnection(connection);
        return organisation;
    }
    @Override
    public List<Organisation> getOrganisations() throws SQLException, InterruptedException {
        String sql = "SELECT * FROM Organisations";
        Connection connection = (Connection) pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        List<Organisation> organisations = new ArrayList<>();
        while (result.next()) {
            Organisation organisation = new Organisation();
            organisation.setOrganisationID(result.getLong("organisationID"));
            organisation.setName(result.getString("name"));
            organisation.setType(result.getString("type"));
            organisation.setLocation(result.getString("location"));
            organisations.add(organisation);
        }
        pool.getInstance().releaseConnection(connection);
        return organisations;
    }
}
