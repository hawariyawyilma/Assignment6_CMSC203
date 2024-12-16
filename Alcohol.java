/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: The BevShop provides an array of drinks in three categories: 
 * Coffee, Alcoholic, and Smoothie. These beverages are available in three sizes: 
 * Small, Medium, and Large. Each type of drink starts with a base price, with 
 * additional costs added for size upgrades and specific add-ons tailored to each 
 * beverage type. Your task is to develop a program that operates the BevShop 
 * efficiently, handling the ordering process and pricing dynamically.
 * Due: 12/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Due: 12/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Hawariyaw Yilma
*/

public class Alcohol extends Beverage {
	
	// Constant representing the additional charge for alcoholic beverages ordered on weekends
	static final double WEEKEND_PRICE = 0.6;
	private boolean isWeekend; // Indicates if the beverage is ordered on the weekend
	
	/**
	 * Constructor to initialize an Alcohol object with specified values.
	 * Sets the beverage name, size, and weekend status by calling the superclass constructor.
	 * 
	 * @param bevName   the name of the alcoholic beverage (e.g., "Beer", "Wine")
	 * @param size      the size of the beverage (SMALL, MEDIUM, LARGE)
	 * @param isWeekend indicates if the beverage is ordered on the weekend (true/false)
	 */
	public Alcohol(String bevName, SIZE size, boolean isWeekend) {
		super(bevName, TYPE.ALCOHOL, size); // Initialize common properties using the superclass
		this.isWeekend = isWeekend; // Set the weekend flag for the beverage
	}

	/**
	 * Calculates the total price of the alcoholic beverage.
	 * Adds a weekend surcharge if applicable.
	 * 
	 * @return the total price of the beverage
	 */
	@Override
	public double calcPrice() {
		if (isWeekend) {
			// Add the weekend surcharge to the base price if ordered on the weekend
			return super.addSizePrice() + WEEKEND_PRICE;
		}
		// Return the base price with size adjustment if not a weekend
		return super.addSizePrice();
	}

	/**
	 * Checks if this Alcohol object is equal to another Beverage object.
	 * Equality is determined by matching name, type, size, and weekend status.
	 * 
	 * @param anotherBev the object to compare against
	 * @return true if all attributes match, false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev) {
		// Cast the object to a Beverage instance
		Beverage test = (Beverage) anotherBev;
		// Compare beverage name, size, and type
		if (super.getBevName().equals(test.getBevName()) && 
			super.getSize().equals(test.getSize()) && 
			super.getType().equals(test.getType())) {
			
			// Further cast the object to Alcohol to compare weekend status
			Alcohol test2 = (Alcohol) anotherBev;
			if (this.isWeekend == test2.isWeekend) {
				// Return true if all attributes, including weekend flag, match
				return true;
			}
		}
		// Return false if any attribute does not match
		return false;
	}

	/**
	 * Returns whether the beverage is offered on the weekend.
	 * 
	 * @return true if ordered on the weekend, false otherwise
	 */
	public boolean isWeekend() {
		return isWeekend; // Returns the weekend status
	}

	/**
	 * Updates the weekend status of the beverage.
	 * 
	 * @param isWeekend true if the beverage is ordered on the weekend, false otherwise
	 */
	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend; // Updates the weekend flag
	}

	/**
	 * Provides a string representation of the Alcohol object.
	 * Includes details such as beverage name, size, weekend status, and total price.
	 * 
	 * @return a formatted string with beverage details
	 */
	@Override
	public String toString() {
		// Include weekend surcharge information if applicable
		if (isWeekend) {
			return super.toString() + "\n Drink is offered on weekends for 0.60$ extra\n Price: " + calcPrice();
		}
		// Otherwise, return basic details and price
		return super.toString() + "\n Price: " + calcPrice();
	}
}
