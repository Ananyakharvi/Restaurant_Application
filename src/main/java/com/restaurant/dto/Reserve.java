package com.restaurant.dto;

import java.sql.Date;
import java.sql.Time;

public class Reserve {
  private Integer reserve_id;
  private Integer user_id;
  private Integer t_id;
  private Date reserved_date;
  private Time reserved_time;
  private Integer guests;
  private String status;
  public Integer getReserve_id() {
	return reserve_id;
  }
  public void setReserve_id(Integer reserve_id) {
	this.reserve_id = reserve_id;
  }
  public Integer getUser_id() {
	return user_id;
  }
  public void setUser_id(Integer user_id) {
	this.user_id = user_id;
  }
  public Integer getT_id() {
	return t_id;
  }
  public void setT_id(Integer t_id) {
	this.t_id = t_id;
  }
  public Date getReserved_date() {
	return reserved_date;
  }
  public void setReserved_date(Date reserved_date) {
	this.reserved_date = reserved_date;
  }
  public Time getReserved_time() {
	return reserved_time;
  }
  public void setReserved_time(Time reserved_time) {
	this.reserved_time = reserved_time;
  }
  public Integer getGuests() {
	return guests;
  }
  public void setGuests(Integer guests) {
	this.guests = guests;
  }
  public String getStatus() {
	return status;
  }
  public void setStatus(String status) {
	this.status = status;
  }
  
  
  
}