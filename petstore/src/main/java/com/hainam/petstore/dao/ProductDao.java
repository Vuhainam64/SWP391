/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hainam.petstore.dao;

import com.hainam.petstore.dto.Product;
import com.hainam.petstore.util.DBUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vuhai
 */
public class ProductDao {

    private static ProductDao instance;
    private Connection conn = DBUtil.makeConnection();

    // Cấm new trực tiếp BookDAO
    //Chỉ new BookDAO qua hàm static getInstance() để quản lí được số object/instance đã new - SINGLETON DESIGN PATTERN
    private ProductDao() {
    }

    public static ProductDao getInstance() {

        if (instance == null) {
            instance = new ProductDao();
        }
        return instance;
    }

    // Lấy ra tất cả sách trong kho
    public List<Product> getAllProduct() {

        PreparedStatement stm;
        ResultSet rs;

        List<Product> productList = new ArrayList();
        try {

            String sql = "select * from PRODUCT";
            stm = conn.prepareStatement(sql);

            rs = stm.executeQuery();
            while (rs.next()) {
                productList.add(new Product(rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getString("category"),
                        rs.getString("tags"),
                        rs.getString("productDescription"),
                        rs.getInt("productPrice"),
                        rs.getInt("quantity"),
                        rs.getBoolean("isCoupon"),
                        rs.getString("imageMain"),
                        rs.getString("imageSub1"),
                        rs.getString("imageSub2"),
                        rs.getString("imageSub3"),
                        rs.getString("imageSub4")
                ));
            }
        } catch (Exception ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    // Lấy ra một cuốn sách dựa trên mã sách
    public Product getProductById(int productId) {

        PreparedStatement stm;
        ResultSet rs;

        try {

            String sql = "SELECT * FROM PRODUCT WHERE productId = ?";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, productId);

            rs = stm.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getString("category"),
                        rs.getString("tags"),
                        rs.getString("productDescription"),
                        rs.getInt("productPrice"),
                        rs.getInt("quantity"),
                        rs.getBoolean("isCoupon"),
                        rs.getString("imageMain"),
                        rs.getString("imageSub1"),
                        rs.getString("imageSub2"),
                        rs.getString("imageSub3"),
                        rs.getString("imageSub4"));
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // Lấy ra các cuốn sách của tác giả nào đó
    public List<Product> getAllProductByCategory(String category) {

        PreparedStatement stm;
        ResultSet rs;

        List<Product> productList = new ArrayList();

        try {

            String sql = "SELECT PRODUCT FROM category WHERE category = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, category);

            rs = stm.executeQuery();
            while (rs.next()) {
                productList.add(new Product(rs.getInt("productId"),
                        rs.getString("productName"),
                        rs.getString("category"),
                        rs.getString("tags"),
                        rs.getString("productDescription"),
                        rs.getInt("productPrice"),
                        rs.getInt("quantity"),
                        rs.getBoolean("isCoupon"),
                        rs.getString("imageMain"),
                        rs.getString("imageSub1"),
                        rs.getString("imageSub2"),
                        rs.getString("imageSub3"),
                        rs.getString("imageSub4")));
            }
            return productList;

        } catch (Exception ex) {
            Logger.getLogger(PetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
