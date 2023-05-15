/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.UserOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author vuhai
 */
public class UserOrderFacade {

    public int create(String email, List<Integer> productIds, List<Integer> quantities) throws SQLException, ClassNotFoundException {
        // Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();

        // Insert new order into UserOrder table
        PreparedStatement stm1 = con.prepareStatement("INSERT INTO UserOrder (user_id) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
        int index = email.indexOf("@");
        String userId = email.substring(0, index);
        stm1.setString(1, userId);
        stm1.executeUpdate();

        // Retrieve ID of newly inserted order
        ResultSet generatedKeys = stm1.getGeneratedKeys();
        if (!generatedKeys.next()) {
            throw new SQLException("Creating order failed, no ID obtained.");
        }
        int orderId = generatedKeys.getInt(1);

        // Insert associated products into OrderItem table
        PreparedStatement stm2 = con.prepareStatement("INSERT INTO OrderItem (order_id, product_id, quantity) VALUES (?, ?, ?)");
        for (int i = 0; i < productIds.size(); i++) {
            stm2.setInt(1, orderId);
            stm2.setInt(2, productIds.get(i));
            stm2.setInt(3, quantities.get(i));
            stm2.executeUpdate();
        }

        con.close();
        return orderId;
    }

}
