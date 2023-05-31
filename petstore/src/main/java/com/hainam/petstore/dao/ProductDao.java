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
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        PreparedStatement stm;
        ResultSet rs;

        try {
            String sql = "SELECT DISTINCT category FROM PRODUCT";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                categories.add(rs.getString("category"));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    // Lấy ra các cuốn sách của tác giả nào đó
    public List<Product> getAllProductByCategory(String category) {
        PreparedStatement stm;
        ResultSet rs;
        List<Product> productList = new ArrayList();

        try {
            String sql = "SELECT * FROM PRODUCT WHERE category LIKE ?";
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
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> searchProduct(String category, String keyword, boolean isSortByPrice, boolean isAscending) {
        PreparedStatement stm;
        ResultSet rs;
        List<Product> productList = new ArrayList<>();

        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT * FROM PRODUCT WHERE category LIKE ? AND productName LIKE ?");
            if (isSortByPrice) {
                sqlBuilder.append(" ORDER BY productPrice " + (isAscending ? "ASC" : "DESC"));
            } else {
                sqlBuilder.append(" ORDER BY productName " + (isAscending ? "ASC" : "DESC"));
            }
            String sql = sqlBuilder.toString();

            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + category + "%");
            stm.setString(2, "%" + keyword + "%");

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

        } catch (Exception ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
    }

    // Thêm sản phẩm mới vào database
    public void addProduct(Product product) {
        PreparedStatement stm;
        ResultSet rs;

        try {
            String sql = "INSERT INTO PRODUCT (productName, category, tags, productDescription, productPrice, quantity, isCoupon, imageMain, imageSub1, imageSub2, imageSub3, imageSub4)"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            stm = conn.prepareStatement(sql);
            stm.setString(1, product.getProductName());
            stm.setString(2, product.getCategory());
            stm.setString(3, product.getTags());
            stm.setString(4, product.getProductDescription());
            stm.setInt(5, product.getProductPrice());
            stm.setInt(6, product.getQuantity());
            stm.setBoolean(7, product.isCoupon());
            stm.setString(8, product.getImageMain());
            stm.setString(9, product.getImageSub1());
            stm.setString(10, product.getImageSub2());
            stm.setString(11, product.getImageSub3());
            stm.setString(12, product.getImageSub4());

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Xóa sản phẩm theo ID
    public void deleteProduct(int productId) {
        PreparedStatement stm;
        ResultSet rs;

        try {
            String sql = "DELETE FROM PRODUCT WHERE productId = ?";
            stm = conn.prepareStatement(sql);
            stm.setInt(1, productId);

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Cập nhật thông tin sản phẩm
    public void updateProduct(Product product) {
        PreparedStatement stm;
        ResultSet rs;

        try {
            String sql = "UPDATE PRODUCT SET productName = ?, category = ?, tags = ?, productDescription = ?, productPrice = ?, quantity = ?, isCoupon = ?, imageMain = ?, imageSub1 = ?, imageSub2 = ?, imageSub3 = ?, imageSub4 = ? WHERE productId = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, product.getProductName());
            stm.setString(2, product.getCategory());
            stm.setString(3, product.getTags());
            stm.setString(4, product.getProductDescription());
            stm.setInt(5, product.getProductPrice());
            stm.setInt(6, product.getQuantity());
            stm.setBoolean(7, product.isCoupon());
            stm.setString(8, product.getImageMain());
            stm.setString(9, product.getImageSub1());
            stm.setString(10, product.getImageSub2());
            stm.setString(11, product.getImageSub3());
            stm.setString(12, product.getImageSub4());
            stm.setInt(13, product.getProductId());

            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
