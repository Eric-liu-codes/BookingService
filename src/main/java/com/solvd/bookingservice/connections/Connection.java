package com.solvd.bookingservice.connections;

import com.solvd.bookingservice.Runner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class Connection {
    static Logger logger = Logger.getLogger(Runner.class.getName());

    private java.sql.Connection connection;

    public Connection(String url, String username, String password) throws SQLException {
        this.connection = java.sql.DriverManager.getConnection(url, username, password);
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public void executeQuery(String query) {
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                logger.info("ID: " + id);
            }
        } catch (SQLException e) {
            logger.info("Connection Error");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.info("Connection Error");
        }
    }
}
