package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.Restaurant_tableDao;
import com.restaurant.dto.Restaurant_table;
import com.restaurant.utility.Connector;

public class RestaurantTableDaoImpl implements Restaurant_tableDao {
	
	private Connection con;

	   public RestaurantTableDaoImpl() {
		this.con=Connector.requestConnection();
	   }

	   @Override
	   public void addReseve(Restaurant_table rt) {
		   String query = "INSERT INTO restaurant_table(table_number, capacity, status) VALUES(?,?,?)";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, rt.getTable_number());
	            pstmt.setInt(2, rt.getCapacity());
	            pstmt.setString(3, rt.getStatus());
                pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	   }

	   @Override
	   public Restaurant_table getById(Integer t_id) {
		   Restaurant_table rt = null;

	        String query = "SELECT * FROM restaurant_table WHERE t_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, t_id);

	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {

	                rt = new Restaurant_table();

	                rt.setT_id(rs.getInt("t_id"));
	                rt.setTable_number(rs.getInt("table_number"));
	                rt.setCapacity(rs.getInt("capacity"));
	                rt.setStatus(rs.getString("status"));

	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return rt;

	   }

	   @Override
	   public List<Restaurant_table> getAllRestaurant_table() {
		   List<Restaurant_table> list = new ArrayList<>();

	        String query = "SELECT * FROM restaurant_table";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            ResultSet rs = pstmt.executeQuery();

	            while (rs.next()) {

	                Restaurant_table rt = new Restaurant_table();

	                rt.setT_id(rs.getInt("t_id"));
	                rt.setTable_number(rs.getInt("table_number"));
	                rt.setCapacity(rs.getInt("capacity"));
	                rt.setStatus(rs.getString("status"));

	                list.add(rt);

	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;

	   }

	   @Override
	   public void updateRestaurant_table(Restaurant_table rt) {
		   String query = "UPDATE restaurant_table SET table_number=?, capacity=?, status=? WHERE t_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, rt.getTable_number());
	            pstmt.setInt(2, rt.getCapacity());
	            pstmt.setString(3, rt.getStatus());
	            pstmt.setInt(4, rt.getT_id());
                pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	   }

	   @Override
	   public void deleteRestaurant_table(Integer t_id) {
		   String query = "DELETE FROM restaurant_table WHERE t_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, t_id);
                pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
		
		
	   }


	
		
	


