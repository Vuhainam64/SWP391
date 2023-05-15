/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vuhai
 */
public class UserFacade {

    public User login(String email, String password) throws SQLException {
        User user = null;
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select * from Users where email = ? and password = ?");
        stm.setString(1, email);
        stm.setString(2, password);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //load du lieu vao doi tuong toy neu co
        if (rs.next()) {
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setRoleId(rs.getString("roleId"));
        }
        //dong ket net
        con.close();
        return user;
    }

    public User checkExist(String email) throws SQLException {
        User user = null;
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("select * from Users where email = ?");
        stm.setString(1, email);
        //Thực thi lệnh sql
        ResultSet rs = stm.executeQuery();
        //load du lieu vao doi tuong toy neu co
        if (rs.next()) {
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
        }
        //dong ket net
        con.close();
        return user;
    }

    public void create(String name, String email, String password) throws SQLException, ClassNotFoundException {
        //Tạo connection để kết nối vào DBMS
        Connection con = DBContext.getConnection();
        //Tạo đối tượng PreparedStatement
        PreparedStatement stm = con.prepareStatement("insert Users values(?, ?, ?, ?, ?)");
        int index = email.indexOf("@");
        String id = email.substring(0, index);
        stm.setString(1, id);
        stm.setString(2, name);
        stm.setString(3, email);
        stm.setString(4, password);
        stm.setString(5, "user");

        //Thực thi lệnh sql
        int count = stm.executeUpdate();
        //Đóng kết nối
        con.close();
    }
}
