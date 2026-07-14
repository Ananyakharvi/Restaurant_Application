package com.restaurant.dto;

public class order_item {
   private Integer item_id;
   private Integer order_id;
   private Integer menu_id;
   private Double price;
   private Integer quantity;
   public Integer getItem_id() {
	return item_id;
   }
   public void setItem_id(Integer item_id) {
	this.item_id = item_id;
   }
   public Integer getOrder_id() {
	return order_id;
   }
   public void setOrder_id(Integer order_id) {
	this.order_id = order_id;
   }
   public Integer getMenu_id() {
	return menu_id;
   }
   public void setMenu_id(Integer menu_id) {
	this.menu_id = menu_id;
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
  
   
}
