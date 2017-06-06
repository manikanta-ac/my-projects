package com.span.hungerZone.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;
import com.span.hungerZone.model.Category;
import com.span.hungerZone.model.Dish;
import com.span.hungerZone.model.Restaurant;
import com.span.hungerZone.model.RestaurantCategoryAssociation;
import com.span.hungerZone.model.RestaurantCategoryDishAssociation;

public class HungerZoneDAOImpl implements HungerZoneDAO
{
	private HibernateTemplate hibernateTemplate;
	
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate)
	{
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Restaurant> getAllRestaurants()
	{
		System.out.println(hibernateTemplate.find("from Restaurant").size()+"--------------->");
		
		return hibernateTemplate.find("from Restaurant");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getCategories(Restaurant restaurant) 
	{
		List<Category> categories = new ArrayList<Category>();
		
		List<RestaurantCategoryAssociation> categoryAssociations = 
				hibernateTemplate.find("from RestaurantCategoryAssociation where restaurant.id="+restaurant.getId());
		for(RestaurantCategoryAssociation categoryAssociation:categoryAssociations)
		{
			categories.add(categoryAssociation.getCategory());
		}
		return categories;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RestaurantCategoryDishAssociation> getDishes(
			Restaurant restaurant, Category category) 
	{
		RestaurantCategoryAssociation restaurantCategoryAssociation = (RestaurantCategoryAssociation) 
			hibernateTemplate.find("from RestaurantCategoryAssociation " +
					"where restaurant.id="+restaurant.getId()+" and category.id="+category.getId()).get(0);
		
		return hibernateTemplate.find("from RestaurantCategoryDishAssociation " +
				"where restaurantCategoryAssociation.id="+restaurantCategoryAssociation.getId());
	}

	@Override
	public Restaurant getRestaurantByName(String restaurantName) 
	{
		return (Restaurant) hibernateTemplate.find("from Restaurant where name='"+restaurantName+"'").get(0);
	}

	@Override
	public Category getCategoryByName(String categoryName) 
	{
		return (Category) hibernateTemplate.find("from Category where name='"+categoryName+"'").get(0);
	}
	
	@Override
	public Dish getDishByName(String dishName) 
	{
		return (Dish) hibernateTemplate.find("from Dish where name='"+dishName+"'").get(0);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() 
	{
		return hibernateTemplate.find("from Category");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dish> getAllDishes() 
	{
		return hibernateTemplate.find("from Dish");
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) 
	{
		hibernateTemplate.update(restaurant);
	}

	@Override
	public void addRestaurant(Restaurant restaurant) 
	{
		hibernateTemplate.save(restaurant);
	}

	@Override
	public void addRestaurantCategoryAssociations(
			List<RestaurantCategoryAssociation> restaurantCategoryAssociations) 
	{
		hibernateTemplate.saveOrUpdateAll(restaurantCategoryAssociations);
	}

	@Override
	public void addRestaurantCategoryDishAssociations(
			List<RestaurantCategoryDishAssociation> restaurantCategoryDishAssociations) 
	{
		hibernateTemplate.saveOrUpdateAll(restaurantCategoryDishAssociations);
	}

	@Override
	public RestaurantCategoryAssociation getRestaurantCategoryAssociation(
			Restaurant restaurant, Category category) 
	{
		return (RestaurantCategoryAssociation)hibernateTemplate.find("from RestaurantCategoryAssociation " +
				"where restaurant.id="+restaurant.getId()+" and category.id="+category.getId()).get(0);
	}
	
	@Override
	public RestaurantCategoryDishAssociation getRestaurantCategoryDishAssociation(
			RestaurantCategoryAssociation restaurantCategoryAssociation,Dish dish) 
	{
		return (RestaurantCategoryDishAssociation) hibernateTemplate.find("from RestaurantCategoryDishAssociation " +
				"where restaurantCategoryAssociation.id="+restaurantCategoryAssociation.getId()+" and dish.id="+dish.getId()).get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteRestaurant(Restaurant restaurant) 
	{
		List<RestaurantCategoryAssociation> categoryAssociations = 
				hibernateTemplate.find("from RestaurantCategoryAssociation where restaurant.id="+restaurant.getId()); 
		
		List<RestaurantCategoryDishAssociation> categoryDishAssociations;
		
		for(RestaurantCategoryAssociation categoryAssociation:categoryAssociations)
		{
			categoryDishAssociations = hibernateTemplate.find("from RestaurantCategoryDishAssociation " +
							"where restaurantCategoryAssociation.id="+categoryAssociation.getId());
			
			hibernateTemplate.deleteAll(categoryDishAssociations);
		}
		
		hibernateTemplate.deleteAll(categoryAssociations);
		
		hibernateTemplate.delete(restaurant);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteRestaurantCategoryAssociations(RestaurantCategoryAssociation restaurantCategoryAssociation) 
	{
		List<RestaurantCategoryDishAssociation> categoryDishAssociations = 
				hibernateTemplate.find("from RestaurantCategoryDishAssociation " +
						"where restaurantCategoryAssociation.id="+restaurantCategoryAssociation.getId());
		
		hibernateTemplate.deleteAll(categoryDishAssociations);
		
		hibernateTemplate.delete(restaurantCategoryAssociation);		
	}

	@Override
	public void deleteRestaurantCategoryDishAssociations(
			RestaurantCategoryDishAssociation restaurantCategoryDishAssociation) 
	{
		hibernateTemplate.delete(restaurantCategoryDishAssociation);
	}
}
