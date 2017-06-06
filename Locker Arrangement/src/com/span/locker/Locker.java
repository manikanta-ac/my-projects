package com.span.locker;

import java.util.ArrayList;
import java.util.List;

public class Locker implements Comparable<Locker>{
	private String name;
	private List<Person> persons;
	private int sum;
	
	public Locker(String name) {
		this.name = name;
		this.persons = new ArrayList<Person>();
		this.sum = 0;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void addPerson(Person person) {
		this.persons.add(person);
	}
	public int getSum() {
		return sum;
	}
	public void addSum(int sum) {
		this.sum += sum;
	}
	@Override
	public int compareTo(Locker locker) {
		return locker.getSum() - this.getSum();
	}
}
