package com.restaurant.dto;

import java.sql.Date;

public class Customer {
	private Integer c_id;
	private String c_name;
	private String email;
	private String phone;
	private String c_pswd;
	private Date created_at;

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getC_pswd() {
		return c_pswd;
	}

	public void setC_pswd(String c_pswd) {
		this.c_pswd = c_pswd;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
}
