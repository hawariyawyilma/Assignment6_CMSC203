import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlcoholTestStudent {

    // Declare Alcohol objects for testing purposes
    Alcohol test1, test2, test3;

    /**
     * Sets up the test environment by initializing Alcohol objects.
     * This method runs before each test to ensure a fresh state.
     * 
     * @throws Exception if there is an issue during setup
     */
    @BeforeEach
    void setUp() throws Exception {
        test1 = new Alcohol("Beer", SIZE.MEDIUM, true); // Alcohol ordered on the weekend
        test2 = new Alcohol("Wine", SIZE.MEDIUM, false); // Alcohol not ordered on the weekend
        test3 = new Alcohol("Beer", SIZE.MEDIUM, true); // Identical to test1 for equality testing
    }

    /**
     * Cleans up the test environment by setting test objects to null.
     * This method runs after each test to prevent interference between tests.
     * 
     * @throws Exception if there is an issue during cleanup
     */
    @AfterEach
    void tearDown() throws Exception {
        test1 = test2 = test3 = null; // Reset objects to null
    }

    /**
     * Tests the `calcPrice` method of the Alcohol class.
     * Verifies that the calculated price for `test1` is correct.
     */
    @Test
    void testCalcPrice() {
        assertEquals(3.6, test1.calcPrice(), "The calculated price for test1 is incorrect.");
    }

    /**
     * Tests the `equals` method of the Alcohol class.
     * Verifies that `test1` is equal to `test3` and not equal to `test2`.
     */
    @Test
    void testEquals() {
        assertTrue(test1.equals(test3), "test1 should be equal to test3.");
        assertFalse(test2.equals(test1), "test2 should not be equal to test1.");
    }

    /**
     * Tests the `toString` method of the Alcohol class.
     * Verifies that the string representation of `test1` matches the expected output.
     */
    @Test
    void testToString() {
        assertEquals("Beer, MEDIUM\n"
                + " Drink is offered on weekends for 0.60$ extra\n"
                + " Price: 3.6", test1.toString(), "The toString output for test1 is incorrect.");
    }

    /**
     * Tests the `isWeekend` method of the Alcohol class.
     * Verifies that `test1` is marked as a weekend order and `test2` is not.
     */
    @Test
    void testIsWeekend() {
        assertTrue(test1.isWeekend(), "test1 should indicate it is a weekend order.");
        assertFalse(test2.isWeekend(), "test2 should indicate it is not a weekend order.");
    }
}
