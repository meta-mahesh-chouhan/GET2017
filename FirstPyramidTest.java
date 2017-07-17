import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FirstPyramidTest {

	/*
	 * Spaces test case - positive
	 */
	@Test
	public void spaceTestPass() {

		int currentRow = 4;
		int totalNumberOfRows = 5;
		FirstPyramid object = new FirstPyramid();

		String expected = " ";
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
		FirstPyramid object = new FirstPyramid();

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
		FirstPyramid object = new FirstPyramid();

		String expected = "    ";
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
		FirstPyramid object = new FirstPyramid();

		String expected = "12321";
		String actual = object.numbers(currentRow - 1, totalNumberOfRows);
		assertEquals(expected, actual);
	}

	/*
	 * Numbers Test Case - negative
	 */
	@Test
	public void numbersTestFail() {

		int currentRow = 3;
		int totalNumberOfRows = 5;
		FirstPyramid object = new FirstPyramid();

		String expected = "1234321";
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
		FirstPyramid object = new FirstPyramid();

		String expected = "1";
		String actual = object.numbers(currentRow - 1, totalNumberOfRows);
		assertEquals(expected, actual);
	}

	/*
	 * printWholePyramid Positive Test Case
	 */
	@Test
	public void printWholeTestCasePass() {
		String[] expected = { "    1    ", "   121   ", "  12321  ",
				" 1234321 ", "123454321", " 1234321 ", "  12321  ",
				"   121   ", "    1    " };

		FirstPyramid object = new FirstPyramid();
		String[] output = object.prinWholePyramid(5);
		assertArrayEquals(expected, output);

	}

	/*
	 * printWholePyramid Negative Test Case
	 */
	@Test
	public void printWholeTestCaseFail() {
		String[] expected = { "    1    ", "   121   ", "  12321  ",
				" 1234321 ", "123454321", " 1234321 ", "  12321  ",
				"   121   ", "    1    " };

		FirstPyramid object = new FirstPyramid();
		String[] output = object.prinWholePyramid(4);
		assertArrayEquals("Ouput is different than expected", expected, output);

	}

	/*
	 * printWholePyramid Boundary Test Case - When user inputs zero.
	 */

	@Test(expected = NegativeArraySizeException.class)
	public void printWholeTestCaseBoundary() {
		String[] expected = {};

		FirstPyramid object = new FirstPyramid();
		String[] output = object.prinWholePyramid(0);
		assertArrayEquals(expected, output);

	}

}
