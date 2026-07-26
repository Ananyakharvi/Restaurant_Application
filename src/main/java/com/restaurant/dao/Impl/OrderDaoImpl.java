package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.OrderDao;
import com.restaurant.dto.OrdersDTO;
import com.restaurant.utility.Connector;

public class OrderDaoImpl implements OrderDao {
	
	private Connection con;

	public OrderDaoImpl() {
		this.con = Connector.requestConnection();
	}

	@Override
	public void addOrders(OrdersDTO order) {
		 String query = "INSERT INTO orders(table_no, items_count, status, time) VALUES(?,?,?,?)";

	        try {
	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, order.getTableNo());
	            ps.setInt(2, order.getItemsCount());
	            ps.setString(3, order.getStatus());
	            ps.setString(4, order.getTime());

	            ps.executeUpdate();

	            System.out.println("Order Added Successfully");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
	}

	@Override
	public OrdersDTO getById(Integer order_id) {
		 OrdersDTO order = null;

	        String query = "SELECT * FROM orders WHERE order_id = ?";

	        try {
	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, order_id);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {

	                order = new OrdersDTO();

	                order.setOrderId(rs.getInt("order_id"));
	                order.setTableNo(rs.getInt("table_no"));
	                order.setItemsCount(rs.getInt("items_count"));
	                order.setStatus(rs.getString("status"));
	                order.setTime(rs.getString("time"));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return order;
		
		
	}

	@Override
	public List<OrdersDTO> getAllorder_item() {
		List<OrdersDTO> list = new ArrayList<>();

        String query = "SELECT * FROM orders";

        try {

        	PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {

                OrdersDTO order = new OrdersDTO();

                order.setOrderId(rs.getInt("order_id"));
                order.setTableNo(rs.getInt("table_no"));
                order.setItemsCount(rs.getInt("items_count"));
                order.setStatus(rs.getString("status"));
                order.setTime(rs.getString("time"));

                list.add(order);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
		
		
	}

	@Override
	public void updateOrder(OrdersDTO order) {
		 String query = "UPDATE orders SET table_no=?, items_count=?, status=?, time=? WHERE order_id=?";

	        try {

	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, order.getTableNo());
	            ps.setInt(2, order.getItemsCount());
	            ps.setString(3, order.getStatus());
	            ps.setString(4, order.getTime());
	            ps.setInt(5, order.getOrderId());

	            ps.executeUpdate();

	            System.out.println("Order Updated Successfully");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
		
	}

	@Override
	public void deleteOrder(Integer order_id) {
		 String query = "DELETE FROM orders WHERE order_id=?";

	        try {

	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, order_id);

	            ps.executeUpdate();

	            System.out.println("Order Deleted Successfully");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    
		
		
	}

}
