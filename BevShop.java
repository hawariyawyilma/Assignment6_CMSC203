

import java.util.ArrayList;

public class BevShop implements BevShopInterfce {
    private static final int MIN_AGE_FOR_ALCOHOL = 21;
    private static final int MAX_ORDER_FOR_ALCOHOL = 3;
    private static final int MIN_TIME = 8;
    private static final int MAX_TIME = 23;
    private static final int MAX_FRUIT = 5;

    private ArrayList<Order> log = new ArrayList<>();

    // The test expects these methods:
    public boolean ValidTime(int time) {
        return isValidTime(time);
    }

    public boolean validTime(int time) {
        return isValidTime(time);
    }

    public boolean validAge(int age) {
        return isValidAge(age);
    }

    public boolean eligibleForMore() {
        return isEligibleForMore();
    }

    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    public boolean isValidAge(int age) {
        // Changed condition to >= so that age 21 and older are considered valid
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    public boolean isEligibleForMore() {
        return getNumOfAlcoholDrink() < MAX_ORDER_FOR_ALCOHOL;
    }

    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    public int getNumOfAlcoholDrink() {
        if (log.isEmpty()) return 0;
        return log.get(log.size() - 1).findNumOfBeveType(TYPE.ALCOHOL);
    }

    @Override
    public void startNewOrder(int time, DAY day, String customerName, int customerAge) {
        if (!isValidTime(time)) {
            throw new IllegalArgumentException("Invalid order time. Must be between " + MIN_TIME + " and " + MAX_TIME);
        }
        log.add(new Order(time, day, new Customer(customerName, customerAge)));
    }

    @Override
    public void processCoffeeOrder(String bevName, SIZE size, boolean extraShot, boolean extraSyrup) {
        getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processAlcoholOrder(String bevName, SIZE size) {
        if (!validAge(getCurrentOrder().getCustomer().getAge())) {
            throw new IllegalArgumentException("Customer is not old enough to order alcohol.");
        }
        if (!eligibleForMore()) {
            throw new IllegalArgumentException("Maximum alcohol orders reached for this order.");
        }
        getCurrentOrder().addNewBeverage(bevName, size);
    }

    @Override
    public void processSmoothieOrder(String bevName, SIZE size, int numOfFruits, boolean addProtein) {
        if (isMaxFruit(numOfFruits)) {
            throw new IllegalArgumentException("Number of fruits exceeds the maximum limit.");
        }
        getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < log.size(); i++) {
            if (log.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index == -1) {
            throw new IllegalArgumentException("Order number not found.");
        }
        return log.get(index).calcOrderTotal();
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : log) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    public int totalNumOfMonthlyOrders() {
        return log.size();
    }

    public Order getCurrentOrder() {
        if (log.isEmpty()) {
            throw new IllegalStateException("No current orders available.");
        }
        return log.get(log.size() - 1);
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index < 0 || index >= log.size()) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        return log.get(index);
    }

    @Override
    public void sortOrders() {
        for (int i = 0; i < log.size() - 1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < log.size(); j++) {
                if (log.get(j).getOrderNo() < log.get(indexMin).getOrderNo()) {
                    indexMin = j;
                }
            }
            Order temp = log.get(i);
            log.set(i, log.get(indexMin));
            log.set(indexMin, temp);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : log) {
            sb.append(order.toString()).append("\n");
        }
        sb.append("Total Monthly Sale: ").append(totalMonthlySale());
        return sb.toString();
    }
}
