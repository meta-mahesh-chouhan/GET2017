import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecursionFirstTest {

	@Test
	public void remenderTestCase() {

		RecursionFirst object = new RecursionFirst();

		// First Case
		int actual = object.remainder(2, 1);
		assertEquals(0, actual);

		// Second Case
		actual = object.remainder(2, 0);
		assertEquals(-1, actual);

		// Third Case
		actual = object.remainder(100, 3);
		assertEquals(1, actual);

	}

	@Test
	public void gcdTestCase() {

		RecursionFirst object = new RecursionFirst();

		// First Case
		int actual = object.gcd(2, 1);
		assertEquals(1, actual);

		// Second Case
		actual = object.gcd(12, 18);
		assertEquals(6, actual);

		// Third Case
		actual = object.gcd(100, 3);
		assertEquals(1, actual);

	}

	@Test
	public void largestDigitTestCase() {

		RecursionFirst object = new RecursionFirst();

		// First Case
		int actual = object.largestdigit(2);
		assertEquals(2, actual);

		// Second Case
		actual = object.largestdigit(444);
		assertEquals(4, actual);

		// Third Case
		actual = object.largestdigit(1257369);
		assertEquals(9, actual);

	}

}
