package com.restaurant.dto;

import java.sql.Time;

public class O_statusDto {
  private Integer status_id;
  private Integer o_id;
  private Integer chef_id;
  private String o_status;
  private Time updated_at;
  public Integer getStatus_id() {
	return status_id;
  }
  public void setStatus_id(Integer status_id) {
	this.status_id = status_id;
  }
  public Integer getO_id() {
	return o_id;
  }
  public void setO_id(Integer o_id) {
	this.o_id = o_id;
  }
  public Integer getChef_id() {
	return chef_id;
  }
  public void setChef_id(Integer chef_id) {
	this.chef_id = chef_id;
  }
  public String getO_status() {
	return o_status;
  }
  public void setO_status(String o_status) {
	this.o_status = o_status;
  }
  public Time getUpdated_at() {
	return updated_at;
  }
  public void setUpdated_at(Time updated_at) {
	this.updated_at = updated_at;
  }
  
}
