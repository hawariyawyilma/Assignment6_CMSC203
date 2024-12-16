import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {
		Coffee test1,test2,test3;
	@BeforeEach
	void setUp() throws Exception {
		test1 = new Coffee("Latte", SIZE.MEDIUM,true, true);
		test2 = new Coffee("Americano", SIZE.MEDIUM,false, true);
		test3 = new Coffee("Latte", SIZE.MEDIUM,true, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		test1 = test2 = test3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(4,test1.calcPrice());
	}

	@Test
	void testEquals() {
		assertTrue(test1.equals(test3));
		assertFalse(test2.equals(test1));
	}

	@Test
	void testToString() {
		assertEquals("Latte, MEDIUM\n"
				+ " Extra shot of Coffee and Syrup added\n"
				+ " Price: 4.0",test1.toString());
	}

}
