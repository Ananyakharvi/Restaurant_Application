package com.restaurant.dto;

import java.sql.Date;

public class Restaurant_tableDto {
  private Integer t_id;
  private Integer capacity;
  private String status;
  public Integer getT_id() {
	return t_id;
}
  public void setT_id(Integer t_id) {
	this.t_id = t_id;
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
  public Date getTcreated_at() {
	return tcreated_at;
  }
  public void setTcreated_at(Date tcreated_at) {
	this.tcreated_at = tcreated_at;
  }
  private Date tcreated_at;
}
