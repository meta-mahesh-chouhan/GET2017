/**
 * QuickSort class performs sorting using quick sort algorithm for input array.
 * 
 * @author Mahesh Chouhan
 *
 */
public class QuickSort {

	/**
	 * Returns partition index for input array
	 * 
	 * @param input
	 * @param startIndex
	 * @param endIndex
	 * @return partition index
	 */
	public int partition(int input[], int startIndex, int endIndex) {

		int i = startIndex - 1;
		int pivot = input[endIndex];

		for (int j = startIndex; j < endIndex; j++) {

			if (input[j] <= pivot) {
				i++;

				// Swap
				int temp = input[j];
				input[j] = input[i];
				input[i] = temp;
			}
		}

		// Swap element at index i+1 and pivot index.
		int temp1 = input[i + 1];
		input[i + 1] = input[endIndex];

		input[endIndex] = temp1;

		return i + 1;

	}

	/**
	 * Performs Quick sort on input array
	 * 
	 * @param input
	 * @param startIndex
	 * @param endIndex
	 */
	public void quickSort(int input[], int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int partitionIndex = partition(input, startIndex, endIndex);

			// Sort first half of input array
			quickSort(input, startIndex, partitionIndex - 1);

			// Sort second half of input array
			quickSort(input, partitionIndex + 1, endIndex);
		}
	}

}
