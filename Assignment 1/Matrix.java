/**
 * Matrix Class create a 2-D integer array.It contains methods for adding
 * elements, showing matrix , tranposing matrix and multiplying matrix.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Matrix {

	private int data[][];
	private int noRow;
	private int noColumn;

	/**
	 * Getter method to get private variable data.
	 * 
	 * @return 2-D integer array
	 */
	public int[][] getData() {
		return data;
	}

	/**
	 * Initializes Matrix object with given number of row and column.
	 * 
	 * @param row
	 * @param column
	 */
	public Matrix(int row, int column) {
		this.noRow = row;
		this.noColumn = column;
		data = new int[row][column];
	}

	/**
	 * Assign given value to position data[row][column].
	 * 
	 * @param row
	 * @param column
	 * @param value
	 */
	public void addElements(int row, int column, int value) {
		this.data[row][column] = value;
	}

	/**
	 * String to display matrix.
	 * 
	 * @return String to display elements of 2-D array.
	 */
	public String show() {

		String showString = "";

		for (int rowIndex = 0; rowIndex < noRow; rowIndex++) {
			for (int columnIndex = 0; columnIndex < noColumn; columnIndex++) {
				showString = showString + data[rowIndex][columnIndex] + " ";
			}

			showString = showString + "\n";
		}
		return showString;
	}

	/**
	 * Perform transpose of matrix i.e. row of input matrix forms the column for
	 * output matrix.
	 * 
	 * @return
	 */
	public Matrix transpose() {

		Matrix transposedMatrix = new Matrix(this.noColumn, this.noRow);

		for (int rowIndex = 0; rowIndex < transposedMatrix.noRow; rowIndex++) {
			for (int columnIndex = 0;  columnIndex< transposedMatrix.noColumn; columnIndex++) {
				// Column of input matrix forms the row for transposed matrix.
				transposedMatrix.data[rowIndex][columnIndex] = this.data[columnIndex][rowIndex];
			}
		}

		return transposedMatrix;
	}

	/**
	 * Performs multiplication of matrix with the one given as argument.
	 * 
	 * @param secondMatrix
	 * @return Result of multiplication of matrix.
	 */
	public Matrix multiplication(Matrix secondMatrix) {

		if (this.noColumn != secondMatrix.noRow)
			return null;

		Matrix result = new Matrix(noRow, secondMatrix.noColumn);
		int sum;

		for (int rowIndex = 0; rowIndex < noRow; rowIndex++) {

			for (int columnIndex = 0; columnIndex < secondMatrix.noColumn; columnIndex++) {
				sum = 0;
				for (int k = 0; k < noColumn; k++) {

					/* Elements of rows of first matrix are multipled by
					 elements of columns of second matrix.*/
					sum = sum + this.data[rowIndex][k] * secondMatrix.data[k][columnIndex];

				}

				result.data[rowIndex][columnIndex] = sum;
			}
		}

		return result;
	}

}
