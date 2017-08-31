package sortingsystem;
/**
 * Bubble Sort Algorithm Implementation 
 *  
 * @author Mahesh Chouhan
 *
 */
public class BubbleSort {

	/**
	 * Performs Bubble Sort
	 * 
	 * @param array
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void performBubbleSort(Comparable[] array) {

		for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {
			for (int secondIndex = 0; secondIndex < array.length - firstIndex- 1; secondIndex++) {
				//Compare every element to its next element , if next element is small then swap 
				if (array[secondIndex].compareTo(array[secondIndex + 1]) > 0) {
					Comparable temp = array[secondIndex];
					array[secondIndex] = array[secondIndex + 1];
					array[secondIndex + 1] = temp;
				}
			}
		}
		
	}

	/**
	 * Main class which drives all the functionality
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] array = { 3, 2, -5, -4, 1, 7 };
		BubbleSort.performBubbleSort(array);

		for (Integer i : array)
			System.out.println(i);

	}

}
