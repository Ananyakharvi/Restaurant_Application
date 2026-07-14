package com.restaurant.dto;

import java.sql.Date;

public class Orders {
  private Integer order_id;
  private Integer user_id;
  private Integer reserve_id;
  private Integer chief_id;
  private Double subtotal;
  private Double gst;
  private Double total_amt;
  private Date order_date; 
  private String order_status;
  public Integer getOrder_id() {
	return order_id;
  }
  public void setOrder_id(Integer order_id) {
	this.order_id = order_id;
  }
  public Integer getUser_id() {
	return user_id;
  }
  public void setUser_id(Integer user_id) {
	this.user_id = user_id;
  }
  public Integer getReserve_id() {
	return reserve_id;
  }
  public void setReserve_id(Integer reserve_id) {
	this.reserve_id = reserve_id;
  }
  public Integer getChief_id() {
	return chief_id;
  }
  public void setChief_id(Integer chief_id) {
	this.chief_id = chief_id;
  }
  public Double getSubtotal() {
	return subtotal;
  }
  public void setSubtotal(Double subtotal) {
	this.subtotal = subtotal;
  }
  public Double getGst() {
	return gst;
  }
  public void setGst(Double gst) {
	this.gst = gst;
  }
  public Double getTotal_amt() {
	return total_amt;
  }
  public void setTotal_amt(Double total_amt) {
	this.total_amt = total_amt;
  }
  public Date getOrder_date() {
	return order_date;
  }
  public void setOrder_date(Date order_date) {
	this.order_date = order_date;
  }
  public String getOrder_status() {
	return order_status;
  }
  public void setOrder_status(String order_status) {
	this.order_status = order_status;
  }
  
  
  
}