package com.hainam.petstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hainam.petstore.dto.User;
import com.hainam.petstore.util.DBUtil;

public class UserDao {

    private static UserDao instance;
    private Connection conn;

    private UserDao() {
        conn = DBUtil.makeConnection();
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public void createUser(User user) {
        String query = "INSERT INTO USER_INFO (userName, userPassword, email, phone, userAddress, dateOfBirth) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getUserAddress());
            statement.setDate(6, user.getDateOfBird());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public User getUserById(int userId) {
        String query = "SELECT * FROM USER_INFO WHERE userId = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, userId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUser(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return null;
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM USER_INFO";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    User user = mapResultSetToUser(resultSet);
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return users;
    }

    public void updateUser(User user) {
        String query = "UPDATE USER_INFO SET userName = ?, userPassword = ?, email = ?, phone = ?, userAddress = ?, dateOfBirth = ? WHERE userId = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getUserPassword());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPhone());
            statement.setString(5, user.getUserAddress());
            statement.setDate(6, user.getDateOfBird());
            statement.setInt(7, user.getUserID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public void deleteUser(int userId) {
        String query = "DELETE FROM USER_INFO WHERE userId = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, userId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setUserID(resultSet.getInt("userId"));
        user.setUserName(resultSet.getString("userName"));
        user.setUserPassword(resultSet.getString("userPassword"));
        user.setEmail(resultSet.getString("email"));
        user.setPhone(resultSet.getString("phone"));
        user.setUserAddress(resultSet.getString("userAddress"));
        user.setDateOfBird(resultSet.getDate("dateOfBirth"));
        return user;
    }
}
