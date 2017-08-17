package DefaultNamespace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 * Tests the Converter class
 * 
 * @author Mahesh Chouhan
 *
 */
public class ConverterTest {

	/**
	 * Positive Test Case
	 */
	@Test
	public void positiveTestCase() {

		Converter obj = new Converter();
		Double expected = 87.77;
		Double actual = obj.convert(190);
		assertEquals(expected, actual);

	}

	/**
	 * Negative Test Case
	 */
	@Test
	public void negativeTestCase() {

		Converter obj = new Converter();
		Double expected = 87.77;
		Double actual = obj.convert(-34);
		assertNotEquals(expected, actual);

	}

}
