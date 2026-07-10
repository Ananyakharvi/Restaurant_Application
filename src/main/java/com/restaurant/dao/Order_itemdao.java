package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.order_item;



public interface Order_itemdao {
	void addOrder_item(order_item or_item);
	List<order_item> getAllorder_item();
	void updateMenu_item(order_item or_item);
	void deleteMenu_item(order_item oi_id);
}
