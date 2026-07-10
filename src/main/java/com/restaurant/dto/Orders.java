package com.restaurant.dto;

import java.sql.Date;

public class Orders {
  private Integer o_id;
  private Integer c_id;
  private Integer t_id;
  private Integer r_id;
  private Double total_amt;
  private Double gst;
  private String order_status;
  private Date ocreated_At;
  public Integer getO_id() {
	return o_id;
  }
  public void setO_id(Integer o_id) {
	this.o_id = o_id;
  }
  public Integer getC_id() {
	return c_id;
  }
  public void setC_id(Integer c_id) {
	this.c_id = c_id;
  }
  public Integer getT_id() {
	return t_id;
  }
  public void setT_id(Integer t_id) {
	this.t_id = t_id;
  }
  public Integer getR_id() {
	return r_id;
  }
  public void setR_id(Integer r_id) {
	this.r_id = r_id;
  }
  public Double getTotal_amt() {
	return total_amt;
  }
  public void setTotal_amt(Double total_amt) {
	this.total_amt = total_amt;
  }
  public Double getGst() {
	return gst;
  }
  public void setGst(Double gst) {
	this.gst = gst;
  }
  public String getOrder_status() {
	return order_status;
  }
  public void setOrder_status(String order_status) {
	this.order_status = order_status;
  }
  public Date getOcreated_At() {
	return ocreated_At;
  }
  public void setOcreated_At(Date ocreated_At) {
	this.ocreated_At = ocreated_At;
  }
}
