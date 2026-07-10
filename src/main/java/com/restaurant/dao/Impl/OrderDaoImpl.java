package com.restaurant.dao.Impl;

import java.sql.Connection;
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
		
		
		
	}

	@Override
	public Orders getById(Integer o_id) {
		
		return null;
	}

	@Override
	public List<Orders> getAllorder_item() {
		
		return null;
	}

	@Override
	public void updateMenu_item(Orders order) {
		
		
	}

	@Override
	public void deleteMenu_item(Integer o_id) {
		
		
	}

}
