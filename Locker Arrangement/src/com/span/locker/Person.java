package com.span.locker;

public class Person implements Comparable<Person>{
	private String name;
	private int money;
	private Locker locker;
	public Person(String name, int money) {
		this.setName(name);
		this.setMoney(money);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public Locker getLocker() {
		return locker;
	}
	public void setLocker(Locker locker) {
		this.locker = locker;
	}
	@Override
	public int compareTo(Person p) {
		return p.getMoney() - this.getMoney();
	}
	@Override
	public String toString() {
		return name + ":" + money;
	}
}
