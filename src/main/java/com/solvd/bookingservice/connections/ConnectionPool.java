package com.solvd.bookingservice.connections;

import com.solvd.bookingservice.Runner;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.*;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Logger;

public class ConnectionPool {
    static Logger logger = Logger.getLogger(Runner.class.getName());
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
            logger.info("File not found");
        } catch (IOException e) {
            logger.info("Runtime error");
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

    public void releaseConnection(com.solvd.bookingservice.connections.Connection connection) {
    }
}
