package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Order_item;


public interface Order_itemdao {
	void addOrder_item(Order_item item);
	Order_item getById(Integer item_id);
	List<Order_item> getAllorder_item();
	void updateMenu_item(Order_item item);
	void deleteMenu_item(Integer item_id);
}
