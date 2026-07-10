package com.restaurant.dto;

public class order_item {
   private Integer oi_id;
   private Integer o_id;
   private Integer m_id;
   private Double price;
   private Integer quantity;
   private Double sub_total;
   public Integer getOi_id() {
	return oi_id;
   }
   public void setOi_id(Integer oi_id) {
	this.oi_id = oi_id;
   }
   public Integer getO_id() {
	return o_id;
   }
   public void setO_id(Integer o_id) {
	this.o_id = o_id;
   }
   public Integer getM_id() {
	return m_id;
   }
   public void setM_id(Integer m_id) {
	this.m_id = m_id;
   }
   public Double getPrice() {
	return price;
   }
   public void setPrice(Double price) {
	this.price = price;
   }
   public Integer getQuantity() {
	return quantity;
   }
   public void setQuantity(Integer quantity) {
	this.quantity = quantity;
   }
   public Double getSub_total() {
	return sub_total;
   }
   public void setSub_total(Double sub_total) {
	this.sub_total = sub_total;
   }
 
}
