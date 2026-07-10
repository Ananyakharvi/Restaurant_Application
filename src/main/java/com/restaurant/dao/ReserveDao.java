package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Reserve;

public interface ReserveDao {
	void addReseve(Reserve r);
	Reserve getById(Integer reserve_id);
	List<Reserve> getAllReserve();
	void updateReserve(Reserve r);
	void deleteCustomer(Integer reserve_id);
}
