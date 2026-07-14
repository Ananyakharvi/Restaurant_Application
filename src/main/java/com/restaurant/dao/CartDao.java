package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.cart;



public interface CartDao {
	void addCart(cart c);
	cart getById(Integer cart_id);
	List<cart> getAllCart();
	void updateUser(cart c);
	cart getByEmailAndPassword(String email, String password);
	void deleteCart(Integer cart_id);
}

