import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Interface for an Order
 * 
 * @author Farnaz Eivazi
 * @version 8/22/2022
 *
 */

public class OrderTestGFA {
	Order orderOne, orderTwo, orderThree, orderFour;

	@Before
	public void setUp() throws Exception {
		orderOne = new Order(8, DAY.MONDAY, new Customer("Mary", 22));
		orderTwo = new Order(12, DAY.SATURDAY, new Customer("John", 45));
		orderThree = new Order(10, DAY.SUNDAY, new Customer("Kate", 21));
	}

	@After
	public void tearDown() throws Exception {
		orderOne = orderTwo = orderThree = null;
	}

	@Test
	public void testGetBeverage() {
		Coffee cf = new Coffee("regular Coffee", SIZE.SMALL, false, false);
		Alcohol al = new Alcohol("Mohito", SIZE.SMALL, false);
		Smoothie sm1 = new Smoothie("Detox", SIZE.MEDIUM, 1, false);
		Smoothie sm2 = new Smoothie("Detox", SIZE.LARGE, 1, false);

		orderOne.addNewBeverage("regular Coffee", SIZE.SMALL, false, false);
		orderOne.addNewBeverage("Mohito", SIZE.SMALL);
		orderOne.addNewBeverage("Detox", SIZE.MEDIUM, 1, false);
		assertTrue(orderOne.getBeverage(0).equals(cf));
		assertTrue(orderOne.getBeverage(1).equals(al));
		assertTrue(orderOne.getBeverage(2).equals(sm1));
		assertFalse(orderOne.getBeverage(2).equals(sm2));
	}

	@Test
	public void testAddNewBeverage() throws NullPointerException {

		assertTrue(orderOne.getTotalItems() == 0);
		orderOne.addNewBeverage("regular Coffee", SIZE.SMALL, false, false);
		assertTrue(orderOne.getBeverage(0).getType().equals(TYPE.COFFEE));
		orderOne.addNewBeverage("Mohito", SIZE.SMALL);
		assertTrue(orderOne.getBeverage(1).getType().equals(TYPE.ALCOHOL));
		orderOne.addNewBeverage("Detox", SIZE.MEDIUM, 1, false);
		assertTrue(orderOne.getBeverage(2).getType().equals(TYPE.SMOOTHIE));
		assertTrue(orderOne.getTotalItems() == 3);

		orderTwo.addNewBeverage("Detox", SIZE.MEDIUM, 4, true);
		assertTrue(orderTwo.getBeverage(0).getType().equals(TYPE.SMOOTHIE));
		orderTwo.addNewBeverage("Mohito", SIZE.SMALL);
		assertTrue(orderTwo.getBeverage(1).getType().equals(TYPE.ALCOHOL));
		orderTwo.addNewBeverage("regular Coffee", SIZE.MEDIUM, true, false);
		assertTrue(orderTwo.getBeverage(2).getType().equals(TYPE.COFFEE));
		assertTrue(orderTwo.getTotalItems() == 3);

	}

	@Test
	public void testCalcOrderTotal() {
		orderOne.addNewBeverage("regular Coffee", SIZE.SMALL, false, false);
		orderOne.addNewBeverage("Mohito", SIZE.SMALL);
		orderOne.addNewBeverage("Detox", SIZE.MEDIUM, 1, false);

		assertEquals(7.5, orderOne.calcOrderTotal(), .01);

		orderTwo.addNewBeverage("regular Coffee", SIZE.MEDIUM, true, false);
		orderTwo.addNewBeverage("Mohito", SIZE.SMALL);
		orderTwo.addNewBeverage("Detox", SIZE.MEDIUM, 4, true);

		assertEquals(12.6, orderTwo.calcOrderTotal(), .01);

	}

}