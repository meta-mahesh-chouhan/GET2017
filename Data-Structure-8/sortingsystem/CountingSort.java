package sortingsystem;

/**
 * Counting sort implementation
 * 
 * @author Mahesh Chouhan
 *
 */
public class CountingSort {

	/**
	 * Returns minimum value in array
	 * 
	 * @param array
	 * @return
	 */
	public static int getMinimum(Integer[] array) {
		int minimum = array[0];
		for (int index = 0; index < array.length; index++) {
			if (array[index] < minimum)
				minimum = array[index];
		}
		return minimum;
	}

	/**
	 * Performs Counting Sort
	 * 
	 * @param array
	 * @param size
	 */
	public static void performCountingSort(Integer[] array, int size) {

		Integer[] output = new Integer[array.length];
		int minimum = CountingSort.getMinimum(array);

		int count[];
		if (minimum < 0) {
			// If minimum value is negative , increase size of count array
			count = new int[size + minimum * (-1)];

			// Add absolute value of minimum to array elements to make every
			// element
			// positive
			for (int index = 0; index < array.length; index++) {
				array[index] += minimum * (-1);
			}
		} else {
			count = new int[size];
		}
		// Count number of occurrence of each element in array
		for (int index = 0; index < array.length; index++) {
			count[array[index]]++;
		}
		// Perform Cumulation on count array
		for (int index = 1; index < count.length; index++) {
			count[index] += count[index - 1];
		}
		// Store correct position in output array
		for (int index = 0; index < array.length; index++) {
			output[count[array[index]] - 1] = array[index];
			count[array[index]]--;
		}
		/*
		 * If minimum value was negative, subtract absolute value of minimum to
		 * get original values
		 */
		if (minimum < 0) {
			for (int index = 0; index < array.length; index++) {
				array[index] = output[index] + minimum;
			}
		} else {
			for (int index = 0; index < array.length; index++) {
				array[index] = output[index];
			}
		}
	}

	/**
	 * Main function which drives all the functionality
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Integer array[] = { 3, 5, 2, 65, 23, 2, 5, -11, 56, 2, 5, 2, 5, 4,6, 8 };
		CountingSort.performCountingSort(array, 66);

		for (Integer integer : array) {
			System.out.println(integer);
		}
	}

}
