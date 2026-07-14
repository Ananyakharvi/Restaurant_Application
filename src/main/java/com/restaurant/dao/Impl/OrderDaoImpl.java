package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.OrderDao;
import com.restaurant.dto.Orders;
import com.restaurant.utility.Connector;

public class OrderDaoImpl implements OrderDao {
	private Connection con;

	   public OrderDaoImpl() {
		this.con=Connector.requestConnection();
	   }

	   @Override
	   public void addOrders(Orders order) {
		   String query = "INSERT INTO orders(user_id,reserve_id,chief_id,subtotal,gst,total_amt,order_date,order_status) VALUES(?,?,?,?,?,?,?,?)";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, order.getUser_id());
	            pstmt.setInt(2, order.getReserve_id());
	            pstmt.setInt(3, order.getChief_id());
	            pstmt.setDouble(4, order.getSubtotal());
	            pstmt.setDouble(5, order.getGst());
	            pstmt.setDouble(6, order.getTotal_amt());
	            pstmt.setDate(7, order.getOrder_date());
	            pstmt.setString(8, order.getOrder_status());
                pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	
		
	   }

	   @Override
	   public Orders getById(Integer order_id) {
	       Orders order = null;

	        String query = "SELECT * FROM orders WHERE order_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);
	            pstmt.setInt(1, order_id);

	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {

	                order = new Orders();

	                order.setOrder_id(rs.getInt("order_id"));
	                order.setUser_id(rs.getInt("user_id"));
	                order.setReserve_id(rs.getInt("reserve_id"));
	                order.setChief_id(rs.getInt("chief_id"));
	                order.setSubtotal(rs.getDouble("subtotal"));
	                order.setGst(rs.getDouble("gst"));
	                order.setTotal_amt(rs.getDouble("total_amt"));
	                order.setOrder_date(rs.getDate("order_date"));
	                order.setOrder_status(rs.getString("order_status"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return order;

	   }

	   @Override
	   public List<Orders> getAllorder_item() {
		   List<Orders> list = new ArrayList<>();

	        String query = "SELECT * FROM orders";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {

	                Orders order = new Orders();

	                order.setOrder_id(rs.getInt("order_id"));
	                order.setUser_id(rs.getInt("user_id"));
	                order.setReserve_id(rs.getInt("reserve_id"));
	                order.setChief_id(rs.getInt("chief_id"));
	                order.setSubtotal(rs.getDouble("subtotal"));
	                order.setGst(rs.getDouble("gst"));
	                order.setTotal_amt(rs.getDouble("total_amt"));
	                order.setOrder_date(rs.getDate("order_date"));
	                order.setOrder_status(rs.getString("order_status"));

	                list.add(order);
	            }

	        } catch (SQLException e) {
	        	  e.printStackTrace();
	        }

	        return list;
	
	   }

	   @Override
	   public void updateOrder(Orders order) {
		   String query = "UPDATE orders SET user_id=?, reserve_id=?, chief_id=?, subtotal=?, gst=?, total_amt=?, order_date=?, order_status=? WHERE order_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, order.getUser_id());
	            pstmt.setInt(2, order.getReserve_id());
	            pstmt.setInt(3, order.getChief_id());
	            pstmt.setDouble(4, order.getSubtotal());
	            pstmt.setDouble(5, order.getGst());
	            pstmt.setDouble(6, order.getTotal_amt());
	            pstmt.setDate(7, order.getOrder_date());
	            pstmt.setString(8, order.getOrder_status());
	            pstmt.setInt(9, order.getOrder_id());
                pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	   }

	   @Override
	   public void deleteOrder(Integer order_id) {
		   String query = "DELETE FROM orders WHERE order_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, order_id);

                pstmt.executeUpdate();


	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
		
	   }


		
	


