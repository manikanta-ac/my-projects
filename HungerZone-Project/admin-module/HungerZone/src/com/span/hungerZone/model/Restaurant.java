package com.span.hungerZone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="restaurants")
public class Restaurant
{
	@Id
	@GeneratedValue
	@Column(name="rest_Id")
	private int id;
	private String name;
	private String address;
	
	@OneToMany(mappedBy="restaurant")
	private List<RestaurantCategoryAssociation> categoryAssociations;
	
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
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public List<RestaurantCategoryAssociation> getCategoryAssociations()
	{
		return categoryAssociations;
	}
	public void addCategoryAssociation(
			RestaurantCategoryAssociation categoryAssociation)
	{
		this.categoryAssociations.add(categoryAssociation);
	}
	public void setCategoryAssociations(
			List<RestaurantCategoryAssociation> categoryAssociations)
	{
		this.categoryAssociations = categoryAssociations;
	}
}
