package com.span.hungerZone.service;

import java.util.List;

import com.span.hungerZone.model.Category;
import com.span.hungerZone.model.Dish;
import com.span.hungerZone.model.Restaurant;
import com.span.hungerZone.model.RestaurantCategoryAssociation;
import com.span.hungerZone.model.RestaurantCategoryDishAssociation;

public interface HungerZoneService
{
	List<Restaurant> getAllRestaurants();
	
	List<Category> getCategories(Restaurant restaurant);
	
	List<RestaurantCategoryDishAssociation> getDishes(Restaurant restaurant, Category category);
	
	Restaurant getRestaurantByName(String restaurantName);
	
	Category getCategoryByName(String categoryName);
	
	Dish getDishByName(String dishName);
	
	List<Category> getAllCategories();
	
	List<Dish> getAllDishes();
	
	RestaurantCategoryAssociation getRestaurantCategoryAssociation(Restaurant restaurant, Category category);
	
	RestaurantCategoryDishAssociation getRestaurantCategoryDishAssociation(
			RestaurantCategoryAssociation restaurantCategoryAssociation,Dish dish);
	
	void addRestaurant(Restaurant restaurant);
	
	void updateRestaurant(Restaurant restaurant);
	
	void addRestaurantCategoryAssociations(List<RestaurantCategoryAssociation> restaurantCategoryAssociations);
	
	void addRestaurantCategoryDishAssociations(List<RestaurantCategoryDishAssociation> restaurantCategoryDishAssociations);
	
	void deleteRestaurant(Restaurant restaurant);
	
	void deleteRestaurantCategoryAssociations(RestaurantCategoryAssociation restaurantCategoryAssociation);

	void deleteRestaurantCategoryDishAssociations(RestaurantCategoryDishAssociation restaurantCategoryDishAssociation);
}
