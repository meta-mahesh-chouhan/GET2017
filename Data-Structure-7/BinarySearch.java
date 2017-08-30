/**
 * Binary Class which performs the binary search on input array
 * 
 * @author Mahesh Chouhan
 *
 */
public class BinarySearch {

	/**
	 * Returns the left most index of given element in array
	 * 
	 * @param array
	 * @param element
	 * @return left most index of given element
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public int performBinarySearch(Comparable[] array, Comparable element) {

		BinarySearchTree tree = new BinarySearchTree();

		// Inserting elements into array
		for (int index = 0; index < array.length; index++) {
			tree.insert(array[index]);
		}

		// Returns the left most index of given element in array
		return tree.search(element);

	}

}
