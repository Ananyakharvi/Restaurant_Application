package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.Order_itemdao;
import com.restaurant.dto.Order_item;
import com.restaurant.utility.Connector;

public class Order_itemsDaoImpl implements Order_itemdao {
	private Connection con;

	   public Order_itemsDaoImpl() {
		this.con=Connector.requestConnection();
	   }

	   @Override
	   public void addOrder_item(Order_item item) {
		   String query = "INSERT INTO order_item(order_id,menu_id,price,quantity) VALUES(?,?,?,?)";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, item.getOrder_id());
	            pstmt.setInt(2, item.getMenu_id());
	            pstmt.setDouble(3, item.getPrice());
	            pstmt.setInt(4, item.getQuantity());
                 pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	   }

	   @Override
	   public Order_item getById(Integer item_id) {
		    Order_item item = null;

	        String query = "SELECT * FROM order_item WHERE item_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, item_id);

	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {

	                item = new Order_item();

	                item.setItem_id(rs.getInt("item_id"));
	                item.setOrder_id(rs.getInt("order_id"));
	                item.setMenu_id(rs.getInt("menu_id"));
	                item.setPrice(rs.getDouble("price"));
	                item.setQuantity(rs.getInt("quantity"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		return item;
	   }

	   @Override
	   public List<Order_item> getAllorder_item() {
		   List<Order_item> list = new ArrayList<>();

	        String query = "SELECT * FROM order_item";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {

	                Order_item item = new Order_item();

	                item.setItem_id(rs.getInt("item_id"));
	                item.setOrder_id(rs.getInt("order_id"));
	                item.setMenu_id(rs.getInt("menu_id"));
	                item.setPrice(rs.getDouble("price"));
	                item.setQuantity(rs.getInt("quantity"));

	                list.add(item);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	   }

	   @Override
	   public void updateMenu_item(Order_item item) {
		   String query = "UPDATE order_item SET order_id=?, menu_id=?, price=?, quantity=? WHERE item_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, item.getOrder_id());
	            pstmt.setInt(2, item.getMenu_id());
	            pstmt.setDouble(3, item.getPrice());
	            pstmt.setInt(4, item.getQuantity());
	            pstmt.setInt(5, item.getItem_id());
                pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	   }

	   @Override
	   public void deleteMenu_item(Integer item_id) {
	       String query = "DELETE FROM order_item WHERE item_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, item_id);
                pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
		
	   }

	
		
	


