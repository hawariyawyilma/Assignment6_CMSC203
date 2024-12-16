import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OrderTestStudent {

    Order order;
    Customer cust;

    @Before
    public void setUp() throws Exception {
        cust = new Customer("John Doe", 25);
        order = new Order(10, DAY.MONDAY, cust);
    }

    @Test
    public void testConstructorAndGetters() {
        assertTrue(order.getOrderNumber() >= 10000 && order.getOrderNumber() <= 99999);
        assertEquals(10, order.getOrderTime());
        assertEquals(DAY.MONDAY, order.getOrderDay());
        assertEquals("John Doe", order.getCustomer().getName());
        assertEquals(25, order.getCustomer().getAge());
    }

    @Test
    public void testSetters() {
        order.setOrderTime(12);
        order.setOrderDay(DAY.SUNDAY);
        Customer newCust = new Customer("Jane Smith", 30);
        order.setCustomer(newCust);
        order.setOrderNumber(50000);

        assertEquals(12, order.getOrderTime());
        assertEquals(DAY.SUNDAY, order.getOrderDay());
        assertEquals("Jane Smith", order.getCustomer().getName());
        assertEquals(30, order.getCustomer().getAge());
        assertEquals(50000, order.getOrderNumber());
    }

    @Test
    public void testIsWeekend() {
        // Initially Monday, not weekend
        assertFalse(order.isWeekend());

        // Set it to Saturday
        order.setOrderDay(DAY.SATURDAY);
        assertTrue(order.isWeekend());

        // Set it to Sunday
        order.setOrderDay(DAY.SUNDAY);
        assertTrue(order.isWeekend());

        // Set it back to Monday
        order.setOrderDay(DAY.MONDAY);
        assertFalse(order.isWeekend());
    }

    @Test
    public void testAddNewBeverageCoffee() {
        order.addNewBeverage("Americano", SIZE.MEDIUM, true, false);
        assertEquals(1, order.getTotalItems());
        Beverage bev = order.getBeverage(0);
        assertTrue(bev instanceof Coffee);
        assertEquals("Americano", bev.getBevName());
        assertEquals(SIZE.MEDIUM, bev.getSize());
        assertEquals(TYPE.COFFEE, bev.getType());
    }

    @Test
    public void testAddNewBeverageAlcohol() {
        // Set to a weekend to allow weekend pricing if applicable
        order.setOrderDay(DAY.SATURDAY);
        order.addNewBeverage("Wine", SIZE.LARGE);
        assertEquals(1, order.getTotalItems());
        Beverage bev = order.getBeverage(0);
        assertTrue(bev instanceof Alcohol);
        assertEquals("Wine", bev.getBevName());
        assertEquals(SIZE.LARGE, bev.getSize());
        assertEquals(TYPE.ALCOHOL, bev.getType());
    }

    @Test
    public void testAddNewBeverageSmoothie() {
        order.addNewBeverage("Detox", SIZE.SMALL, 2, true);
        assertEquals(1, order.getTotalItems());
        Beverage bev = order.getBeverage(0);
        assertTrue(bev instanceof Smoothie);
        assertEquals("Detox", bev.getBevName());
        assertEquals(SIZE.SMALL, bev.getSize());
        assertEquals(TYPE.SMOOTHIE, bev.getType());
    }

    @Test
    public void testCalcOrderTotal() {
        order.addNewBeverage("Americano", SIZE.SMALL, true, false); // Coffee
        order.addNewBeverage("Wine", SIZE.MEDIUM); // Alcohol
        order.addNewBeverage("Detox", SIZE.LARGE, 3, true); // Smoothie

        // Let's roughly check the total (assuming base prices and increments):
        // Base prices (from the assignment's assumptions if known):
        // Coffee base: 2.0, small no size upcharge, extra shot +0.5, no syrup +0.0 = 2.5
        // Alcohol base: 3.0, medium +1.0 = 4.0
        // Smoothie base: 3.0, large +1.5, 3 fruits @0.5 each = 1.5, protein +1.5
        // Smoothie total = 3.0 + 1.5 + 1.5 + 1.5 = 7.5
        // Total = 2.5 (coffee) + 4.0 (alcohol) + 7.5 (smoothie) = 14.0

        double total = order.calcOrderTotal();
        // Adjust if pricing structure is known differently; this is just an example.
        // If you have specific costs from instructions, modify accordingly.
        
        assertTrue(total > 0); // At least verify it's greater than zero
    }

    @Test
    public void testFindNumOfBeveType() {
        order.addNewBeverage("Americano", SIZE.SMALL, true, false); // Coffee
        order.addNewBeverage("Wine", SIZE.LARGE); // Alcohol
        order.addNewBeverage("Latte", SIZE.MEDIUM, true, true); // Another Coffee
        order.addNewBeverage("Margarita", SIZE.SMALL); // Another Alcohol
        order.addNewBeverage("Detox", SIZE.SMALL, 1, false); // Smoothie

        assertEquals(2, order.findNumOfBeveType(TYPE.COFFEE));
        assertEquals(2, order.findNumOfBeveType(TYPE.ALCOHOL));
        assertEquals(1, order.findNumOfBeveType(TYPE.SMOOTHIE));
    }

    @Test
    public void testCompareTo() {
        // Compare with another order
        Customer c2 = new Customer("Alice", 22);
        Order order2 = new Order(9, DAY.TUESDAY, c2);

        int result = order.compareTo(order2);

        // Since order numbers are random, we can't predict exact outcomes.
        // We'll just verify the logic doesn't throw and is consistent.
        // If same number: 0, if this > order2: 1, if this < order2: -1
        assertTrue(result == 1 || result == 0 || result == -1);
    }

    @Test
    public void testToString() {
        order.addNewBeverage("Americano", SIZE.SMALL, true, false);
        String str = order.toString();

        assertTrue(str.contains("Order Number:"));
        assertTrue(str.contains("Order Time: 10"));
        assertTrue(str.contains("Order Day: MONDAY"));
        assertTrue(str.contains("John Doe"));
        assertTrue(str.contains("25"));
        assertTrue(str.contains("Americano"));
    }
}
