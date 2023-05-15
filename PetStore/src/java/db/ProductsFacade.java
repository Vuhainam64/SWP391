/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Products;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PHT
 */
public class ProductsFacade {
//Cake Home

    //Get Product with category
    public List<Products> getProductWithCategory(String category) throws SQLException {
        List<Products> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Products WHERE category= ?");
        stm.setString(1, category);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //Load dữ liệu vào đối tượng toy nếu có
        list = new ArrayList<>();
        while (rs.next()) {
            Products products = new Products();
            products.setId(rs.getInt("id"));
            products.setName(rs.getString("name"));
            products.setPrice(rs.getDouble("price"));
            products.setCategory(rs.getString("category"));
            products.setImage(rs.getString("image"));
            list.add(products);
        }
        con.close();
        return list;
    }

//Cake Details
    //Get Details of product
    public Products getProductById(int id) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Products WHERE id= ?");
        stm.setInt(1, id);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //Load dữ liệu vào đối tượng toy nếu có
        while (rs.next()) {
            Products products = new Products();
            products.setId(rs.getInt("id"));
            products.setName(rs.getString("name"));
            products.setDescription(rs.getString("description"));
            products.setPrice(rs.getDouble("price"));
            products.setCategory(rs.getString("category"));
            products.setImage(rs.getString("image"));
            products.setTags(rs.getString("tags"));
            products.setImage1(rs.getString("image1"));
            products.setImage2(rs.getString("image2"));
            products.setImage3(rs.getString("image3"));
            products.setImage4(rs.getString("image4"));
            products.setImage5(rs.getString("image5"));
            return products;
        }
        con.close();
        return null;
    }

//Cake Shop
    //Get category
    public List<String> getCategory() throws SQLException {
        List<String> categories = new ArrayList<String>();
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("SELECT DISTINCT category FROM products");
        while (rs.next()) {
            categories.add(rs.getString("category"));
        }
        con.close();
        return categories;
    }

    //Get count in shop
    public int getCount(String search, String category) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select count(*) from Products where name like ? and category like ?");
        stm.setString(1, "%" + search + "%");
        stm.setString(2, "%" + category + "%");
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        con.close();
        return 0;
    }

    // Get product in shop default
    public List<Products> getProduct(String search, String category, String sort, int index, int pageSize) throws SQLException {
        List<Products> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement(""
                + "with x as (select ROW_NUMBER()over (order by " + sort + " asc) as row,* from Products where name like ? and category like ?)\n"
                + "select * from x where row between ? and ?");
        stm.setString(1, "%" + search + "%");
        stm.setString(2, "%" + category + "%");
        stm.setInt(3, index * pageSize - (pageSize - 1));
        stm.setInt(4, index * pageSize);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //Load dữ liệu vào đối tượng toy nếu có
        list = new ArrayList<>();
        while (rs.next()) {
            Products products = new Products();
            products.setId(rs.getInt("id"));
            products.setName(rs.getString("name"));
            products.setPrice(rs.getDouble("price"));
            products.setCategory(rs.getString("category"));
            products.setImage(rs.getString("image"));
            list.add(products);
        }
        con.close();
        return list;
    }

//Cake Manager
    //Get Product 
    public List<Products> getProduct() throws SQLException {
        List<Products> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("SELECT * FROM Products");
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //Load dữ liệu vào đối tượng toy nếu có
        list = new ArrayList<>();
        while (rs.next()) {
            Products products = new Products();
            products.setId(rs.getInt("id"));
            products.setName(rs.getString("name"));
            products.setPrice(rs.getDouble("price"));
            products.setCategory(rs.getString("category"));
            products.setTags(rs.getString("tags"));
            list.add(products);
        }
        con.close();
        return list;
    }

    public void create(Products products) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("insert Products values(?,?,?,?,?,?,?,?,?,?,?)");
        stm.setString(1, products.getName());
        stm.setString(2, products.getDescription());
        stm.setDouble(3, products.getPrice());
        stm.setString(4, products.getCategory());
        stm.setString(5, products.getImage());
        stm.setString(6, products.getTags());
        stm.setString(7, products.getImage1());
        stm.setString(8, products.getImage2());
        stm.setString(9, products.getImage3());
        stm.setString(10, products.getImage4());
        stm.setString(11, products.getImage5());

        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }

    public void update(Products products) throws SQLException {
        // Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        // Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("update Products set name=?, description=?, price=?, category=?, image=?, tags=?, image1=?, image2=?, image3=?, image4=?, image5=? where id=?");
        stm.setString(1, products.getName());
        stm.setString(2, products.getDescription());
        stm.setDouble(3, products.getPrice());
        stm.setString(4, products.getCategory());
        stm.setString(5, products.getImage());
        stm.setString(6, products.getTags());
        stm.setString(7, products.getImage1());
        stm.setString(8, products.getImage2());
        stm.setString(9, products.getImage3());
        stm.setString(10, products.getImage4());
        stm.setString(11, products.getImage5());
        stm.setInt(12, products.getId()); // set the product ID to update

        // Thực thi lệnh sql
        int count = stm.executeUpdate();
        // Đóng kết nối
        con.close();
    }

    public void delete(int productId) throws SQLException {
        // Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        // Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("delete from Products where id=?");
        stm.setInt(1, productId); // set the product ID to delete
        // Thực thi lệnh sql
        int count = stm.executeUpdate();
        // Đóng kết nối
        con.close();
    }

}
