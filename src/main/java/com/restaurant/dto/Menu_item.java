package com.restaurant.dto;

public class Menu_item {
  private Integer m_id;
  private String category;
  private String item_name;
  private String description;
  private Double price;
  private String url;
  private Boolean is_available;
  public Integer getM_id() {
	return m_id;
  }
  public void setM_id(Integer m_id) {
	this.m_id = m_id;
  }
  public String getCategory() {
	return category;
  }
  public void setCategory(String category) {
	this.category = category;
  }
  public String getItem_name() {
	return item_name;
  }
  public void setItem_name(String item_name) {
	this.item_name = item_name;
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
  public String getUrl() {
	return url;
  }
  public void setUrl(String url) {
	this.url = url;
  }
  public Boolean getIs_available() {
	return is_available;
  }
  public void setIs_available(Boolean is_available) {
	this.is_available = is_available;
  }
}
