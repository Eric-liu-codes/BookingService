package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.bookingservices.Account;
import com.solvd.bookingservice.connections.Connection;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IAccountDao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO<T> extends MySQLDAO<T> implements IAccountDao {
    private ConnectionPool pool;
    @Override
    public List<Account> getAllAccounts() throws SQLException, InterruptedException {
        String sql = "SELECT * FROM Accounts";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        List<Account> accounts = new ArrayList<>();
        while (resultSet.next()) {
            Account account = new Account();
            account.setAccountID(resultSet.getLong("id"));
            account.setUsername(resultSet.getString("username"));
            account.setPassword(resultSet.getString("password"));
            accounts.add(account);
        }
        pool.getInstance().releaseConnection((java.sql.Connection) connection);
        return accounts;
    }

    @Override
    public Account getAccountByID(long id) throws SQLException, InterruptedException {
        String sql = "SELECT * FROM Accounts WHERE id = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet resultSet = statement.executeQuery();
        Account account = null;
        if (resultSet.next()) {
            account = new Account();
            account.setAccountID(resultSet.getLong("id"));
            account.setUsername(resultSet.getString("username"));
            account.setPassword(resultSet.getString("password"));
        }
        pool.getInstance().releaseConnection((java.sql.Connection) connection);
        return account;
    }

    @Override
    public void createAccount(Account account) throws SQLException, InterruptedException {
        String sql = "INSERT INTO Accounts (username, password) VALUES (?, ?)";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, account.getUsername());
        statement.setString(2, account.getPassword());
        statement.executeUpdate();
        pool.getInstance().releaseConnection((java.sql.Connection) connection);
    }

    @Override
    public void updateAccount(Account account) throws SQLException, InterruptedException {
        String sql = "UPDATE Accounts SET username = ?, password = ? WHERE id = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, account.getUsername());
        statement.setString(2, account.getPassword());
        statement.setLong(3, account.getAccountID());
        statement.executeUpdate();
        pool.getInstance().releaseConnection((java.sql.Connection) connection);
    }

    @Override
    public void deleteAccount(Account account) throws InterruptedException, SQLException {
        String sql = "DELETE FROM Accounts WHERE id = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, account.getAccountID());
        statement.executeUpdate();
    }

    @Override
    public T getEntityById(long id) throws SQLException, InterruptedException {
        return null;
    }
}
