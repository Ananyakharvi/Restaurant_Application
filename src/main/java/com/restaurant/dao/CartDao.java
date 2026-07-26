package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Cart;



public interface CartDao {
	void addCart(Cart c);
	Cart getById(Integer cart_id);
	List<Cart> getAllCart();
	void updateCart(Cart c);
	void deleteCart(Integer cart_id);
}

