package com.span.hungerZone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ordered_dish")
public class OrderedDish
{
	@Id
	@GeneratedValue
	@Column(name="ordered_dish_Id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="order_Id")
	private Order order;
	
	@OneToOne
	@JoinColumn(name="rest_catg_dish_astn_Id")
	private RestaurantCategoryDishAssociation dishAssociation;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Order getOrder()
	{
		return order;
	}
	public void setOrder(Order order)
	{
		this.order = order;
	}
	public RestaurantCategoryDishAssociation getDishAssociation()
	{
		return dishAssociation;
	}
	public void setDishAssociation(RestaurantCategoryDishAssociation dishAssociation)
	{
		this.dishAssociation = dishAssociation;
	}
}
