/**
 * FirstPyramid Class generates a diamond composed of one normal pyramid and one
 * inverted pyramid.
 * 
 * @author Mahesh Chouhan
 * 
 */
public class FirstPyramid {

	/**
	 * Prints the spaces corresponding to each row.
	 * 
	 * @param row
	 * @param n
	 * @return String containing spaces.
	 */
	public String spaces(int row, int n) {

		String space = "";

		if (row < n) {
			// Spaces for top-down pyramid
			for (int i = 0; i < n - row - 1; i++) {
				space = space + " ";
			}
		} else if (row > n) {
			// Spaces for bottom-up pyramid
			for (int i = row; i > n; i--) {
				space = space + " ";
			}
		}

		return space;
	}

	/**
	 * Prints the numbers corresponding to each row.
	 * 
	 * @param row
	 * @param n
	 * @return String containing numbers.
	 */
	public String numbers(int row, int n) {

		String number = "";
		int increasingNumber = 0;
		int decreasingNumber;
		if (row < n) {
			// Numbers for top-down pyramid
			for (increasingNumber = 0; increasingNumber <= row; increasingNumber++) {
				// Numbers for increasing sequence
				number = number + (increasingNumber + 1);
			}

			for (decreasingNumber = increasingNumber - 1; decreasingNumber > 0; decreasingNumber--) {
				// Numbers for decreasing sequence
				number = number + decreasingNumber;
			}
		} else {
			// Numbers for bottom-up pyramid
			for (increasingNumber = 0; increasingNumber <= 2 * n - row; increasingNumber++) {
				// Numbers for increasing sequence
				number = number + (increasingNumber + 1);
			}

			for (decreasingNumber = increasingNumber - 1; decreasingNumber > 0; decreasingNumber--) {
				// Numbers for decreasing sequence
				number = number + decreasingNumber;
			}

		}
		return number;

	}

	/**
	 * Prints the whole pyramid composed of top-down and bottom-up pyramid.
	 * 
	 * @param n
	 * @return String array representing both pyramids.
	 */
	public String[] prinWholePyramid(int n) {

		String[] result = new String[2 * n - 1];
		String leftSideSpaces;
		String rightSideSpaces;

		// Prints Top-down Pyramid
		for (int i = 0; i < n; i++) {

			leftSideSpaces = rightSideSpaces = spaces(i, n);
			result[i] = leftSideSpaces + numbers(i, n) + rightSideSpaces;

		}

		// Prints Bottom-Up Pyramid
		for (int i = n; i < 2 * n - 1; i++) {

			leftSideSpaces = rightSideSpaces = spaces(i + 1, n);
			result[i] = leftSideSpaces + numbers(i + 2, n) + rightSideSpaces;
		}

		return result;

	}

}
