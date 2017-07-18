import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SecondPyramidTest {

	/*
	 * Spaces test case - positive
	 */
	@Test
	public void spaceTestPass() {

		int currentRow = 4;
		int totalNumberOfRows = 5;
		SecondPyramid object = new SecondPyramid();

		String expected = "   ";
		String actual = object.spaces(currentRow - 1, totalNumberOfRows);
		assertEquals(expected, actual);
	}

	/*
	 * Spaces test case - negative
	 */
	@Test
	public void spaceTestFail() {

		int currentRow = 3;
		int totalNumberOfRows = 5;
		SecondPyramid object = new SecondPyramid();

		String expected = " ";
		String actual = object.spaces(currentRow - 1, totalNumberOfRows);
		assertEquals(expected, actual);
	}

	/*
	 * Spaces test case - Boundary
	 */
	@Test
	public void spaceTestBoundary() {

		int currentRow = 1;
		int totalNumberOfRows = 5;
		SecondPyramid object = new SecondPyramid();

		String expected = "";
		String actual = object.spaces(currentRow - 1, totalNumberOfRows);
		assertEquals(expected, actual);
	}

	/*
	 * Numbers Test Case - positive
	 */
	@Test
	public void numbersTestPass() {

		int currentRow = 3;
		int totalNumberOfRows = 5;
		SecondPyramid object = new SecondPyramid();

		String expected = "123";
		String actual = object.numbers(currentRow - 1, totalNumberOfRows);
		System.out.print(actual);
		assertEquals(expected, actual);
	}

	/*
	 * Numbers Test Case - negative
	 */
	@Test
	public void numbersTestFail() {

		int currentRow = 3;
		int totalNumberOfRows = 5;
		SecondPyramid object = new SecondPyramid();

		String expected = "123456";
		String actual = object.numbers(currentRow - 1, totalNumberOfRows);
		assertEquals(expected, actual);
	}

	/*
	 * Numbers Test Case - Boundary
	 */
	@Test
	public void numbersTestBoundary() {

		int currentRow = 1;
		int totalNumberOfRows = 5;
		SecondPyramid object = new SecondPyramid();

		String expected = "12345";
		String actual = object.numbers(currentRow - 1, totalNumberOfRows);
		assertEquals(expected, actual);
	}

	/*
	 * Positive Test Case
	 */
	@Test
	public void printWholeTestCasePass() {
		SecondPyramid object = new SecondPyramid();
		String[] expected = { "12345", " 1234", "  123", "   12", "    1" };
		String[] output = object.printWholePyramid(5);
		assertArrayEquals(expected, output);
	}

	/*
	 * Negative Test Case
	 */
	@Test
	public void printWholeTestCaseFail() {
		SecondPyramid object = new SecondPyramid();
		String[] expected = { "12345", " 1234", "  123", "   12", "    1" };
		String[] output = object.printWholePyramid(4);
		assertArrayEquals(expected, output);
	}

	/*
	 * Boundary Test Case: When user inputs zero
	 */
	@Test
	public void printWholeTestCaseBoundary() {
		SecondPyramid object = new SecondPyramid();
		String[] expected = {};
		String[] output = object.printWholePyramid(0);
		assertArrayEquals(expected, output);
	}

	/*
	 * User inputs negative value of n.
	 */
	@Test(expected = NegativeArraySizeException.class)
	public void printWholeTestCaseException() {
		SecondPyramid object = new SecondPyramid();
		String[] expected = {};
		String[] output = object.printWholePyramid(-1);
		assertArrayEquals(expected, output);
	}
}
