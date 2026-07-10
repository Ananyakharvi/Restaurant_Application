package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.ChefDao;
import com.restaurant.dto.Chef;
import com.restaurant.utility.Connector;

public class ChefDaoImpl implements ChefDao {
	
private Connection con;

	
	public ChefDaoImpl() {
		this.con=Connector.requestConnection();
	}

	@Override
	public void addChef(Chef chef) {
		 String query = "INSERT INTO chef VALUES(?,?,?,?)";

	        try {

	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setString(1, chef.getChef_name());
	            ps.setString(2, chef.getCh_email());
	            ps.setLong(3, chef.getPhone_no());
	            ps.setString(4, chef.getCh_pswd());

	           ps.executeUpdate();


	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	}

	@Override
	public Chef getById(Integer chef_id) {
		String query = "SELECT * FROM chef WHERE chef_id=?";

        Chef chef = null;

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, chef_id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                chef = new Chef();

                chef.setChef_id(rs.getInt("chef_id"));
                chef.setChef_name(rs.getString("chef_name"));
                chef.setCh_email(rs.getString("ch_email"));
                chef.setPhone_no(rs.getLong("phone_no"));
                chef.setCh_pswd(rs.getString("ch_pswd"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chef;
		
	
	}

	@Override
	public List<Chef> getAllChef() {
		String query = "SELECT * FROM chef";

        List<Chef> list = new ArrayList<>();

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Chef chef = new Chef();

                chef.setChef_id(rs.getInt("chef_id"));
                chef.setChef_name(rs.getString("chef_name"));
                chef.setCh_email(rs.getString("ch_email"));
                chef.setPhone_no(rs.getLong("phone_no"));
                chef.setCh_pswd(rs.getString("ch_pswd"));

                list.add(chef);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
	}

	@Override
	public void updateChef(Chef chef) {
		 String query = "UPDATE chef SET chef_name=?, ch_email=?, phone_no=?, ch_pswd=? WHERE chef_id=?";

	        try {

	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setString(1, chef.getChef_name());
	            ps.setString(2, chef.getCh_email());
	            ps.setLong(3, chef.getPhone_no());
	            ps.setString(4, chef.getCh_pswd());
	            ps.setInt(5, chef.getChef_id());

	            int result = ps.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	}

	@Override
	public Chef getByEmailAndPassword(String ch_email, String ch_pswd) {
		String query = "SELECT * FROM chef WHERE ch_email=? AND ch_pswd=?";

        Chef chef = null;

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, ch_email);
            ps.setString(2, ch_pswd);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                chef = new Chef();

                chef.setChef_id(rs.getInt("chef_id"));
                chef.setChef_name(rs.getString("chef_name"));
                chef.setCh_email(rs.getString("ch_email"));
                chef.setPhone_no(rs.getLong("phone_no"));
                chef.setCh_pswd(rs.getString("ch_pswd"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return chef;

	}

	@Override
	public void deleteChef(Integer chef_id) {
		// TODO Auto-generated method stub
		
	}
		
	
		
	}


