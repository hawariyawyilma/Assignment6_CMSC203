/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: The Order class represents an order placed in the BevShop, which includes information 
 * about the order number, time, day, customer, and a list of beverages. This class implements the 
 * OrderInterface and Comparable interfaces. It includes methods for adding beverages to the order, 
 * calculating the total cost, and comparing orders based on their order number. The Order class also 
 * provides various getter and setter methods to retrieve and modify the order details.
 * Due: 12/14/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Hawariyaw Yilma
 */

import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {

    private int orderNumber;
    private int orderTime;
    private DAY orderDay;
    private Customer cust;
    private ArrayList<Beverage> bevList = new ArrayList<Beverage>();

    /**
     * Constructor for Order
     * @param orderTime The time the order is placed
     * @param orderDay The day the order is placed
     * @param cust The customer placing the order
     */
    public Order(int orderTime, DAY orderDay, Customer cust) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.cust = cust;
        this.orderNumber = generateOrder();
    }

    /**
     * Gets the order number
     * @return order number
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Added as requested: Gets the order number (alternative method name)
     * @return order number
     */
    public int getOrderNo() {
        return orderNumber;
    }

    /**
     * Sets the order number
     * @param orderNumber the new order number
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Gets the order time
     * @return order time
     */
    public int getOrderTime() {
        return orderTime;
    }

    /**
     * Sets the order time
     * @param orderTime the new order time
     */
    public void setOrderTime(int orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * Gets the order day
     * @return the order day
     */
    public DAY getOrderDay() {
        return orderDay;
    }

    /**
     * (Optional method) Returns the order day
     * @return the order day
     */
    public DAY getDay() {
        return orderDay;
    }

    /**
     * Sets the order day
     * @param orderDay the new order day
     */
    public void setOrderDay(DAY orderDay) {
        this.orderDay = orderDay;
    }

    /**
     * Gets the customer associated with the order
     * @return the customer
     */
    public Customer getCustomer() {
        return cust;
    }

    /**
     * Sets the customer for the order
     * @param cust the customer
     */
    public void setCustomer(Customer cust) {
        this.cust = cust;
    }

    /**
     * Automatically generates a random order number
     * @return generated order number
     */
    public int generateOrder() {
        Random rand = new Random();
        return rand.nextInt(90000 - 10000 + 1) + 10000;
    }

    /**
     * Compares this order with another order based on the order number
     * @param o the other order
     * @return 1 if this order's number is greater, 0 if equal, -1 if smaller
     */
    @Override
    public int compareTo(Order o) {
        if (this.orderNumber > o.getOrderNumber())
            return 1;
        else if (this.orderNumber == o.getOrderNumber())
            return 0;
        else
            return -1;
    }

    /**
     * Checks if the order day is a weekend
     * @return true if weekend (Saturday or Sunday), false otherwise
     */
    @Override
    public boolean isWeekend() {
        return (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY);
    }

    /**
     * Returns the beverage at a specified index in the order
     * @param itemNo the index of the beverage
     * @return the beverage at itemNo
     */
    @Override
    public Beverage getBeverage(int itemNo) {
        return bevList.get(itemNo);
    }

    /**
     * Adds a coffee to the order
     * @param bevName beverage name
     * @param size beverage size
     * @param extraShot true if extra shot is added
     * @param extraSyrup true if extra syrup is added
     */
    @Override
    public void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        Coffee joe = new Coffee(bevName, size, extraShot, extraSyrup);
        bevList.add(joe);
    }

    /**
     * Adds an alcoholic beverage to the order
     * @param bevName beverage name
     * @param size beverage size
     */
    @Override
    public void addNewBeverage(String bevName, SIZE size) {
        Alcohol alcoDrink = new Alcohol(bevName, size, isWeekend());
        bevList.add(alcoDrink);
    }

    /**
     * Adds a smoothie to the order
     * @param bevName beverage name
     * @param size beverage size
     * @param numOfFruits number of fruits added
     * @param addProtein true if protein is added
     */
    @Override
    public void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        Smoothie juice = new Smoothie(bevName, size, numOfFruits, addProtein);
        bevList.add(juice);
    }

    /**
     * Calculates the total cost of the order by summing up the prices of all beverages
     * @return the total cost of the order
     */
    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (int i = 0; i < bevList.size(); i++) {
            total += bevList.get(i).calcPrice();
        }
        return total;
    }

    /**
     * Finds the number of beverages of a particular type in this order
     * @param type the beverage type
     * @return the number of beverages of that type
     */
    @Override
    public int findNumOfBeveType(TYPE type) {
        int total = 0;
        for (int i = 0; i < bevList.size(); i++) {
            if (type.equals(bevList.get(i).getType())) {
                total++;
            }
        }
        return total;
    }

    /**
     * Gets the total number of items (beverages) in the order
     * @return the number of beverages in the order
     */
    public int getTotalItems() {
        return bevList.size();
    }

    /**
     * Returns a string representation of the order, including all beverages and the total
     * @return a string containing the order details
     */
    @Override
    public String toString() {
        StringBuilder list = new StringBuilder("\n");
        for (Beverage bev : bevList) {
            list.append(bev.toString()).append("\n");
        }

        return "Order Number: " + getOrderNumber() +
               "\nOrder Time: " + getOrderTime() +
               "\nOrder Day: " + getOrderDay() +
               "\nCustomer Name: " + getCustomer().getName() +
               "\nCustomer Age: " + getCustomer().getAge() +
               list +
               "\nOrder Total: " + calcOrderTotal();
    }
}

