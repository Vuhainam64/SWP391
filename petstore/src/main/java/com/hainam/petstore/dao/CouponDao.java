package com.hainam.petstore.dao;

import com.hainam.petstore.dto.Coupon;
import com.hainam.petstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CouponDao {

    private static CouponDao instance;
    private Connection conn;

    private CouponDao() {
        conn = DBUtil.makeConnection();
    }

    public static CouponDao getInstance() {
        if (instance == null) {
            instance = new CouponDao();
        }
        return instance;
    }

    public void createCoupon(Coupon coupon) {
        String query = "INSERT INTO COUPON (productID, dateExpire, percentOff) VALUES (?, ?, ?)";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, coupon.getProductID());
            statement.setDate(2, coupon.getDateExpire());
            statement.setDouble(3, coupon.getPercentOff());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public Coupon getCouponById(int couponId) {
        String query = "SELECT * FROM COUPON WHERE couponId = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, couponId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToCoupon(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return null;
    }

    public List<Coupon> getAllCoupons() {
        List<Coupon> coupons = new ArrayList<>();
        String query = "SELECT * FROM COUPON";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Coupon coupon = mapResultSetToCoupon(resultSet);
                    coupons.add(coupon);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return coupons;
    }

    public void updateCoupon(Coupon coupon) {
        String query = "UPDATE COUPON SET productID = ?, dateExpire = ?, percentOff = ? WHERE couponId = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, coupon.getProductID());
            statement.setDate(2, coupon.getDateExpire());
            statement.setDouble(3, coupon.getPercentOff());
            statement.setInt(4, coupon.getCouponId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    public void deleteCoupon(int couponId) {
        String query = "DELETE FROM COUPON WHERE couponId = ?";
        try (PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, couponId);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }

    private Coupon mapResultSetToCoupon(ResultSet resultSet) throws SQLException {
        Coupon coupon = new Coupon();
        coupon.setCouponId(resultSet.getInt("couponId"));
        coupon.setProductID(resultSet.getInt("productID"));
        coupon.setDateExpire(resultSet.getDate("dateExpire"));
        coupon.setPercentOff(resultSet.getDouble("percentOff"));
        return coupon;
    }
}
