package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Chef;

public interface ChefDao {
	void addChef(Chef chef);
	Chef getById(Integer chef_id);
	List<Chef> getAllChef();
	void updateChef(Chef chef);
	Chef getByEmailAndPassword(String ch_email, String ch_pswd);
	void deleteChef(Chef chef_id);
}
