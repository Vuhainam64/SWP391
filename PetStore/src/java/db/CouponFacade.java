/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Coupon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vuhai
 */
public class CouponFacade {

    public String getCoupon(String coupon) throws SQLException {
        Connection con = DBContext.getConnection();
        // Prepare a SQL statement to select the discount value for the given coupon code
        PreparedStatement stm = con.prepareStatement("SELECT discount FROM coupon WHERE code = ?");
        stm.setString(1, coupon);
        // Execute the SQL statement and get the result set
        ResultSet rs = stm.executeQuery();
        // If there is at least one row in the result set, return the discount value
        while (rs.next()) {
            return rs.getString("discount");
        }
        // If there are no rows in the result set, return null
        return null;
    }

}
