

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class SmoothieTestStudent {
	Smoothie test1 , test2 , test3;

	@BeforeEach
	void setUp() throws Exception {
		test1 = new Smoothie("House Special", SIZE.MEDIUM,4, true);
		test2 = new Smoothie("Detox", SIZE.MEDIUM,3, false);
		test3 = new Smoothie("House Special", SIZE.MEDIUM,4, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = test2 = test3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(6.5,test1.calcPrice());
	}

	@Test
	void testEquals() {
		assertTrue(test1.equals(test3));
		assertFalse(test2.equals(test1));
	}

	@Test
	void testToString() {
		assertEquals("House Special, MEDIUM\n"
				+ " Protein added to smoothie \n"
				+ " Number of Fruit: 4\n"
				+ " Price: 6.5",test1.toString());
	}

}