package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.Order_itemdao;
import com.restaurant.dto.order_item;
import com.restaurant.utility.Connector;

public class Order_itemsDaoImpl implements Order_itemdao {
	private Connection con;

	   public Order_itemsDaoImpl() {
		this.con=Connector.requestConnection();
	   }

	@Override
	public void addOrder_item(order_item or_item) {
		String query = "INSERT INTO order_itemVALUES(?,?,?,?,?)";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, or_item.getO_id());
            ps.setInt(2, or_item.getM_id());
            ps.setDouble(3, or_item.getPrice());
            ps.setInt(4, or_item.getQuantity());
            ps.setDouble(5, or_item.getSub_total());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
		
		
	}

	@Override
	public order_item getById(Integer oi_id) {
		String query = "SELECT * FROM order_item WHERE oi_id=?";

        order_item item = null;

        try {

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, oi_id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                item = new order_item();

                item.setOi_id(rs.getInt("oi_id"));
                item.setO_id(rs.getInt("o_id"));
                item.setM_id(rs.getInt("m_id"));
                item.setPrice(rs.getDouble("price"));
                item.setQuantity(rs.getInt("quantity"));
                item.setSub_total(rs.getDouble("sub_total"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
	
	}

	@Override
	public List<order_item> getAllorder_item() {
		String query = "SELECT * FROM order_item";

        List<order_item> list = new ArrayList<>();

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                order_item item = new order_item();

                item.setOi_id(rs.getInt("oi_id"));
                item.setO_id(rs.getInt("o_id"));
                item.setM_id(rs.getInt("m_id"));
                item.setPrice(rs.getDouble("price"));
                item.setQuantity(rs.getInt("quantity"));
                item.setSub_total(rs.getDouble("sub_total"));

                list.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;

	}

	@Override
	public void updateMenu_item(order_item or_item) {

        String query = "UPDATE order_item SET o_id=?, m_id=?, price=?, quantity=?, sub_total=? WHERE oi_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, or_item.getO_id());
            ps.setInt(2, or_item.getM_id());
            ps.setDouble(3, or_item.getPrice());
            ps.setInt(4, or_item.getQuantity());
            ps.setDouble(5, or_item.getSub_total());
            ps.setInt(6, or_item.getOi_id());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

		
	

	@Override
	public void deleteMenu_item(Integer oi_id) {
		String query = "DELETE FROM order_item WHERE oi_id=?";

        try {

            PreparedStatement ps = con.prepareStatement(query);

             ps.setInt(1, oi_id);
             ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
		
	}


