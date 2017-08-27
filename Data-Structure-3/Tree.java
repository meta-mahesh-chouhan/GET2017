import java.util.LinkedList;
import java.util.Queue;

/**
 * Linked list representation of Tree
 * 
 * @author Mahesh Chouhan
 *
 */
public class Tree<T> {

	private Node<T> root;
	
	//Queue to keep track of nodes inserted
	private Queue<Node<T>> queue = new LinkedList<Node<T>>();
	
	private String preOrderResult;
	private String postOrderResult;

	public Node<T> getRoot() {
		return root;
	}

	public void setRoot(Node<T> root) {
		this.root = root;
	}

	/**
	 * Create a new node and returns it
	 * @param data
	 * @return New node
	 */
	public Node<T> getNewNode(T data) {
		Node<T> newNode = new Node<T>();
		newNode.setData(data);
		return newNode;
	}

	/**
	 * Add element to tree
	 * @param data
	 */
	public void addElement(T data) {

		root = addElement(data, root);
	}
	
	/**
	 * Utility method to Add elements to mirror tree
	 * @param data
	 */
	private Node<T> addElement(T data, Node<T> root) {

		if (root == null) {
			root = getNewNode(data);
			queue.add(root);
		} else {

			Node<T> front = queue.peek();
			if (front.getLeft() == null) {
				
				front.setLeft(getNewNode(data));
				queue.add(root.getLeft());
				
			} else if (front.getRight() == null) {

				front.setRight(getNewNode(data));
				queue.add(front.getRight());

			} else if (front.getRight() != null && front.getLeft() != null) {
				
				addElement(data, queue.remove());

			}
		}
		return root;
	}
	
	/**
	 * Add elements to mirror tree
	 * @param data
	 */
	public void addMirrorElement(T data) {

		root = addMirrorElement(data, root);
	}

	/**
	 * Utility method to add mirror elements to tree 
	 * @param data
	 * @param root
	 * @return
	 */
	private Node<T> addMirrorElement(T data, Node<T> root) {

		if (root == null) {
			
			root = getNewNode(data);
			queue.add(root);
			
		} else {

			Node<T> front = queue.peek();
			if (front.getRight() == null) {

				front.setRight(getNewNode(data));
				queue.add(front.getRight());

			} else if (front.getLeft() == null) {
				
				front.setLeft(getNewNode(data));
				queue.add(root.getLeft());
				
			} else if (front.getRight() != null && front.getLeft() != null) {
				
				addMirrorElement(data, queue.remove());

			}
		}
		return root;
	}
	
	/**
	 * Create a preOrderTraversal string and returns it
	 * @return
	 */
	public String preOrderTraversal() {
		
		preOrderResult = "";
		preOrderTraversal(root);

		return preOrderResult;
	}

	/**
	 * Utility method to generate preOrderTraversal string
	 * @param root
	 */
	private void preOrderTraversal(Node<T> root) {

		if (root == null)
			return;

		preOrderResult += root.getData() + " ";
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
	}

	/**
	 * Utility method to generate postOrderTraversal string
	 * @param root
	 */
	private void postOrderTraversal(Node<T> root) {

		if (root == null)
			return;

		postOrderTraversal(root.getLeft());
		postOrderTraversal(root.getRight());
		postOrderResult += root.getData() + " ";
	}

	/**
	 * Create a postOrderTraversal string and returns it
	 * @return
	 */
	public String postOrderTraversal() {
		postOrderResult = "";
		postOrderTraversal(root);
		return postOrderResult;
	}

	/**
	 * Checks if first tree is mirror of second tree
	 * @param firstRoot
	 * @param secondRoot
	 * @return True if first tree is mirror of second
	 */
	private boolean checkMirror(Node<T> firstRoot, Node<T> secondRoot) {

		if ((firstRoot == null && secondRoot == null)) {
			return true;
		}

		if ((firstRoot == null && secondRoot != null )|| (firstRoot != null && secondRoot == null)) {
			return false;
		}

		if (firstRoot.getData() == secondRoot.getData() && checkMirror(firstRoot.getLeft(), secondRoot.getRight()) && checkMirror(firstRoot.getRight(), secondRoot.getLeft())) {
			return true;
		}
		return false;
	}

	/**
	 * Check if first tree is mirror of second tree
	 * @param secondTree
	 * @return True if first tree is mirror of second
	 */
	public boolean checkMirror(Tree<T> secondTree) {

		return checkMirror(this.root, secondTree.getRoot());
	}

}
