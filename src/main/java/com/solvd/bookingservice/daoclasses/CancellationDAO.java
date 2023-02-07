package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.bookingservices.Account;
import com.solvd.bookingservice.bookingservices.Cancellation;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.ICancellationDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CancellationDAO extends MySQLDAO<Cancellation> implements ICancellationDAO {
    private static Logger logger = LogManager.getLogger(Runner.class.getName());
    private ConnectionPool pool;

    public List<Cancellation> getCancellations(){
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        List<Cancellation> cancellations = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Cancellations";
            connection = pool.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cancellation cancellation = new Cancellation();
                cancellation.setCancellationID(resultSet.getLong("cancellation_id"));
                cancellation.setType(resultSet.getString("type"));
                cancellation.setReason(resultSet.getString("reason"));
                cancellations.add(cancellation);
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
            return cancellations;
        }
    }
    public Cancellation getEntityById(long id) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM Cancellation WHERE cancellationID = ?", 0);
            statement.setLong(1, id);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Cancellation cancellation = createEntityFromResultSet(resultSet);
                return cancellation;
            }
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (connection != null) {
                pool.releaseConnection(connection);
            }
        }
        return null;
    }

    public void updateEntity(Cancellation entity) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "UPDATE Cancellation SET type = ?, reason = ? WHERE cancellationID = ?");
            statement.setString(1, entity.getType());
            statement.setString(2, entity.getReason());
            statement.setLong(3, entity.getCancellationID());
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (connection != null) {
                pool.releaseConnection(connection);
            }
        }
    }
    public Cancellation createEntity(Cancellation entity) throws InterruptedException {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO Cancellation (cancellationID, type, reason) VALUES (?, ?, ?)");
            statement.setLong(1, entity.getCancellationID());
            statement.setString(2, entity.getType());
            statement.setString(3, entity.getReason());
            if (resultSet.next()) {
                return new Cancellation(entity.getCancellationID(), entity.getType(), entity.getReason());
            }
            resultSet.close();

        } catch (SQLException e) {
            logger.error(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (connection != null) {
                pool.releaseConnection(connection);
            }
        }
        return null;
    }

    public void removeEntity(long id) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement("DELETE FROM Cancellation WHERE cancellationID = ?");
            statement.setLong(1, id);
            statement.executeQuery();
        } catch (SQLException e) {
            logger.error(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error(e);
                }
            }
            if (connection != null) {
                pool.releaseConnection(connection);
            }
        }
    }

    private Cancellation createEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Cancellation cancellation = null;
        if (resultSet.next()) {
            cancellation = new Cancellation();
            cancellation.setCancellationID(resultSet.getLong("cancellationID"));
            cancellation.setType(resultSet.getString("type"));
            cancellation.setReason(resultSet.getString("reason"));
        }
        return cancellation;
    }
}

