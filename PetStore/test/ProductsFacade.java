/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import db.*;
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
        return categories;
    }

    //Get count in shop default
    public int getCountDefault() throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng statement
        Statement stm = con.createStatement();
        //Thực thi lệnh SELECT
        ResultSet rs = stm.executeQuery("select count(*) from Products");
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    // Get product in shop default
    public List<Products> getAllProduct(int index, int pageSize) throws SQLException {
        List<Products> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement(""
                + "with x as (select ROW_NUMBER()over (order by id asc) as row,* from Products)\n"
                + "select * from x where row between ?*?-(?-1) and ?*?");
        stm.setInt(1, index);
        stm.setInt(2, pageSize);
        stm.setInt(3, pageSize);
        stm.setInt(4, index);
        stm.setInt(5, pageSize);
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

    //Get count in shop with search
    public int getCountWithSearch(String search) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select count(*) from Products where name like ?");
        stm.setString(1, "%" + search + "%");
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    // Get product by name in shop
    public List<Products> getProductsByName(String search, int index, int pageSize) throws SQLException {
        List<Products> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement(""
                + "with x as (select ROW_NUMBER()over (order by id asc) as row,* from Products where name like ?)\n"
                + "select * from x where row between ?*?-(?-1) and ?*?");
        stm.setString(1, "%" + search + "%");
        stm.setInt(2, index);
        stm.setInt(3, pageSize);
        stm.setInt(4, pageSize);
        stm.setInt(5, index);
        stm.setInt(6, pageSize);
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

    //Get count in shop with search
    public int getCountWithSearchAndCategory(String search, String category) throws SQLException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select count(*) from Products where name like ? and category = ?");
        stm.setString(1, "%" + search + "%");
        stm.setString(2, category);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    // Get product by name and category in shop
    public List<Products> getProductsByNameAndCategory(String search, String category, int index, int pageSize) throws SQLException {
        List<Products> list = null;
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement(""
                + "with x as (select ROW_NUMBER()over (order by id asc) as row,* from Products where name like ? and category = ?)\n"
                + "select * from x where row between ?*?-(?-1) and ?*?");
        stm.setString(1, "%" + search + "%");
        stm.setString(2, category);
        stm.setInt(3, index);
        stm.setInt(4, pageSize);
        stm.setInt(5, pageSize);
        stm.setInt(6, index);
        stm.setInt(7, pageSize);
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

}
