/**
 * Binary search Tree implementation
 * 
 * @author Mahesh Chouhan
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> {

	private Node<T> root;
	private int indexCounter = 0;

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	/**
	 * Creates a new node and returns it
	 * 
	 * @param element
	 * @return NewNode
	 */
	public Node<T> getNewNode(T element) {
		Node<T> newNode = new Node<T>();

		newNode.setData(element);
		newNode.setIndex(indexCounter++);
		return newNode;
	}

	/**
	 * Inserts new element into tree
	 * 
	 * @param element
	 */
	public void insert(T element) {

		root = insert(root, element);
	}

	/**
	 * Utility function to add given element into tree
	 * 
	 * @param root
	 * @param element
	 */
	public Node<T> insert(Node<T> root, T element) {

		if (root == null) {
			// If root is null , point root to newNode
			root = getNewNode(element);

		} else {

			if (root.getData().compareTo(element) >= 0) {
				// If given element is less than or equal to root element , then
				// insert element in left subtree
				root.setLeft(insert(root.getLeft(), element));
			} else {
				// If given element is greater than root element , then insert
				// element in right subtree
				root.setRight(insert(root.getRight(), element));
			}
		}

		return root;
	}

	/**
	 * Search for given element and return its index
	 * 
	 * @param element
	 * @return index of searched element
	 */
	public int search(T element) {
		return search(root, element);
	}

	/**
	 * Utility function to search a given element and return its index
	 * 
	 * @param root
	 * @param element
	 * @return index of searched element
	 */
	public int search(Node<T> root, T element) {

		if (root == null)
			return -1;

		if (root.getData().compareTo(element) == 0) {
			// If element is found ,return its index
			return root.getIndex();
		} else if (root.getData().compareTo(element) > 0) {
			// If root is greater than searched element,search in left subtree
			return search(root.getLeft(), element);
		} else
			// If root is less than searched element , search right subtree
			return search(root.getRight(), element);

	}

}
