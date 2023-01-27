package com.solvd.bookingservice.daoclasses;

import com.solvd.bookingservice.Runner;
import com.solvd.bookingservice.bookingservices.User;
import com.solvd.bookingservice.connections.ConnectionPool;
import com.solvd.bookingservice.dao.IUserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDAO extends MySQLDAO implements IUserDao {
    private ConnectionPool pool;
    @Override
    public Object getEntityById(long id) throws SQLException, InterruptedException {
        String sql = "SELECT * FROM Users WHERE id = ?";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        User user = new User();
        while (result.next()) {
            user.setEmployeeID(result.getLong("employeeID"));
            user.setConsumerID(result.getLong("consumerID"));
            user.setfName(result.getString("fName"));
            user.setlName(result.getString("lName"));
            user.setAge(result.getInt("age"));
            user.setExperience(result.getString("experience"));
            user.setAccountID(result.getLong("accountID"));
        }
        pool.getInstance().releaseConnection(connection);
        return user;
    }
    @Override
    public List<User> getAllUsers() throws InterruptedException, SQLException {
        String sql = "SELECT * FROM Users";
        Connection connection = (Connection) pool.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();
        List<User> users = new ArrayList<>();
        while (result.next()) {
            User user = new User();
            user.setEmployeeID(result.getLong("employeeID"));
            user.setConsumerID(result.getLong("consumerID"));
            user.setfName(result.getString("fName"));
            user.setlName(result.getString("lName"));
            user.setAge(result.getInt("age"));
            user.setExperience(result.getString("experience"));
            user.setAccountID(result.getLong("accountID"));
            users.add(user);
        }
        pool.getInstance().releaseConnection(connection);
        return users;
    }


}
