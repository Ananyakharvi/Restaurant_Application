package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.Menu_itemDao;
import com.restaurant.dto.Menu_item;
import com.restaurant.utility.Connector;

public class Menu_itemsDaoImpl implements Menu_itemDao {
    private Connection con;

    public Menu_itemsDaoImpl() {
        this.con = Connector.requestConnection();
    }

    private Connection getConnection() {
        try {
            if (this.con == null || this.con.isClosed()) {
                this.con = Connector.requestConnection();
            }
        } catch (SQLException e) {
            this.con = Connector.requestConnection();
        }
        return this.con;
    }

    @Override
    public void addMenu_item(Menu_item menu) {
        Connection conn = getConnection();
        if (conn == null || menu == null) return;

        String query = "INSERT INTO menu_item(food_name, category, description, price, image, is_available) VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, menu.getFood_name());
            pstmt.setString(2, menu.getCategory() != null ? menu.getCategory() : "Main Course");
            pstmt.setString(3, menu.getDescription() != null ? menu.getDescription() : "");
            pstmt.setDouble(4, menu.getPrice() != null ? menu.getPrice() : 0.0);
            pstmt.setString(5, menu.getImage() != null ? menu.getImage() : "");
            pstmt.setBoolean(6, menu.getIs_available() != null ? menu.getIs_available() : true);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Menu_item getById(Integer menu_id) {
        Connection conn = getConnection();
        if (conn == null) return null;

        Menu_item menu = null;
        String query = "SELECT * FROM menu_item WHERE menu_id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, menu_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                menu = new Menu_item();
                menu.setMenu_id(rs.getInt("menu_id"));
                menu.setFood_name(rs.getString("food_name"));
                menu.setCategory(rs.getString("category"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setImage(rs.getString("image"));
                menu.setIs_available(rs.getBoolean("is_available"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return menu;
    }

    @Override
    public List<Menu_item> getAllMenu_item() {
        List<Menu_item> list = new ArrayList<>();
        Connection conn = getConnection();
        if (conn == null) return list;

        String query = "SELECT * FROM menu_item";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Menu_item menu = new Menu_item();
                menu.setMenu_id(rs.getInt("menu_id"));
                menu.setFood_name(rs.getString("food_name"));
                menu.setCategory(rs.getString("category"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setImage(rs.getString("image"));
                menu.setIs_available(rs.getBoolean("is_available"));
                list.add(menu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void updateMenu_item(Menu_item menu) {
        Connection conn = getConnection();
        if (conn == null || menu == null) return;

        String query = "UPDATE menu_item SET food_name=?, category=?, description=?, price=?, image=?, is_available=? WHERE menu_id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, menu.getFood_name());
            pstmt.setString(2, menu.getCategory());
            pstmt.setString(3, menu.getDescription());
            pstmt.setDouble(4, menu.getPrice() != null ? menu.getPrice() : 0.0);
            pstmt.setString(5, menu.getImage());
            pstmt.setBoolean(6, menu.getIs_available() != null ? menu.getIs_available() : true);
            pstmt.setObject(7, menu.getMenu_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu_item(Integer menu_id) {
        Connection conn = getConnection();
        if (conn == null) return;

        String query = "DELETE FROM menu_item WHERE menu_id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, menu_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
