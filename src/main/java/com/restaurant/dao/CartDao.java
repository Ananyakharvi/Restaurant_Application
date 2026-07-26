package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Cart;



public interface CartDao {
<<<<<<< HEAD
	void addCart(Cart c);
	Cart getById(Integer cart_id);
	List<Cart> getAllCart();
	void updateCart(Cart c);
=======
	void addCart(cart c);
	cart getById(Integer cart_id);
	List<cart> getAllCart();
	void updateUser(cart c);
	void updateCart(cart c);
>>>>>>> 83c88f2c65e93704326f89f55fe3120923339eec
	void deleteCart(Integer cart_id);
}

