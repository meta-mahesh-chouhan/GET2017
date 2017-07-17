/**
 * SecondPyramid Class generates a top-down pyramid.
 * 
 * @author Mahesh Chouhan
 * 
 */
public class SecondPyramid {

	/**
	 * Prints space corresponding to each row.
	 * 
	 * @param row
	 * @param n
	 * @return String containing spaces.
	 */
	public String spaces(int row, int n) {
		String space = "";

		for (int i = 0; i < row; i++) {
			space = space + " ";
		}

		return space;
	}

	/**
	 * Prints numbers corresponding to each row.
	 * 
	 * @param row
	 * @param n
	 * @return String containing numbers.
	 */
	public String numbers(int row, int n) {

		String number = "";

		for (int i = 0; i < n - row; i++) {
			number = number + (i + 1);
		}

		return number;
	}

	/**
	 * Prints the whole pyramid.
	 * 
	 * @param n
	 * @return String array representing the pyramid.
	 */
	public String[] printWholePyramid(int n) {

		String[] result = new String[n];

		for (int i = 0; i < n; i++) {
			result[i] = spaces(i, n) + numbers(i, n);
		}

		return result;
	}

}
