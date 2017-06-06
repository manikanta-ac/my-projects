package com.span.hungerZone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.span.hungerZone.dao.HungerZoneDAO;
import com.span.hungerZone.model.Category;
import com.span.hungerZone.model.Dish;
import com.span.hungerZone.model.Restaurant;
import com.span.hungerZone.model.RestaurantCategoryAssociation;
import com.span.hungerZone.model.RestaurantCategoryDishAssociation;

@Transactional
public class HungerZoneServiceImpl implements HungerZoneService
{
	@Autowired
	HungerZoneDAO hungerZoneDAO;

	@Override
	public List<Restaurant> getAllRestaurants()
	{
		return hungerZoneDAO.getAllRestaurants();
	}

	@Override
	public List<Category> getCategories(Restaurant restaurant) 
	{
		return hungerZoneDAO.getCategories(restaurant);
	}

	@Override
	public List<RestaurantCategoryDishAssociation> getDishes(
			Restaurant restaurant, Category category) 
	{
		return hungerZoneDAO.getDishes(restaurant, category);
	}

	@Override
	public Restaurant getRestaurantByName(String restaurantName) 
	{
		return hungerZoneDAO.getRestaurantByName(restaurantName);
	}

	@Override
	public Category getCategoryByName(String categoryName) 
	{
		return hungerZoneDAO.getCategoryByName(categoryName);
	}

	@Override
	public List<Category> getAllCategories() 
	{
		return hungerZoneDAO.getAllCategories();
	}

	@Override
	public List<Dish> getAllDishes() 
	{
		return hungerZoneDAO.getAllDishes();
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) 
	{
		hungerZoneDAO.updateRestaurant(restaurant);
	}

	@Override
	public void addRestaurant(Restaurant restaurant) 
	{
		hungerZoneDAO.addRestaurant(restaurant);
	}

	@Override
	public void addRestaurantCategoryAssociations(
			List<RestaurantCategoryAssociation> restaurantCategoryAssociations) 
	{
		hungerZoneDAO.addRestaurantCategoryAssociations(restaurantCategoryAssociations);
	}
	
	@Override
	public RestaurantCategoryDishAssociation getRestaurantCategoryDishAssociation(
			RestaurantCategoryAssociation restaurantCategoryAssociation,Dish dish) 
	{
		return hungerZoneDAO.getRestaurantCategoryDishAssociation(restaurantCategoryAssociation, dish);
	}
	
	@Override
	public void addRestaurantCategoryDishAssociations(
			List<RestaurantCategoryDishAssociation> restaurantCategoryDishAssociations) 
	{
		hungerZoneDAO.addRestaurantCategoryDishAssociations(restaurantCategoryDishAssociations);
	}

	@Override
	public Dish getDishByName(String dishName) 
	{
		return hungerZoneDAO.getDishByName(dishName);
	}

	@Override
	public RestaurantCategoryAssociation getRestaurantCategoryAssociation(
			Restaurant restaurant, Category category) 
	{
		return hungerZoneDAO.getRestaurantCategoryAssociation(restaurant, category);
	}

	@Override
	public void deleteRestaurant(Restaurant restaurant) 
	{
		hungerZoneDAO.deleteRestaurant(restaurant);
	}

	@Override
	public void deleteRestaurantCategoryAssociations(RestaurantCategoryAssociation restaurantCategoryAssociation) 
	{
		hungerZoneDAO.deleteRestaurantCategoryAssociations(restaurantCategoryAssociation);
	}

	@Override
	public void deleteRestaurantCategoryDishAssociations(
			RestaurantCategoryDishAssociation restaurantCategoryDishAssociation) 
	{
		hungerZoneDAO.deleteRestaurantCategoryDishAssociations(restaurantCategoryDishAssociation);
	}
}
