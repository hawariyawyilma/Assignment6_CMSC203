/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: This class represents a Smoothie beverage, a type of drink available 
 * at the BevShop. It includes specific attributes such as the number of fruits 
 * and whether protein is added to the smoothie. The class extends the Beverage 
 * class and calculates the price of the smoothie based on its size, fruit count, 
 * and protein addition.
 * Due: 12/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Hawariyaw Yilma
 */
public class Smoothie extends Beverage {
	static final double FRUIT_FEE = 0.50;
	static final double PROTEIN_FEE = 1.50;
	
	private int numOfFruits;
	private boolean addProtein;
	

	public Smoothie(String bevName, SIZE size, int numOfFruits, boolean addProtein)
	{
		super(bevName, TYPE.SMOOTHIE, size);
		this.addProtein = addProtein;
		this.numOfFruits = numOfFruits;
		
	}

	/**
	 * get number of fruit 
	 * @return - number of fruit
	 */
	public int getNumOfFruits() {
		return numOfFruits;
	}

	/**
	 * set number of fruit
	 * @param numOfFruits
	 */
	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	/**
	 * get value for add protein
	 * @return - add protein
	 */
	public boolean getAddProtein() {
		return addProtein;
	}

	/**
	 * set value for add protein
	 * @param addProtein
	 */
	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}
	
	/**
	 * checks if this Beverage equals to anotherBev
	 * @return - true if the name, type, size and base price, number of Fruits
	 * 			 and add protein are the same, false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev)
	{
		Beverage test = (Beverage)anotherBev;
		if(super.getBevName().equals(test.getBevName()) && super.getSize().equals(test.getSize()) 
				&& super.getType().equals(test.getType()))
		{
			Smoothie test2 = (Smoothie)anotherBev;
			if(this.numOfFruits == test2.numOfFruits && this.addProtein == test2.addProtein )
				return true;
		}
					
		return false;
	}
	
	/**
	 * calculates and returns the alcohol beverage price return price of alcohol beverage
	 * @return - the price of the beverage
	 */
	@Override
	public double calcPrice() 
	{
		if(this.addProtein)
			return (super.addSizePrice()+ (FRUIT_FEE*this.numOfFruits)+ PROTEIN_FEE);
					
		return (super.addSizePrice()+ (FRUIT_FEE*this.numOfFruits));
	}
	
	/**
	 * returns the string representation of a Smoothie drink. 
	 * Contains the name , size, whether or not protein added , number of fruits and price
	 * @return - the string representation of a Smoothie drink.
	 */
	@Override
	public String toString() 
	{
		if(addProtein)
			return super.toString()+ "\n Protein added to smoothie \n Number of Fruit: "
				+this.numOfFruits +"\n Price: "+ calcPrice() ;
		
		return super.toString()+ "\n Number of Fruit: "+this.numOfFruits +"\n Price: "+ calcPrice() ;
	}

}