package com.solvd.bookingservice.connections;

import com.solvd.bookingservice.Runner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static Logger logger = LogManager.getLogger(Runner.class.getName());
    private static ConnectionPool instance;
    private LinkedBlockingQueue<Connection> availableConnections;
    private String url;
    private String username;
    private String password;

    private ConnectionPool() throws InterruptedException {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("C:\\Users\\BookingService\\src\\main\\resources\\properties\\config.properties"));
            url = prop.getProperty("db.url");
            username = prop.getProperty("db.username");
            password = prop.getProperty("db.password");
            availableConnections = new LinkedBlockingQueue<Connection>();
            for (int i = 0; i < 10; i++) {
                Connection connection = instance.getConnection();
                availableConnections.add(connection);
            }
        } catch (FileNotFoundException e) {
            logger.error("File not found");
        } catch (IOException e) {
            logger.error("Runtime error");
        }
        this.availableConnections = availableConnections;
    }


    public synchronized Connection getConnection() throws InterruptedException{
        Connection connection = availableConnections.take();
        return connection;
    }

    public void close() throws SQLException {
        for (Connection connection : availableConnections) {
            connection.close();
        }
    }

    public static ConnectionPool getInstance() throws InterruptedException, SQLException {
        if (instance == null) {
            instance = new ConnectionPool();
        }
        return instance;
    }

    public void releaseConnection(Connection connection) {
    }
}
