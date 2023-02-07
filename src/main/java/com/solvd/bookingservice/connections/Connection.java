package com.solvd.bookingservice.connections;

import com.solvd.bookingservice.Runner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Connection {
    private static Logger logger = LogManager.getLogger(Runner.class.getName());

    private java.sql.Connection connection;

    public Connection(String url, String username, String password) throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
    }

    public PreparedStatement prepareStatement(String query) throws SQLException {
        return connection.prepareStatement(query);
    }

    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                logger.info("ID: " + id);
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            logger.error("Connection Error");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            logger.error("Connection Error");
        }
    }
}
