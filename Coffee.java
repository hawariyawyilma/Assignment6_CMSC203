/*
 * Course: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Overview: The BevShop offers a selection of drinks divided into three categories: 
 * Coffee, Alcoholic, and Smoothie. These beverages come in three different sizes: 
 * Small, Medium, and Large. Each drink type starts with a base price, with 
 * additional costs applied based on size upgrades and specific add-ons for each 
 * beverage category. Your task is to create a program that effectively manages 
 * the BevShop, handling the ordering process and pricing dynamically.
 * Submission Deadline: 12/14/2024
 * Development Environment: Eclipse
 * I certify that I have completed this programming assignment on my own. 
 * I have not copied the code from any other student or source. 
 * I have not shared my code with any other student.
 * Name: Hawariyaw Yilma
 */

public class Coffee extends Beverage {
	
	static final double EXTRA_COFFEE = 0.5;
	static final double EXTRA_SYRUP = 0.5;
	
	private boolean extraShot;
	private boolean extraSyrup;
	
	/**
	 * Creates a Coffee object using the given values
	 * @param bevName
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	Coffee(String bevName, SIZE size, boolean extraShot, boolean extraSyrup)
	{
		super(bevName, TYPE.COFFEE, size);
		this.extraSyrup = extraSyrup;
		this.extraShot = extraShot;
	}

	/**
	 * gets value for extra shot
	 * @return - value for extra shot
	 */
	public boolean getExtraShot() {
		return extraShot;
	}

	/**
	 *sets value for extra shot
	 * @param extraShot
	 */
	public void setExtraShot(boolean extraShot) {
		this.extraShot = extraShot;
	}

	/**
	 * gets value for extra syrup
	 * @return - value for extra syrup
	 */
	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	/**
	 *sets value for extra syrup
	 * @param extraSyrup
	 */
	public void setExtraSyrup(boolean extraSyrup) {
		this.extraSyrup = extraSyrup;
	}

	/**
	 * Calculates the price based on base price, size, extra coffee shot and extra syrup
	 * @return - Price of coffee based on spec
	 */
	@Override
	public double calcPrice() 
	{
		double price = 0;
		
		if(this.extraShot && this.extraSyrup)
		{
			price = (super.addSizePrice()+ EXTRA_COFFEE + EXTRA_SYRUP);
		}
		else if(this.extraShot)
		{
			price = (super.addSizePrice()+ EXTRA_COFFEE);
		}
		else if(this.extraSyrup)
		{
			price = (super.addSizePrice()+ EXTRA_SYRUP);
		}
		else
		{
			price = super.addSizePrice();
		}		
		
		return price;
	}
	
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @return - true if the name, type, size and base price and whether 
	 * 			 or not it contains extra shot and extra syrup false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev)
	{
		Beverage test = (Beverage)anotherBev;
		if(super.getBevName().equals(test.getBevName()) && super.getSize().equals(test.getSize()) 
				&& super.getType().equals(test.getType()))
		{
			Coffee test2 = (Coffee)anotherBev;
			if(this.extraShot == test2.extraShot && this.extraSyrup == test2.extraSyrup )
				return true;
		}
					
		return false;
	}

	/**
	 * Represents a Coffee beverage in the following String format: 
	 * name,size, whether it contains extra shot, extra syrup and the price
	 * @return - String representation of a Coffee
	 */
	@Override
	public String toString() 
	{
		if(this.extraShot && this.extraSyrup)
		{
			return super.toString()+ "\n Extra shot of Coffee and Syrup added" +"\n Price: "+ calcPrice();
		}
		else if(this.extraSyrup)
		{
			return super.toString()+ "\n Extra shot of Syrup added" +"\n Price: "+ calcPrice();
		}
		else if(this.extraShot)
		{
			return super.toString()+ "\n Extra shot of Coffee added" +"\n Price: "+ calcPrice();
		}
		else
		{
			return super.toString()+"\n Price: "+ calcPrice() ;
		}
			
	}
		

}