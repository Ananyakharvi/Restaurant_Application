package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Orders;

public interface OrderDao {
	void addOrders(Orders order);
	Orders getById(Integer o_id);
	List<Orders> getAllorder_item();
	void updateMenu_item(Orders order);
	void deleteMenu_item(Integer o_id);
}
