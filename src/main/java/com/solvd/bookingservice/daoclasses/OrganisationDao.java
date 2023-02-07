package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.bookingservices.Account;
import com.solvd.bookingservice.bookingservices.Organisation;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IOrganisationDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrganisationDao extends MySQLDAO<Organisation> implements IOrganisationDao {
    private static Logger logger = LogManager.getLogger(Runner.class.getName());
    private ConnectionPool pool;

    public List<Organisation> getOrganisations(){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        List<Organisation> organisations = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Organisations";
            connection = pool.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Organisation organisation = new Organisation();
                organisation.setOrganisationID(resultSet.getLong("id"));
                organisation.setName(resultSet.getString("name"));
                organisation.setType(resultSet.getString("type"));
                organisation.setLocation(resultSet.getString("location"));
                organisations.add(organisation);
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
            return organisations;
        }
    }
    public Organisation getEntityById(long id) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM Organization WHERE organizationID = ?", 0);
            statement.setLong(1, id);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Organisation organisation = createEntityFromResultSet(resultSet);
                return organisation;
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

    public void updateEntity(Organisation entity) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "UPDATE Organization SET name = ?, type = ?, location = ? WHERE organizationID = ?");
            statement.setString(1, entity.getName());
            statement.setString(2, entity.getType());
            statement.setString(3, entity.getLocation());
            statement.setLong(4, entity.getOrganisationID());
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

    public Organisation createEntity(Organisation entity) throws InterruptedException {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO Organization (organizationID, name, type, location) VALUES (?, ?, ?, ?)");
            statement.setLong(1, entity.getOrganisationID());
            statement.setString(2, entity.getName());
            statement.setString(3, entity.getType());
            statement.setString(4, entity.getLocation());
            if (statement.executeUpdate() > 0) {
                return new Organisation(entity.getOrganisationID(), entity.getName(), entity.getType(), entity.getLocation());
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
            statement = connection.prepareStatement("DELETE FROM Organization WHERE organizationID = ?");
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

    private Organisation createEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Organisation organization = new Organisation();
        organization.setOrganisationID(resultSet.getLong("organizationID"));
        organization.setName(resultSet.getString("name"));
        organization.setType(resultSet.getString("type"));
        organization.setLocation(resultSet.getString("location"));
        return organization;
    }
}
