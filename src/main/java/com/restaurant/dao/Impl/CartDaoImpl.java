package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.CartDao;
import com.restaurant.dto.cart;
import com.restaurant.utility.Connector;

public class CartDaoImpl implements CartDao {
    private Connection con;

    public CartDaoImpl() {
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
    public void addCart(cart c) {
        Connection conn = getConnection();
        if (conn == null) return;

        String sql = "INSERT INTO cart(user_id, menu_id, quantity) VALUES(?,?,?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, c.getUser_id());
            ps.setObject(2, c.getMenu_id());
            ps.setObject(3, c.getQuantity());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public cart getById(Integer cart_id) {
        Connection conn = getConnection();
        if (conn == null) return null;

        cart c = null;
        String sql = "SELECT * FROM cart WHERE cart_id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cart_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new cart();
                c.setCart_id(rs.getInt("cart_id"));
                c.setUser_id(rs.getInt("user_id"));
                c.setMenu_id(rs.getInt("menu_id"));
                c.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return c;
    }

    @Override
    public List<cart> getAllCart() {
        List<cart> list = new ArrayList<>();
        Connection conn = getConnection();
        if (conn == null) return list;

        String sql = "SELECT * FROM cart";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cart c = new cart();
                c.setCart_id(rs.getInt("cart_id"));
                c.setUser_id(rs.getInt("user_id"));
                c.setMenu_id(rs.getInt("menu_id"));
                c.setQuantity(rs.getInt("quantity"));
                list.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void updateUser(cart c) {
        updateCart(c);
    }

    @Override
    public void updateCart(cart c) {
        Connection conn = getConnection();
        if (conn == null) return;

        String sql = "UPDATE cart SET user_id=?, menu_id=?, quantity=? WHERE cart_id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, c.getUser_id());
            ps.setObject(2, c.getMenu_id());
            ps.setObject(3, c.getQuantity());
            ps.setObject(4, c.getCart_id());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCart(Integer cart_id) {
        Connection conn = getConnection();
        if (conn == null) return;

        String sql = "DELETE FROM cart WHERE cart_id=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, cart_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
