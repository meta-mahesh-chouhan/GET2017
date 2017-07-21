import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MatrixTest {

	@Test
	public void addElementsTestCase() {
		Matrix myMatrix = new Matrix(3, 3);

		myMatrix.addElements(0, 0, 1);
		myMatrix.addElements(0, 2, 1);
		myMatrix.addElements(1, 1, 1);
		myMatrix.addElements(2, 1, 1);
		myMatrix.addElements(2, 2, 1);

		int expected[][] = { { 1, 0, 1 }, { 0, 1, 0 }, { 0, 1, 1 } };
		assertArrayEquals(expected, myMatrix.getData());

	}

	@Test
	public void transposeTestCase() {

		Matrix myMatrix = new Matrix(4, 3);

		myMatrix.addElements(0, 0, 1);
		myMatrix.addElements(0, 2, 1);
		myMatrix.addElements(1, 1, 1);
		myMatrix.addElements(1, 2, 1);
		myMatrix.addElements(2, 1, 1);
		myMatrix.addElements(2, 2, 1);
		myMatrix.addElements(3, 0, 1);
		myMatrix.addElements(3, 1, 1);
		myMatrix.addElements(3, 2, 1);

		int expected[][] = { { 1, 0, 0, 1 }, { 0, 1, 1, 1 }, { 1, 1, 1, 1 } };
		Matrix transposedMatrix = myMatrix.transpose();
		assertArrayEquals(expected, transposedMatrix.getData());
	}

	@Test
	public void showTestCase() {
		Matrix myMatrix = new Matrix(3, 3);

		myMatrix.addElements(0, 0, 1);
		myMatrix.addElements(0, 2, 2);
		myMatrix.addElements(1, 1, 3);
		myMatrix.addElements(2, 0, 4);
		myMatrix.addElements(2, 2, 5);

		String expected = "1 0 2 \n0 3 0 \n4 0 5 \n";

		assertEquals(expected, myMatrix.show());

	}

	@Test
	public void multiplicationTestCase() {

		Matrix firstMatrix = new Matrix(2, 3);

		firstMatrix.addElements(0, 0, 1);
		firstMatrix.addElements(0, 1, 2);
		firstMatrix.addElements(0, 2, 3);
		firstMatrix.addElements(1, 0, 4);

		firstMatrix.addElements(1, 1, 5);
		firstMatrix.addElements(1, 2, 6);
		
		Matrix 	secondMatrix = new Matrix(3, 2);

		secondMatrix.addElements(0, 0, 1);
		secondMatrix.addElements(0, 1, 2);
		secondMatrix.addElements(1, 0, 3);
		secondMatrix.addElements(1, 1, 4);

		secondMatrix.addElements(2, 0, 5);
		secondMatrix.addElements(2, 1, 6);

		Matrix actual = firstMatrix.multiplication(secondMatrix);

		int expected[][] = { { 22, 28 }, { 49, 64 } };

		assertArrayEquals(expected, actual.getData());
	}

	/*
	 * Negative Test case :During matrix multiplication if no. of column of
	 * first matrix is not equal to no. of row of second matrix.
	 */
	@Test
	public void negativeTestCase() {

		Matrix firstMatrix = new Matrix(2, 2);

		firstMatrix.addElements(0, 0, 1);
		firstMatrix.addElements(0, 1, 2);
		firstMatrix.addElements(1, 0, 3);
		firstMatrix.addElements(1, 1, 4);

		Matrix secondMatrix = new Matrix(3, 3);

		secondMatrix.addElements(0, 0, 1);
		secondMatrix.addElements(0, 2, 1);
		secondMatrix.addElements(1, 1, 1);
		secondMatrix.addElements(2, 1, 1);
		secondMatrix.addElements(2, 2, 1);

		Matrix actual = firstMatrix.multiplication(secondMatrix);

		//FirstMatrix.noColumn is not equal to SecondMatrix.noRow 
		assertNull(actual);

	}
}
