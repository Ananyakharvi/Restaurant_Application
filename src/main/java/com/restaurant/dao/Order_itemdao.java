package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.order_item;


public interface Order_itemdao {
	void addOrder_item(order_item item);
	order_item getById(Integer item_id);
	List<order_item> getAllorder_item();
	void updateMenu_item(order_item item);
	void deleteMenu_item(Integer item_id);
}
