package com.span.hungerZone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restaurant_category_associations")
public class RestaurantCategoryAssociation
{
	@Id
	@GeneratedValue
	@Column(name="rest_catg_astn_Id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="restaurant_Id")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name="category_Id")
	private Category category;
	
	@OneToMany(mappedBy="restaurantCategoryAssociation")
	private List<RestaurantCategoryDishAssociation> dishAssociations;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Restaurant getRestaurant()
	{
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}
	public Category getCategory()
	{
		return category;
	}
	public void setCategory(Category category)
	{
		this.category = category;
	}
	public List<RestaurantCategoryDishAssociation> getDishAssociations()
	{
		return dishAssociations;
	}
	public void addDishAssociation(
			RestaurantCategoryDishAssociation dishAssociation)
	{
		this.dishAssociations.add(dishAssociation);
	}
	public void setDishAssociations(
			List<RestaurantCategoryDishAssociation> dishAssociations)
	{
		this.dishAssociations = dishAssociations;
	}
}
