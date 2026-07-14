package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.CartDao;
import com.restaurant.dto.Chef;
import com.restaurant.dto.cart;
import com.restaurant.utility.Connector;

public class CartDaoImpl implements CartDao {
private Connection con;

	
	public CartDaoImpl() {
		this.con=Connector.requestConnection();
	}

	@Override
	public void addCart(cart c) {
	       String sql = "INSERT INTO cart(user_id, menu_id, quantity) VALUES(?,?,?)";

	        try {
	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setInt(1, c.getUser_id());
	            ps.setInt(2, c.getMenu_id());
	            ps.setInt(3, c.getQuantity());
                ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	
		
	}

	@Override
	public cart getById(Integer cart_id) {
		cart c = null;

        String sql = "SELECT * FROM cart WHERE cart_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);
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

        String sql = "SELECT * FROM cart";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

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
		String sql = "UPDATE cart SET user_id=?, menu_id=?, quantity=? WHERE cart_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, c.getUser_id());
            ps.setInt(2, c.getMenu_id());
            ps.setInt(3, c.getQuantity());
            ps.setInt(4, c.getCart_id());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public void deleteCart(Integer cart_id) {
		String sql = "DELETE FROM cart WHERE cart_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, cart_id);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

}
