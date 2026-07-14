package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.User;

public interface UserDao {
	void addUser(User u);
	User getById(Integer user_id);
	List<User> getAllUser();
	void updateUser(User u);
	User getByEmailAndPassword(String email, String password);
	void deleteUser(Integer user_id);
}
