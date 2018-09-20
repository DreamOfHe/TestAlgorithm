package com.hlx.algorithm.array;

public class Person {

	private String lastName;
	private String firstName;
	private int age;
	
	public Person(String lastName, String firstName, int age) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}
	
	public void displayPerson(){
		System.out.print("\nLast name: " + lastName);
		System.out.print(", First name: " + firstName);
		System.out.print(", Age: " + age);
	}
	
	public String getLast(){
		return lastName;
	}
}
