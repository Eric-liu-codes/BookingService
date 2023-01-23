package com.solvd.bookingservice.connections;

import java.sql.Connection;
import java.sql.*;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private String url;
    private String username;
    private String password;
    private LinkedBlockingQueue<Connection> connections;


    private ConnectionPool(String driverClassName, String url, String username, String password){
        this.url = url;
        this.username = username;
        this.password = password;
        this.connections = new LinkedBlockingQueue<>();
    }

    public static ConnectionPool getInstance() {
        //TODO
        return null;
    }


    public synchronized Connection getConnection(){
        //TODO
        return null;
    }

    private Connection createConnection() {
        return null;
    }
}
