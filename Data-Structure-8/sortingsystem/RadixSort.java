package sortingsystem;

/**
 * Radix Sort Implementation
 * 
 * @author Mahesh Chouhan
 *
 */
public class RadixSort {

	/**
	 * Returns minimum element in the array
	 * 
	 * @param array
	 * @return
	 */
	public static int getMinimum(Integer[] array) {
		int minimum = array[0];
		for (int index = 0; index < array.length; index++) {
			if( array[index] < minimum)
				minimum = array[index];
		}
		
		return minimum;
	}
	
	/**
	 * Returns maximum element in given array
	 * @param array
	 * @return Maximum array
	 */
	public static int getMaximum(Integer[] array) {
		int maximum = Math.abs(array[0]);
		for (int index = 0; index < array.length; index++) {
			if (Math.abs(array[index]) > Math.abs(maximum))
				maximum = Math.abs(array[index]);
		}
		
		return maximum;
	}

	/**
	 * Performs counting sort
	 * @param array
	 * @param exponent
	 */
	private static void countSort(Integer[] array, int exponent) {
		Integer[] output = new Integer[array.length];

		int count[] = new int[10];

		for (int index = 0; index < count.length; index++) {
			count[index] = 0;
		}

		for (int index = 0; index < array.length; index++) {
			count[(array[index] / exponent) % 10]++;
		}

		for (int index = 1; index < count.length; index++) {
			count[index] += count[index - 1];
		}

		for (int index = array.length - 1; index >= 0; index--) {
			int x = array[index];
			output[--count[(x / exponent) % 10]] = array[index];

		}

		for (int index = 0; index < array.length; index++) {
			array[index] = output[index];

		}

	}

	/**
	 * Performs Radix Sort
	 * @param array
	 */
	public static void performRadixSort(Integer[] array) {
		
		int min = RadixSort.getMinimum(array);
		if ( min < 0) {
			
			/*If minimum value is negative , add minimum value to array elements
			 * to make every element positive
			 */
			for (int index = 0; index < array.length; index++) {
				array[index] += min*(-1);
			}
		}
		
		int maximum = RadixSort.getMaximum(array);

		for (int exponent = 1; maximum / exponent > 0; exponent *= 10) {
			countSort(array, exponent);
		}
		
		if (min < 0) {
			
			for (int index = 0; index < array.length; index++) {
				array[index] += min;
			}
		}
		

	}
	
	/**
	 * Main function which drives all the functionality
	 * @param args
	 */
	public static void main(String[] args) {

		Integer array[] = { -170, -45, -75, -90, -802, -24, -2, -66 };

		RadixSort.performRadixSort(array);

		for (int index = 0; index < array.length; index++) {
			System.out.println(array[index]);
		}
	}

}
