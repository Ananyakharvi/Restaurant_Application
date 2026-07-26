package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Order_item;

public interface Order_itemdao {
<<<<<<< HEAD
	void addOrder_item(Order_item item);
	Order_item getById(Integer item_id);
	List<Order_item> getAllorder_item();
	void updateMenu_item(Order_item item);
=======
	void addOrder_item(order_item item);
	order_item getById(Integer item_id);
	List<order_item> getAllorder_item();
	List<order_item> getByOrderId(Integer order_id);
	void updateOrder_item(order_item item);
	void updateMenu_item(order_item item);
	void deleteOrder_item(Integer item_id);
>>>>>>> 83c88f2c65e93704326f89f55fe3120923339eec
	void deleteMenu_item(Integer item_id);
}
