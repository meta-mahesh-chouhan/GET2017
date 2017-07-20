import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Generates all permutations of the given string using a backtracking
 * algorithm.In this program , we start fixing letters from start to the end of
 * the string.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Permutation {

	List<String> permutation = new ArrayList<String>();

	/**
	 * Swaps the letters at source index and destination index of the input
	 * string.
	 * 
	 * @param input
	 * @param source
	 *            index
	 * @param destination
	 *            index
	 * @return Updated string with swapped letters
	 */
	String swap(String input, int source, int destination) {

		/*
		 * Since Strings are immutable , they can only be changed after
		 * converting to char array.
		 */
		char[] inputArray = input.toCharArray();

		// Swap the letters
		char temp = inputArray[source];
		inputArray[source] = inputArray[destination];
		inputArray[destination] = temp;

		// Update the input string
		input = new String(inputArray);

		return input;

	}

	/**
	 * Return a list with distinct elements
	 * @param list
	 * @return list conatining distinct elements
	 */
	public List<String> removeDuplicates(List<String> list) {
		int k;
		
		boolean flag = true;
		
		List<String> distinctList = new ArrayList<String>();
		distinctList.add(list.get(0));
		
		for (int i = 1; i < list.size(); i++) {
			flag = true;
			for (int j = 0; j < distinctList.size(); j++) {
				//If element in distinctList and List are similar then break
				if (list.get(i).equals(distinctList.get(j))) {
					flag = false;
					break;
				}
			}
			//Add distinct elements to distinctList
			if (flag == true) {
				distinctList.add(list.get(i));
			}

		}
		return distinctList;
	}

	/**
	 * Generates different permutations of given input string.
	 * 
	 * @param input
	 * @param startIndex
	 * @param endIndex
	 * @return List representing different permutation.
	 */
	List<String> generatePermutations(String input, int startIndex, int endIndex) {

		// Base condition: when all the letters of the string are fixed.
		if (startIndex == endIndex) {
			permutation.add(input);
			return permutation;
		}

		for (int i = startIndex; i <= endIndex; i++) {

			input = swap(input, startIndex, i);

			// Recursive calls
			generatePermutations(input, startIndex + 1, endIndex);

			// BackTracking to move to origin configuration
			input = swap(input, startIndex, i);
		}

		return removeDuplicates(permutation);

	}

}
