package com.span.hungerZone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Category
{
	@Id
	@GeneratedValue
	@Column(name="catg_Id")
	private int id;
	private String name;
	
	@OneToMany(mappedBy="category")
	private List<RestaurantCategoryAssociation> restaurantAssociations;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public List<RestaurantCategoryAssociation> getRestaurantAssociations()
	{
		return restaurantAssociations;
	}
	public void addRestaurantAssociation(
			RestaurantCategoryAssociation restaurantAssociation)
	{
		this.restaurantAssociations.add(restaurantAssociation);
	}
	public void setRestaurantAssociations(
			List<RestaurantCategoryAssociation> restaurantAssociations)
	{
		this.restaurantAssociations = restaurantAssociations;
	}	
}
