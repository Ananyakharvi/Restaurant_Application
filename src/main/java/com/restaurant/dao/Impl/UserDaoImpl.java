package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.UserDao;
import com.restaurant.dto.User;
import com.restaurant.utility.Connector;

public class UserDaoImpl implements UserDao {
private Connection con;

	
	public UserDaoImpl() {
		this.con=Connector.requestConnection();
	}


	@Override
	public void addUser(User u) {
		String sql = "INSERT INTO user(full_name, email, phone, password) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getFull_name());
            ps.setString(2, u.getEmail());
            ps.setLong(3, u.getPhone());
            ps.setString(4, u.getPassword());
            ps.executeUpdate();

    
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public User getById(Integer user_id) {
		 String sql = "SELECT * FROM user WHERE user_id = ?";
		  User u =null;
	        try {
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, user_id);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {
	                u = new User();

	                u.setUser_id(rs.getInt("user_id"));
	                u.setFull_name(rs.getString("full_name"));
	                u.setEmail(rs.getString("email"));
	                u.setPhone(rs.getLong("phone"));
	                u.setPassword(rs.getString("password"));

	   
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return u;

	}

	@Override
	public List<User> getAllUser() {
		List<User> list = new ArrayList<>();

        String sql = "SELECT * FROM user";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                User u = new User();

                u.setUser_id(rs.getInt("user_id"));
                u.setFull_name(rs.getString("full_name"));
                u.setEmail(rs.getString("email"));
                u.setPhone(rs.getLong("phone"));
                u.setPassword(rs.getString("password"));

                list.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
	
	}

	@Override
	public void updateUser(User u) {
		String sql = "UPDATE user SET full_name=?, email=?, phone=?, password=? WHERE user_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, u.getFull_name());
            ps.setString(2, u.getEmail());
            ps.setLong(3, u.getPhone());
            ps.setString(4, u.getPassword());
            ps.setInt(5, u.getUser_id());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("User Updated Successfully.");
            } else {
                System.out.println("User Not Found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		 User u = null;

		    String sql = "SELECT * FROM user WHERE email=? AND password=?";

		    try {
		        PreparedStatement ps = con.prepareStatement(sql);
		        ps.setString(1, email);
		        ps.setString(2, password);

		        ResultSet rs = ps.executeQuery();

		        if (rs.next()) {
		            u = new User();
		            u.setUser_id(rs.getInt("user_id"));
		            u.setFull_name(rs.getString("full_name"));
		            u.setEmail(rs.getString("email"));
		            u.setPhone(rs.getLong("phone"));
		            u.setPassword(rs.getString("password"));
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return u;
	
	}

	@Override
	public void deleteUser(Integer user_id) {
		String sql = "DELETE FROM user WHERE user_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, user_id);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


	@Override
	public User getByEmail(String email) {
		User u = null;

	    String sql = "SELECT * FROM user WHERE email=?";

	    try {
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setString(1, email);
	        
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            u = new User();
	            u.setUser_id(rs.getInt("user_id"));
	            u.setFull_name(rs.getString("full_name"));
	            u.setEmail(rs.getString("email"));
	            u.setPhone(rs.getLong("phone"));
	            u.setPassword(rs.getString("password"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return u;
	}
		
		
	}


