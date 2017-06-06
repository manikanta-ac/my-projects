package com.span.locker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockerArrangement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("n : number of people");
		int noOfPeople = scanner.nextInt();
		List<Person> persons = new ArrayList<Person>(noOfPeople);

		System.out.println("y : number of lockers");
		int noOfLockers = scanner.nextInt();
		List<Locker> lockers = new ArrayList<Locker>(noOfLockers);
		for(int i=0; i<noOfLockers; i++) {	//Creating 'y' no.of locker objects
			lockers.add(new Locker("L" + i));
		}

		int money = 1;
		double total = 0;
		for(int i=1; i<=noOfPeople; i++) {	//Reading money from 'n' persons
			System.out.println("Enter P"+ i +" money:");
			money = scanner.nextInt();
			persons.add(new Person("P" + i, money));
			total += money;
		}

		Collections.sort(persons);	//Descending order of money

		double avgLockerMoney = 1;
		List<Locker> availabeLockers = new ArrayList<Locker>(lockers);
		Locker availabeLocker = null;
		for(Person person: persons) {
			avgLockerMoney = total/noOfLockers;
			money = person.getMoney();
			availabeLocker = nextAvailabeLocker(availabeLockers, money, avgLockerMoney);
			availabeLocker.addPerson(person);
			availabeLocker.addSum(money);
			person.setLocker(availabeLocker);
			if(availabeLocker.getSum() >= avgLockerMoney) {
				total -= money;
				noOfLockers--; 
				availabeLockers.remove(availabeLocker);
			}
		}

		Collections.sort(lockers);	//Descending order of locker total value
		for(Locker locker: lockers) {
			System.out.println(locker.getName() + ":" + locker.getPersons() + ":" + locker.getSum());
		}
	}

	private static Locker nextAvailabeLocker(List<Locker> lockers, int money, double avgLockerMoney) {
		Locker availabeLocker = lockers.get(0);	//Just for initialising some value
		double maxAvailableLockerMoney = avgLockerMoney;
		for(Locker locker: lockers) {
			if (money >= avgLockerMoney) {
				availabeLocker = locker;
				break;
			} else if((locker.getSum() + money - avgLockerMoney) < maxAvailableLockerMoney) {	//To find best fit locker
				maxAvailableLockerMoney = locker.getSum() + money - avgLockerMoney;
				availabeLocker = locker;
			}
		}
		return availabeLocker;
	}
}
