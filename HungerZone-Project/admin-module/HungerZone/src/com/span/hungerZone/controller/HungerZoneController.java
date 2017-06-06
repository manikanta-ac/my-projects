package com.span.hungerZone.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.span.hungerZone.model.AdminHome;
import com.span.hungerZone.model.Category;
import com.span.hungerZone.model.Dish;
import com.span.hungerZone.model.Restaurant;
import com.span.hungerZone.model.RestaurantCategoryAssociation;
import com.span.hungerZone.model.RestaurantCategoryDishAssociation;
import com.span.hungerZone.service.HungerZoneService;

@Controller
public class HungerZoneController
{
	@Autowired
	HungerZoneService hungerZoneService;
	
	@RequestMapping("/")
	public String welcome(Model model)
	{
		System.out.println("Test.......!");
		
		model.addAttribute("adminHome", new AdminHome());
		model.addAttribute("addRestaurant", new AdminHome());

		return "adminHome";
	}
	
	@RequestMapping("/loadRestaurants")
	public @ResponseBody String loadRestaurants(Model model)
	{
		System.out.println("Test-----Ajax using JQuery---------->");
		
		List<Restaurant> restaurants = hungerZoneService.getAllRestaurants();
		
		String html = "";
		for(int i=0;i<restaurants.size();i++)
		{
			html += restaurants.get(i).getName();
			
			if(i!=restaurants.size()-1)
				html += ",";
		}
		
		return html;
	}
	
	@RequestMapping("/loadAllCategories")
	public @ResponseBody String loadAllCategories()
	{	
		System.out.println("Loading All Categories----------->");
		
		List<Category> categories = hungerZoneService.getAllCategories();
		
		String html = "";
		for(int i=0;i<categories.size();i++)
		{
			html += categories.get(i).getName();
			
			if(i!=categories.size()-1)
				html += ",";
		}
		
		return html;
	}
	
	@RequestMapping("/loadAllDishes")
	public @ResponseBody String loadAllDishes()
	{
		System.out.println("Loading All Dishes----------->");
		
		List<Dish> dishes = hungerZoneService.getAllDishes();
		
		String html = "";
		for(int i=0;i<dishes.size();i++)
		{
			html += dishes.get(i).getName();
			
			if(i!=dishes.size()-1)
				html += ",";
		}
		
		return html;
	}
	
	@RequestMapping("/loadCategories/{restName}")
	public @ResponseBody String loadCategories(@PathVariable String restName)
	{	
		System.out.println(restName+"----------->");
		Restaurant restaurant = hungerZoneService.getRestaurantByName(restName);
		
		List<Category> categories = hungerZoneService.getCategories(restaurant);
		
		String html = "";
		for(int i=0;i<categories.size();i++)
		{
			html += categories.get(i).getName()+",";
		}
		
		html += restaurant.getAddress();
		
		return html;
	}
	
	@RequestMapping("/loadDishes/{restCatNames}")
	public @ResponseBody String loadDishes(@PathVariable String restCatNames)
	{
		System.out.println(restCatNames+"----------->");
		String []names = restCatNames.split(",");
		String restaurantName = names[0];
		String categoryName = names[1];
		
		Restaurant restaurant = hungerZoneService.getRestaurantByName(restaurantName);
		Category category = hungerZoneService.getCategoryByName(categoryName);
		
		List<RestaurantCategoryDishAssociation> dishes = hungerZoneService.getDishes(restaurant, category);
		
		String html = "";
		for(int i=0;i<dishes.size();i++)
		{
			html += dishes.get(i).getDish().getName()+"-"+dishes.get(i).getCost();
			
			if(i!=dishes.size()-1)
				html += ",";
		}
		return html;
	}
	
	@RequestMapping(value="/updateAddress/{restaurantAddress}", method=RequestMethod.POST)
	public @ResponseBody String updateAddress(@PathVariable String restaurantAddress) 
	{
		System.out.println("Updating Address------------------->");
		String []names = restaurantAddress.split("-");
		String restaurantName = names[0];
		String newAddress = names[1];
		
		Restaurant restaurant = hungerZoneService.getRestaurantByName(restaurantName);
		restaurant.setAddress(newAddress);
		
		hungerZoneService.updateRestaurant(restaurant);
		
		return newAddress;
	}
	
	@RequestMapping(value="/homeAction", params="logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) 
	{
		request.getSession().invalidate();
		return "login";
	}
	
	@RequestMapping(value="/homeAction", params="deleteRestaurants")
	public String deleteRestaurant(AdminHome adminHome,Model model) 
	{
		System.out.println("Selected Restaurants:"+adminHome.getSelectedRestaurants());
		
		Restaurant restaurant;
		
		for(String restaurantName:adminHome.getSelectedRestaurants())
		{
			restaurant = hungerZoneService.getRestaurantByName(restaurantName);
			
			hungerZoneService.deleteRestaurant(restaurant);
		}
		
		model.addAttribute("adminHome", new AdminHome());
		model.addAttribute("addRestaurant", new AdminHome());
		
		return "adminHome";
	}
	
	@RequestMapping(value="/homeAction", params="deleteCategories")
	public String deleteCategory(AdminHome adminHome,Model model) 
	{
		System.out.println("Selected Categories:"+adminHome.getSelectedCategories());
		
		Restaurant restaurant = hungerZoneService.getRestaurantByName(adminHome.getRestaurantName());
		
		Category category;
		RestaurantCategoryAssociation restaurantCategoryAssociation;
		
		for(String categoryName:adminHome.getSelectedCategories())
		{
			category = hungerZoneService.getCategoryByName(categoryName);
			
			restaurantCategoryAssociation = hungerZoneService.getRestaurantCategoryAssociation(restaurant, category);
			
			hungerZoneService.deleteRestaurantCategoryAssociations(restaurantCategoryAssociation);
		}
		
		model.addAttribute("adminHome", new AdminHome());
		model.addAttribute("addRestaurant", new AdminHome());
		
		return "adminHome";
	}
	
	@RequestMapping(value="/homeAction", params="deleteDishes")
	public String deleteDish(AdminHome adminHome,Model model) 
	{
		System.out.println("Selected Dishes:"+adminHome.getSelectedDishes());
		
		Restaurant restaurant = hungerZoneService.getRestaurantByName(adminHome.getRestaurantName());
		Category category = hungerZoneService.getCategoryByName(adminHome.getSelectedCategory());
		
		RestaurantCategoryAssociation restaurantCategoryAssociation = 
					hungerZoneService.getRestaurantCategoryAssociation(restaurant, category);
		
		List<String> dishNames = adminHome.getSelectedDishes();
		Dish dish;
		
		RestaurantCategoryDishAssociation restaurantCategoryDishAssociation;
		
		for(String dishName:dishNames)
		{
			dish = hungerZoneService.getDishByName(dishName);
			
			restaurantCategoryDishAssociation = hungerZoneService.getRestaurantCategoryDishAssociation(restaurantCategoryAssociation,dish);
			
			hungerZoneService.deleteRestaurantCategoryDishAssociations(restaurantCategoryDishAssociation);
		}
		
		model.addAttribute("adminHome", new AdminHome());
		model.addAttribute("addRestaurant", new AdminHome());
		
		return "adminHome";
	}
	
	@RequestMapping(value="/addRestaurant",method=RequestMethod.POST)
	public String addRestaurant(AdminHome addRestaurant,Model model) 
	{
		Restaurant restaurant = new Restaurant();
		
		restaurant.setName(addRestaurant.getRestaurantName());
		restaurant.setAddress(addRestaurant.getRestaurantAddress());
		
		hungerZoneService.addRestaurant(restaurant);
		
		model.addAttribute("adminHome", new AdminHome());
		model.addAttribute("addRestaurant", new AdminHome());
		
		return "adminHome";
	}
	
	@RequestMapping(value="/addRestaurantCategories",method=RequestMethod.POST)
	public String addRestaurantCategories(AdminHome addRestaurant,Model model) 
	{
		System.out.println(addRestaurant+"------------->");
		System.out.println(addRestaurant.getRestaurantName()+"****************");
		System.out.println(addRestaurant.getRestaurantAddress()+"****************");
		System.out.println(addRestaurant.getSelectedCategories()+"****************");
		System.out.println(addRestaurant.getSelectedCategory()+"****************");
		
		Restaurant restaurant = hungerZoneService.getRestaurantByName(addRestaurant.getRestaurantName());

		List<String> categoryNames = addRestaurant.getSelectedCategories();
		
		Category category;
		RestaurantCategoryAssociation restaurantCategoryAssociation;
		
		List<Category> categories = new ArrayList<Category>();
		List<RestaurantCategoryAssociation> restaurantCategoryAssociations =
				new ArrayList<RestaurantCategoryAssociation>();
		
		for(String categoryName:categoryNames)
		{
			category = hungerZoneService.getCategoryByName(categoryName);
			
			categories.add(category);
			
			restaurantCategoryAssociation = new RestaurantCategoryAssociation();
			
			restaurantCategoryAssociation.setRestaurant(restaurant);
			restaurantCategoryAssociation.setCategory(category);
			
			restaurantCategoryAssociations.add(restaurantCategoryAssociation);
		}
		
		hungerZoneService.addRestaurantCategoryAssociations(restaurantCategoryAssociations);
		
		model.addAttribute("adminHome", new AdminHome());
		model.addAttribute("addRestaurant", new AdminHome());
		
		return "adminHome";
	}
	
	@RequestMapping(value="/addRestaurantCategoryDishes",method=RequestMethod.POST)
	public String newRestaurantCategoryDishesForm(AdminHome addRestaurant,Model model) 
	{
		System.out.println(addRestaurant+"------------->");
		System.out.println(addRestaurant.getRestaurantName()+"****************");
		System.out.println(addRestaurant.getRestaurantAddress()+"****************");
		System.out.println(addRestaurant.getSelectedCategories()+"****************");
		System.out.println(addRestaurant.getSelectedCategory()+"****************");
		System.out.println("Selected Dishes:"+addRestaurant.getSelectedDishes());
		System.out.println("Selected Dish's Prices:"+addRestaurant.getDihesPrices());
		
		Restaurant restaurant = hungerZoneService.getRestaurantByName(addRestaurant.getRestaurantName());
		Category category = hungerZoneService.getCategoryByName(addRestaurant.getSelectedCategory());
		
		RestaurantCategoryAssociation restaurantCategoryAssociation = 
				hungerZoneService.getRestaurantCategoryAssociation(restaurant,category);
		
		restaurantCategoryAssociation.setRestaurant(restaurant);
		restaurantCategoryAssociation.setCategory(category);
		
		List<String> dishNames = addRestaurant.getSelectedDishes();
		List<Double> dishesPrices = addRestaurant.getDihesPrices();
		
		dishesPrices.removeAll(Collections.singleton(null));
		
		System.out.println("Selected Dish's Prices:"+addRestaurant.getDihesPrices());
		
		List<RestaurantCategoryDishAssociation> restaurantCategoryDishAssociations = 
				new ArrayList<RestaurantCategoryDishAssociation>();
		
		Dish dish;
		RestaurantCategoryDishAssociation restaurantCategoryDishAssociation;
		
		for(int i=0;i<dishNames.size();i++)
		{
			dish = hungerZoneService.getDishByName(dishNames.get(i));
			
			restaurantCategoryDishAssociation = new RestaurantCategoryDishAssociation();
			
			restaurantCategoryDishAssociation.setRestaurantCategoryAssociation(restaurantCategoryAssociation);
			restaurantCategoryDishAssociation.setDish(dish);
			restaurantCategoryDishAssociation.setCost(dishesPrices.get(i));
			
			restaurantCategoryDishAssociations.add(restaurantCategoryDishAssociation);
		}
		
		hungerZoneService.addRestaurantCategoryDishAssociations(restaurantCategoryDishAssociations);
		
		model.addAttribute("adminHome", new AdminHome());
		model.addAttribute("addRestaurant", new AdminHome());
		
		return "adminHome";
	}
}
