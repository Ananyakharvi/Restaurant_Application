package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.restaurant.dao.CustomerDao;
import com.restaurant.dto.Customer;
import com.restaurant.utility.Connector;

public class CustomerDaoImpl implements CustomerDao {
	
private Connection con;

	
	public CustomerDaoImpl() {
		this.con=Connector.requestConnection();
	}

	@Override
	public void addCustomer(Customer c) {
		String query = "INSERT INTO customer values(?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, c.getC_name());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getC_pswd());
            ps.setDate(5, c.getCreated_at());
            ps.executeUpdate();

         } catch (SQLException e) {
            e.printStackTrace();
        }

    }
		
		
	

	@Override
	public Customer getById(Integer c_id) {
		 String query = "SELECT * FROM customer WHERE c_id=?";

	        Customer c = null;
             try {
	            PreparedStatement ps = con.prepareStatement(query);
                  ps.setInt(1, c_id);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {

	                c = new Customer();

	                c.setC_id(rs.getInt("c_id"));
	                c.setC_name(rs.getString("c_name"));
	                c.setEmail(rs.getString("email"));
	                c.setPhone(rs.getString("phone"));
	                c.setC_pswd(rs.getString("c_pswd"));
	                c.setCreated_at(rs.getDate("created_at"));
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return c;
	    }
		
		
	

	@Override
	public List<Customer> getAllCustomer() {
		  String query = "SELECT * FROM customer";
              List<Customer> list = new ArrayList<>();

	        try {

	            PreparedStatement ps = con.prepareStatement(query);

	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {

	                Customer c = new Customer();

	                c.setC_id(rs.getInt("c_id"));
	                c.setC_name(rs.getString("c_name"));
	                c.setEmail(rs.getString("email"));
	                c.setPhone(rs.getString("phone"));
	                c.setC_pswd(rs.getString("c_pswd"));
	                c.setCreated_at(rs.getDate("created_at"));

	                list.add(c);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
		
		
	}

	@Override
	public void updateCustomer(Customer c) {
		String query = "UPDATE customer SET c_name=?, email=?, phone=?, c_pswd=?, created_at=? WHERE c_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, c.getC_name());
            ps.setString(2, c.getEmail());
            ps.setString(3, c.getPhone());
            ps.setString(4, c.getC_pswd());
            ps.setDate(5, c.getCreated_at());
            ps.setInt(6, c.getC_id());

            int result = ps.executeUpdate();

          

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

	@Override
	public Customer getByEmailAndPassword(String email, String c_pswd) {
		String query = "SELECT * FROM customer WHERE email=? AND c_pswd=?";

        Customer c = null;

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, c_pswd);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                c = new Customer();

                c.setC_id(rs.getInt("c_id"));
                c.setC_name(rs.getString("c_name"));
                c.setEmail(rs.getString("email"));
                c.setPhone(rs.getString("phone"));
                c.setC_pswd(rs.getString("c_pswd"));
                c.setCreated_at(rs.getDate("created_at"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		return c;
	}

	@Override
	public void deleteCustomer(Integer c_id) {
		String query = "DELETE FROM customer WHERE c_id=?";

    try {

        PreparedStatement ps = con.prepareStatement(query);

        ps.setInt(1, c_id);

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

}
		
	
		
	}


