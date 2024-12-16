/*
 * Course: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Overview: The BevShop offers a variety of beverages, categorized into Coffee, Alcoholic, 
 * and Smoothie types. These drinks are available in three sizes: Small, Medium, and Large. 
 * Each drink starts with a base price, and additional costs are applied for size upgrades 
 * and specific add-ons depending on the drink type. The goal of this program is to 
 * efficiently manage the BevShop by handling orders and dynamically calculating prices.
 * Submission Deadline: 12/14/2024
 * Development Environment: Eclipse
 * I certify that I have independently completed this assignment. 
 * I have not copied any code from other students or sources. 
 * I have not shared my code with anyone.
 * Name: Hawariyaw Yilma
 */

public class Customer {
	
	private String name;
	private int age;
	
	/**
	 * Constructor
	 * @param name
	 * @param age
	 */
	Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	/**
	 * copy constructor
	 * @param c
	 */
	Customer(Customer c)
	{
		this.name = c.getName();
		this.age = c.getAge();
	}

	/**
	 * get method for name
	 * @return - name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set method for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get method for age
	 * @return - age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * set method for age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * String representation of the customer includes the name and age of the customer.
	 * @return - String containing the customer information
	 */
	@Override
	public String toString() 
	{
		return "Customer name= " + this.name + "\n age= " + this.age;
	}
	
	

}
