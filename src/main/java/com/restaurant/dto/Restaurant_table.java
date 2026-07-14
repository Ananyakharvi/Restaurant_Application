package com.restaurant.dto;

import java.sql.Date;

public class Restaurant_table {
  private Integer t_id;
  private Integer table_number;
  private Integer capacity;
  private String status;
  public Integer getT_id() {
	return t_id;
  }
  public void setT_id(Integer t_id) {
	this.t_id = t_id;
  }
  public Integer getTable_number() {
	return table_number;
  }
  public void setTable_number(Integer table_number) {
	this.table_number = table_number;
  }
  public Integer getCapacity() {
	return capacity;
  }
  public void setCapacity(Integer capacity) {
	this.capacity = capacity;
  }
  public String getStatus() {
	return status;
  }
  public void setStatus(String status) {
	this.status = status;
  }
  
}