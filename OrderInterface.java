public interface OrderInterface {

    /**
     * Checks if the day is a weekend.
     * 
     * @return true if the day is a weekend day (Saturday or Sunday), false otherwise.
     */
    boolean isWeekend();

    /**
     * Retrieves the beverage listed at the given index in the order.
     * 
     * @param itemNo the index of the beverage.
     * @return the beverage at the specified index, or null if the index is invalid.
     */
    Beverage getBeverage(int itemNo);

    /**
     * Adds a coffee beverage to the order.
     * 
     * @param bevName    the name of the coffee beverage.
     * @param size       the size of the beverage.
     * @param extraShot  true if the coffee has an extra shot, false otherwise.
     * @param extraSyrup true if the coffee has extra syrup, false otherwise.
     */
    void addNewBeverage(String bevName, SIZE size, boolean extraShot, boolean extraSyrup);

    /**
     * Adds an alcoholic beverage to the order.
     * 
     * @param bevName the name of the alcoholic beverage.
     * @param size    the size of the beverage.
     */
    void addNewBeverage(String bevName, SIZE size);

    /**
     * Adds a smoothie beverage to the order.
     * 
     * @param bevName     the name of the smoothie beverage.
     * @param size        the size of the beverage.
     * @param numOfFruits the number of fruits added to the smoothie.
     * @param addProtein  true if protein is added, false otherwise.
     */
    void addNewBeverage(String bevName, SIZE size, int numOfFruits, boolean addProtein);

    /**
     * Calculates the total cost of the order.
     * 
     * @return the total cost of the order.
     */
    double calcOrderTotal();

    /**
     * Finds the number of beverages of a specific type in the order.
     * 
     * @param type the type of the beverage.
     * @return the number of beverages of the specified type in the order.
     */
    int findNumOfBeveType(TYPE type);

    /**
     * Returns the total number of beverages in the order.
     * 
     * @return the total number of beverages in the order.
     */
    int getTotalItems();
}
