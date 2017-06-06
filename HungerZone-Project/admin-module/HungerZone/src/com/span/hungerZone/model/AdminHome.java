package com.span.hungerZone.model;

import java.util.List;

public class AdminHome 
{
	private String restaurantName;
	private String restaurantAddress;
	private List<String> selectedRestaurants;
	private List<String> selectedCategories;
	private String selectedCategory;
	private List<String> selectedDishes;
	private List<Double> dihesPrices;
	
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantAddress() {
		return restaurantAddress;
	}
	public void setRestaurantAddress(String restaurantAddress) {
		this.restaurantAddress = restaurantAddress;
	}
	public List<String> getSelectedRestaurants() {
		return selectedRestaurants;
	}
	public void setSelectedRestaurants(List<String> selectedRestaurants) {
		this.selectedRestaurants = selectedRestaurants;
	}
	public List<String> getSelectedCategories() {
		return selectedCategories;
	}
	public void setSelectedCategories(List<String> selectedCategories) {
		this.selectedCategories = selectedCategories;
	}
	public String getSelectedCategory() {
		return selectedCategory;
	}
	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
	public List<String> getSelectedDishes() {
		return selectedDishes;
	}
	public void setSelectedDishes(List<String> selectedDishes) {
		this.selectedDishes = selectedDishes;
	}
	public List<Double> getDihesPrices() {
		return dihesPrices;
	}
	public void setDihesPrices(List<Double> dihesPrices) {
		this.dihesPrices = dihesPrices;
	}
}
