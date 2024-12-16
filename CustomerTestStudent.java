import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestStudent {
	Customer test;

	@BeforeEach
	void setUp() throws Exception {
		test = new Customer("Dave", 21);
	}

	@AfterEach
	void tearDown() throws Exception {
		test = null;
	}

	@Test
	void testToString() {
		assertEquals("Customer name= Dave\n"
						+ " age= 21", test.toString());
	}

}