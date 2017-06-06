package com.span.hungerZone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order
{
	@Id
	@GeneratedValue
	@Column(name="order_Id")
	private int id;
	
	@OneToOne
	@JoinColumn(name="customer_Id")
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private List<OrderedDish> orderedDishes;
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Customer getCustomer()
	{
		return customer;
	}
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}
	public List<OrderedDish> getOrderedDishes()
	{
		return orderedDishes;
	}
	public void setOrderedDishes(List<OrderedDish> orderedDishes)
	{
		this.orderedDishes = orderedDishes;
	}
}
