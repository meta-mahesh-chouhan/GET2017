/**
 * RecursionSecond contains methods for linear searching and binary searching.
 * 
 * @author Mahesh Chouhan
 *
 */
public class RecursionSecond {

	/**
	 * Search for element in the input array using linear search.
	 * 
	 * @param input
	 *            - array
	 * @param element
	 *            - item to be searched
	 * @param index
	 * @return true when element is found and false when it is not.
	 */
	public int linearSearch(int input[], int element, int index) {

		// Base Condition
		if (index == -1)
			return -1;

		if (input[index] == element)
			return index;

		// Recursive call
		return linearSearch(input, element, --index);

	}

	/**
	 * Search for element in the input array using binary search.
	 * 
	 * @param input
	 *            - array
	 * @param element
	 * @param start
	 * @param end
	 * @return true when element is found and false when it is not.
	 */
	public int binarySearch(int input[], int element, int startIndex,
			int endIndex) {
		int middleIndex = (startIndex + endIndex) / 2;

		// Base Condition
		if (startIndex > endIndex)
			return -1;

		// Recursive call
		if (input[middleIndex] == element) {
			return middleIndex;
		} else if (input[middleIndex] < element) {
			// Search in first half of array
			return binarySearch(input, element, middleIndex + 1, endIndex);
		} else
			// Search in second half of array
			return binarySearch(input, element, startIndex, middleIndex - 1);

	}

}
