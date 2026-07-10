package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.O_statusDao;
import com.restaurant.dto.O_status;
import com.restaurant.utility.Connector;

public class O_statusDaoImpl implements O_statusDao {
	
	private Connection con;

	   public O_statusDaoImpl() {
		this.con=Connector.requestConnection();
	   }

	@Override
	public O_status getById(Integer status_id) {
		 String query = "SELECT * FROM o_status WHERE status_id=?";

	        O_status status = null;

	        try {

	            PreparedStatement ps = con.prepareStatement(query);
	            ps.setInt(1, status_id);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {

	                status = new O_status();

	                status.setStatus_id(rs.getInt("status_id"));
	                status.setO_id(rs.getInt("o_id"));
	                status.setChef_id(rs.getInt("chef_id"));
	                status.setO_status(rs.getString("o_status"));
	                status.setUpdated_at(rs.getTime("updated_at"));

	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return status;

	}

	@Override
	public List<O_status> getAllO_status() {
		String query = "SELECT * FROM o_status";

        List<O_status> list = new ArrayList<>();

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                O_status status = new O_status();

                status.setStatus_id(rs.getInt("status_id"));
                status.setO_id(rs.getInt("o_id"));
                status.setChef_id(rs.getInt("chef_id"));
                status.setO_status(rs.getString("o_status"));
                status.setUpdated_at(rs.getTime("updated_at"));

                list.add(status);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

	}

}
