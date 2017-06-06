package com.span.hungerZone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_category_dish_associations")
public class RestaurantCategoryDishAssociation
{
	@Id
	@GeneratedValue
	@Column(name="rest_catg_dish_astn_Id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="dish_Id")
	private Dish dish;
	
	private double cost;
	
	@ManyToOne
	@JoinColumn(name="rest_catg_astn_Id")
	private RestaurantCategoryAssociation restaurantCategoryAssociation;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Dish getDish()
	{
		return dish;
	}
	public void setDish(Dish dish)
	{
		this.dish = dish;
	}
	public RestaurantCategoryAssociation getRestaurantCategoryAssociation()
	{
		return restaurantCategoryAssociation;
	}
	public void setRestaurantCategoryAssociation(
			RestaurantCategoryAssociation restaurantCategoryAssociation)
	{
		this.restaurantCategoryAssociation = restaurantCategoryAssociation;
	}
	public double getCost()
	{
		return cost;
	}
	public void setCost(double cost)
	{
		this.cost = cost;
	}	
}
