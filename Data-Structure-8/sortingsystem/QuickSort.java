package sortingsystem;

/**
 * Quick Sort Implementation
 * 
 * @author Mahesh Chouhan
 *
 */
public class QuickSort {

	/**
	 * Performs Quick Sort
	 * 
	 * @param array
	 */
	@SuppressWarnings("rawtypes")
	public static void performQuickSort(Comparable[] array) {
		performQuickSort(array, 0, array.length - 1);
	}

	/**
	 * Performs partitioning of array
	 * 
	 * @param array
	 * @param start
	 * @param end
	 * @return Partition index
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int partition(Comparable[] array, int start, int end) {

		// Make element at last index as pivot
		Comparable pivot = array[end];

		int partitionIndex = start;
		for (int index = start; index < end; index++) {

			/*
			 * If element at current index is less than pivot ,then swap element
			 * at current index and partition index
			 */
			if (array[index].compareTo(pivot) <= 0) {
				Comparable temp = array[index];
				array[index] = array[partitionIndex];
				array[partitionIndex] = temp;

				partitionIndex++;
			}
		}

		// Swap pivot and element at partition index
		Comparable temp = array[end];
		array[end] = array[partitionIndex];
		array[partitionIndex] = temp;

		return partitionIndex;

	}

	/**
	 * Utility function to perform Quick Sort
	 * 
	 * @param array
	 * @param start
	 * @param end
	 */
	@SuppressWarnings("rawtypes")
	private static void performQuickSort(Comparable[] array, int start, int end) {

		if (start >= end)
			return;

		int partitionIndex = partition(array, start, end);
		// Perform Quick sort in left sub array
		performQuickSort(array, start, partitionIndex - 1);
		// Perform Quick sort in right sub array
		performQuickSort(array, partitionIndex + 1, end);

	}

	/**
	 * Main function which drives all the functionality
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] array = { 3, 4, 1, 6, 2, 89, 5, 7 };

		QuickSort.performQuickSort(array);

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
}
