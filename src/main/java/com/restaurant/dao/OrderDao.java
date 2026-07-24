package com.restaurant.dao;

import java.util.List;
import com.restaurant.dto.OrdersDTO;

public interface OrderDao {
	void addOrders(OrdersDTO order);
	OrdersDTO getById(Integer order_id);
	List<OrdersDTO> getAllorder_item();
	void updateOrder(OrdersDTO order);
	void deleteOrder(Integer order_id);
}
