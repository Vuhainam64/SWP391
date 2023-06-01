package com.hainam.petstore.dao;

import com.hainam.petstore.dto.Order;
import com.hainam.petstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private static OrderDao instance;
    private Connection conn;

    private OrderDao() {
        conn = DBUtil.makeConnection();
    }

    public static OrderDao getInstance() {
        if (instance == null) {
            instance = new OrderDao();
        }
        return instance;
    }

    public void createOrder(Order order) {
        String query = "INSERT INTO ORDERITEM (orderID, productID, quantity) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, order.getOrderID());
            statement.setInt(2, order.getProductID());
            statement.setInt(3, order.getQuantity());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public Order getOrderById(int itemID) {
        String query = "SELECT * FROM ORDERITEM WHERE itemID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, itemID);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToOrder(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return null;
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM ORDERITEM";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Order order = mapResultSetToOrder(resultSet);
                    orders.add(order);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return orders;
    }

    public void updateOrder(Order order) {
        String query = "UPDATE ORDERITEM SET orderID = ?, productID = ?, quantity = ? WHERE itemID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, order.getOrderID());
            statement.setInt(2, order.getProductID());
            statement.setInt(3, order.getQuantity());
            statement.setInt(4, order.getItemID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public void deleteOrder(int itemID) {
        String query = "DELETE FROM ORDERITEM WHERE itemID = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, itemID);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    private Order mapResultSetToOrder(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        order.setItemID(resultSet.getInt("itemID"));
        order.setOrderID(resultSet.getInt("orderID"));
        order.setProductID(resultSet.getInt("productID"));
        order.setQuantity(resultSet.getInt("quantity"));
        return order;
    }
}
