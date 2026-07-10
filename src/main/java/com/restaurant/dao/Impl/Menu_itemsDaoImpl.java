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
	this.con=Connector.requestConnection();
}


	@Override
	public void addMenu_item(Menu_item menu) {
		String query = "INSERT INTO menu_item VALUES(?,?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, menu.getCategory());
            ps.setString(2, menu.getItem_name());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setString(5, menu.getUrl());
            ps.setBoolean(6, menu.getIs_available());

            int result = ps.executeUpdate();

            if (result > 0) {
                System.out.println("Menu Item Added Successfully.");
            } else {
                System.out.println("Failed to Add Menu Item.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
		
	

	@Override
	public Menu_item getById(Integer m_id) {
	     String query = "SELECT * FROM menu_item WHERE m_id=?";

	        Menu_item menu = null;

	        try {

	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, m_id);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {

	                menu = new Menu_item();

	                menu.setM_id(rs.getInt("m_id"));
	                menu.setCategory(rs.getString("category"));
	                menu.setItem_name(rs.getString("item_name"));
	                menu.setDescription(rs.getString("description"));
	                menu.setPrice(rs.getDouble("price"));
	                menu.setUrl(rs.getString("url"));
	                menu.setIs_available(rs.getBoolean("is_available"));

	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return menu;

	}

	@Override
	public List<Menu_item> getAllMenu_item() {
		String query = "SELECT * FROM menu_item";

        List<Menu_item> list = new ArrayList<>();

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Menu_item menu = new Menu_item();

                menu.setM_id(rs.getInt("m_id"));
                menu.setCategory(rs.getString("category"));
                menu.setItem_name(rs.getString("item_name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setUrl(rs.getString("url"));
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
		String query = "UPDATE menu_item SET category=?, item_name=?, description=?, price=?, url=?, is_available=? WHERE m_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, menu.getCategory());
            ps.setString(2, menu.getItem_name());
            ps.setString(3, menu.getDescription());
            ps.setDouble(4, menu.getPrice());
            ps.setString(5, menu.getUrl());
            ps.setBoolean(6, menu.getIs_available());
            ps.setInt(7, menu.getM_id());

            int result = ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void deleteMenu_item(Integer m_id) {
		 String query = "DELETE FROM menu_item WHERE m_id=?";

	        try {

	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setInt(1, m_id);

	             ps.executeUpdate();


	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	
		
	}




