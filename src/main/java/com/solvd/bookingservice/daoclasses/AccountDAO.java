package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.bookingservices.Account;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IAccountDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;

public class AccountDAO<T> extends MySQLDAO<Account> implements IAccountDao {
    private static Logger logger = LogManager.getLogger(Runner.class.getName());
    private ConnectionPool pool;
    @Override
    public List<Account> getAllAccounts() throws SQLException, InterruptedException {
        ResultSet resultSet = null;
        Connection connection = null;
        PreparedStatement statement = null;
        List<Account> accounts = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Accounts";
            connection = pool.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Account account = new Account();
                account.setAccountID(resultSet.getLong("id"));
                account.setUsername(resultSet.getString("username"));
                account.setPassword(resultSet.getString("password"));
                accounts.add(account);
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
            return accounts;
        }
    }

    public Account getEntityById(long id) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement("SELECT * FROM Account WHERE accountID = ?", 0);
            statement.setLong(1, id);

            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Account account = createEntityFromResultSet(resultSet);
                return (Account) account;
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

    public void updateEntity(Account entity) throws InterruptedException {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "UPDATE Account SET username = ?, password = ?, organisationID = ? WHERE accountID = ?");
            statement.setString(1, entity.getUsername());
            statement.setString(2, entity.getPassword());
            statement.setLong(3, entity.getOrganisationID());
            statement.setLong(4, entity.getAccountID());
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
    public Account createEntity(Account entity) throws InterruptedException {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            connection = pool.getConnection();
            statement = connection.prepareStatement(
                    "INSERT INTO Account (accountID, username, password, organisationID) VALUES (?, ?, ?, ?)");
            statement.setLong(1, entity.getAccountID());
            statement.setString(2, entity.getUsername());
            statement.setString(3, entity.getPassword());
            statement.setLong(4, entity.getOrganisationID());
            if (resultSet.next()) {
                return new Account(entity.getAccountID(), entity.getUsername(), entity.getPassword(), entity.getOrganisationID());
            }
            resultSet.close();

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
            statement = connection.prepareStatement("DELETE FROM Account WHERE accountID = ?");
            statement.setLong(1, id);
            statement.executeQuery();
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

    private Account createEntityFromResultSet(ResultSet resultSet) throws SQLException {
        Account account = null;
        if (resultSet.next()) {
            account = new Account();
            account.setAccountID(resultSet.getLong("id"));
            account.setUsername(resultSet.getString("username"));
            account.setPassword(resultSet.getString("password"));
        }
        return account;
    }
}
