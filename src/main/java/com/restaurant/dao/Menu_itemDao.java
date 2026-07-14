package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Menu_item;

public interface Menu_itemDao {
	void addMenu_item(Menu_item menu);
	Menu_item getById(Integer menu_id);
	List<Menu_item> getAllMenu_item();
	void updateMenu_item(Menu_item menu);
	void deleteMenu_item(Integer menu_id);  
}
