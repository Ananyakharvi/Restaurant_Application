package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Orders;

public interface OrderDao {
	void addOrders(Orders order);
	Orders getById(Integer order_id);
	List<Orders> getAllorder_item();
	void updateOrder(Orders order);
	void deleteOrder(Integer order_id);
}
