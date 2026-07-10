package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Restaurant_table;



public interface Restaurant_tableDao {
	void addReseve(Restaurant_table rt);
	Restaurant_table getById(Integer t_id);
	List<Restaurant_table> getAllRestaurant_table();
	void updateRestaurant_table(Restaurant_table rt);
	void deleteRestaurant_table(Integer t_id);
}
