package com.restaurant.dto;

public class Menu_item {
  private Integer menu_id;
  private String food_name;
  private String category;
  private String description;
  private Double price;
  private String image;
  private Boolean is_available;
  public Integer getMenu_id() {
	return menu_id;
  }
  public void setMenu_id(Integer menu_id) {
	this.menu_id = menu_id;
  }
  public String getFood_name() {
	return food_name;
  }
  public void setFood_name(String food_name) {
	this.food_name = food_name;
  }
  public String getCategory() {
	return category;
  }
  public void setCategory(String category) {
	this.category = category;
  }
  public String getDescription() {
	return description;
  }
  public void setDescription(String description) {
	this.description = description;
  }
  public Double getPrice() {
	return price;
  }
  public void setPrice(Double price) {
	this.price = price;
  }
  public String getImage() {
	return image;
  }
  public void setImage(String image) {
	this.image = image;
  }
  public Boolean getIs_available() {
	return is_available;
  }
  public void setIs_available(Boolean is_available) {
	this.is_available = is_available;
  }
  
}