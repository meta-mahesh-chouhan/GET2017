import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecursionSecondTest {

	@Test
	public void linearSearchTest() {

		RecursionSecond object = new RecursionSecond();
		int input[] = { 2, 5, 8, 9, 10, 77, 55 };

		int output = object.linearSearch(input, 88, input.length - 1);
		assertEquals(-1, output);

		input = new int[] { 2, 5, 8, 9, 10, 55, 77 };
		output = object.linearSearch(input, 77, input.length - 1) + 1;
		assertEquals(7, output);

	}

	public void binarySearchTest() {

		RecursionSecond object = new RecursionSecond();
		int input[] = { 2, 5, 8, 9, 10, 77, 55 };

		int output = object.binarySearch(input, 88, 0, input.length - 1);
		assertEquals(-1, output);

		input = new int[] { 2, 5, 8, 9, 10, 55, 77 };
		output = object.binarySearch(input, 77, 0, input.length - 1) + 1;
		assertEquals(7, output);

	}

}
