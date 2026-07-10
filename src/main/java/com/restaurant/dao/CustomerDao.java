package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.Customer;

public interface CustomerDao {
	void addCustomer(Customer c);
	Customer getById(Integer c_id);
	List<Customer> getAllCustomer();
	void updateCustomer(Customer c);
	Customer getByEmailAndPassword(String email, String c_pswd);
	void deleteCustomer(Customer c_id);
}
