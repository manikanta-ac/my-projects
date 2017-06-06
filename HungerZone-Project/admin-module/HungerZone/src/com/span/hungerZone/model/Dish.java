package com.span.hungerZone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="dishes")
public class Dish
{
	@Id
	@GeneratedValue
	@Column(name="dish_Id")
	private int id;
	
	private String name;
	
	@OneToMany(mappedBy="dish")
	private List<RestaurantCategoryDishAssociation> restarantCategoryAssociations;
	
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
	public List<RestaurantCategoryDishAssociation> getRestarantCategoryAssociations()
	{
		return restarantCategoryAssociations;
	}
	public void setRestarantCategoryAssociations(
			List<RestaurantCategoryDishAssociation> restarantCategoryAssociations)
	{
		this.restarantCategoryAssociations = restarantCategoryAssociations;
	}
}
