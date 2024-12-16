import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrderTest {

    Order r1, r2, r3;

    @Before
    public void setUp() throws Exception {
        r1 = new Order(8, DAY.MONDAY, new Customer("Mary", 22));
        r2 = new Order(12, DAY.SATURDAY, new Customer("John", 45));
        r3 = new Order(10, DAY.SUNDAY, new Customer("Kate", 21));
    }

    @After
    public void tearDown() throws Exception {
        r1 = r2 = r3 = null;
    }

    @Test
    public void testGetBeverage() {
        Coffee cf = new Coffee("regular Coffee", SIZE.SMALL, false, false);
        Alcohol al = new Alcohol("Mohito", SIZE.SMALL, false);
        Smoothie sm1 = new Smoothie("Detox", SIZE.MEDIUM, 1, false);
        Smoothie sm2 = new Smoothie("Detox", SIZE.LARGE, 1, false);

        r1.addNewBeverage("regular Coffee", SIZE.SMALL, false, false);
        r1.addNewBeverage("Mohito", SIZE.SMALL);
        r1.addNewBeverage("Detox", SIZE.MEDIUM, 1, false);

        assertEquals(cf, r1.getBeverage(0));
        assertEquals(al, r1.getBeverage(1));
        assertEquals(sm1, r1.getBeverage(2));
        assertNotEquals(sm2, r1.getBeverage(2));
    }

    @Test
    public void testAddNewBeverage() {
        assertEquals(0, r1.getTotalItems());
        r1.addNewBeverage("regular Coffee", SIZE.SMALL, false, false);
        assertEquals(TYPE.COFFEE, r1.getBeverage(0).getType());
        r1.addNewBeverage("Mohito", SIZE.SMALL);
        assertEquals(TYPE.ALCOHOL, r1.getBeverage(1).getType());
        r1.addNewBeverage("Detox", SIZE.MEDIUM, 1, false);
        assertEquals(TYPE.SMOOTHIE, r1.getBeverage(2).getType());
        assertEquals(3, r1.getTotalItems());
    }

    @Test
    public void testisWeekend() {
        assertFalse(r1.isWeekend());
        assertTrue(r2.isWeekend());
        assertTrue(r3.isWeekend());
    }

    @Test
    public void testCalcOrderTotal() {
        r1.addNewBeverage("regular Coffee", SIZE.SMALL, false, false);
        r1.addNewBeverage("Mohito", SIZE.SMALL);
        r1.addNewBeverage("Detox", SIZE.MEDIUM, 1, false);

        assertEquals(7.5, r1.calcOrderTotal(), 0.01);
    }

    @Test
    public void testFindNumOfBeveType() {
        r1.addNewBeverage("regular Coffee", SIZE.SMALL, false, false);
        r1.addNewBeverage("Mohito", SIZE.SMALL);
        r1.addNewBeverage("Detox", SIZE.MEDIUM, 1, false);
        assertEquals(1, r1.findNumOfBeveType(TYPE.COFFEE));
        assertEquals(1, r1.findNumOfBeveType(TYPE.SMOOTHIE));
        assertEquals(1, r1.findNumOfBeveType(TYPE.ALCOHOL));
    }
}
