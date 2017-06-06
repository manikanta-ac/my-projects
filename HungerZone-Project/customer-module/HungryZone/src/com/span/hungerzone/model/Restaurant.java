package com.span.hungerzone.model;

import java.util.List;

public class Restaurant {

	private String restaurantName;
	private String restaurnatAddress;
	private List categories;
	private int[] checkCategories;
	
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public List getCategories() {
		return categories;
	}
	public void setCategories(List categories) {
		this.categories = categories;
	}
	public String getRestaurnatAddress() {
		return restaurnatAddress;
	}
	public void setRestaurnatAddress(String restaurnatAddress) {
		this.restaurnatAddress = restaurnatAddress;
	}
	public int[] getCheckCategories() {
		return checkCategories;
	}
	public void setCheckCategories(int[] checkCategories) {
		this.checkCategories = checkCategories;
	}
	
	
}
