package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.ReserveDao;
import com.restaurant.dto.Reserve;
import com.restaurant.utility.Connector;

public class ReserveDaoImpl implements ReserveDao {
	private Connection con;

	   public ReserveDaoImpl() {
		this.con=Connector.requestConnection();
	   }

	@Override
	public void addReseve(Reserve r) {
		String sql = "INSERT INTO reserve(c_id, t_id, reserved_date, reserved_time, status) VALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, r.getReserve_id());
            ps.setInt(2, r.getT_id());
            ps.setDate(3, r.getReserved_date());
            ps.setTime(4, r.getReserved_time());
            ps.setString(5, r.getStatus());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public Reserve getById(Integer reserve_id) {
		Reserve reserve = null;

        String sql = "SELECT * FROM reserve WHERE reserve_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, reserve_id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                reserve = new Reserve();

                reserve.setReserve_id(rs.getInt("reserve_id"));
                reserve.setReserve_id(rs.getInt("c_id"));
                reserve.setT_id(rs.getInt("t_id"));
                reserve.setReserved_date(rs.getDate("reserved_date"));
                reserve.setReserved_time(rs.getTime("reserved_time"));
                reserve.setStatus(rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return reserve;

	}

	@Override
	public List<Reserve> getAllReserve() {
		 List<Reserve> list = new ArrayList<>();

	        String sql = "SELECT * FROM reserve";

	        try {

	            PreparedStatement ps = con.prepareStatement(sql);

	            ResultSet rs = ps.executeQuery(sql);

	            while (rs.next()) {

	                Reserve reserve = new Reserve();

	                reserve.setReserve_id(rs.getInt("reserve_id"));
	                reserve.setReserve_id(rs.getInt("c_id"));
	                reserve.setT_id(rs.getInt("t_id"));
	                reserve.setReserved_date(rs.getDate("reserved_date"));
	                reserve.setReserved_time(rs.getTime("reserved_time"));
	                reserve.setStatus(rs.getString("status"));

	                list.add(reserve);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;

	}

	@Override
	public void updateReserve(Reserve r) {
		 String sql = "UPDATE reserve SET c_id=?, t_id=?, reserved_date=?, reserved_time=?, status=? WHERE reserve_id=?";

	        try {

	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setInt(1, r.getReserve_id());
	            ps.setInt(2, r.getT_id());
	            ps.setDate(3, r.getReserved_date());
	            ps.setTime(4, r.getReserved_time());
	            ps.setString(5, r.getStatus());
	            ps.setInt(6, r.getReserve_id());
                ps.executeUpdate();

	

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void deleteReserve(Integer reserve_id) {
		 String sql = "DELETE FROM reserve WHERE reserve_id=?";

	        try {

	            PreparedStatement ps = con.prepareStatement(sql);

	            ps.setInt(1, reserve_id);
                ps.executeUpdate();


	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	
		
	}


