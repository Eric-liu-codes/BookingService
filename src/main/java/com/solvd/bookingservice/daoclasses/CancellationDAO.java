package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.bookingservices.Cancellation;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.ICancellationDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CancellationDAO extends MySQLDAO implements ICancellationDAO {
    private ConnectionPool pool;
    @Override
    public Object getEntityById(long id) throws SQLException, InterruptedException {
        String sql = "SELECT * FROM Cancellations WHERE cancellationID = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        Cancellation cancellation = new Cancellation();
        if (result.next()) {
            cancellation.setCancellationID(result.getLong("cancellationID"));
            cancellation.setType(result.getString("type"));
            cancellation.setReason(result.getString("reason"));
        }
        pool.getInstance().releaseConnection(connection);
        return cancellation;
    }
    @Override
    public List<Cancellation> getCancellations() throws SQLException, InterruptedException {
        String sql = "SELECT * FROM Cancellations";
        Connection connection = (Connection) pool.getConnection();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        List<Cancellation> cancellations = new ArrayList<>();
        while (result.next()) {
            Cancellation cancellation = new Cancellation();
            cancellation.setCancellationID(result.getLong("cancellationID"));
            cancellation.setType(result.getString("type"));
            cancellation.setReason(result.getString("reason"));
            cancellations.add(cancellation);
        }
        pool.getInstance().releaseConnection(connection);
        return cancellations;
    }
}

