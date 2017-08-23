/**
 * Main class which drives all the functionality
 * @author Mahesh Chouhan
 *
 */
public class Main {

	public static void main(String[] args) {
		Tree<Integer> tree = new Tree<Integer>();

		// Adding elements to tree
		tree.addElement(1);
		tree.addElement(2);
		tree.addElement(3);
		tree.addElement(4);
		tree.addElement(5);

		System.out.println("**********Preorder Traversal*************");
		// Print preOrder String
		System.out.println(tree.preOrderTraversal());
		System.out.println();

		System.out.println("**********Postorder Traversal*************");
		// Print postOrder String
		System.out.println(tree.postOrderTraversal());
		System.out.println();

		// Creating mirror tree
		Tree<Integer> tree2 = new Tree<Integer>();

		tree2.addMirrorElement(1);
		tree2.addMirrorElement(2);
		tree2.addMirrorElement(3);
		tree2.addMirrorElement(4);
		tree2.addMirrorElement(5);

		// Check mirror tree
		System.out.println("**********Check Mirror*************");
		System.out.println(tree.checkMirror(tree2));

	}
}
