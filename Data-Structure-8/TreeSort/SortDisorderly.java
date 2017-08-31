import java.util.Scanner;

public class SortDisorderly {

	@SuppressWarnings("rawtypes")
	private Comparable[] array;

	private int indexCounter = 0;

	/**
	 * Sorts unsorted student array using Tree Sort
	 * @param array
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void sort(Comparable[] array) {

		BinarySearchTree tree = new BinarySearchTree();
		// Add elements of unsorted array into tree
		for (int index = 0; index < array.length; index++) {
			tree.insert(array[index]);
		}
		
		Comparable[] output = sortUsingInOrder(array, tree.getRoot());
		
		//Copy sorted array into unsorted array
		for (int index = 0; index < output.length; index++) {
			array[index] = output[index];
		}
	}

	/**
	 * Utility function to sort using InOrder
	 * @param array
	 * @param root
	 * @return Sorted array
	 */
	@SuppressWarnings({ "rawtypes" })
	private Comparable[] sortUsingInOrder(Comparable[] array, Node root) {
		this.array = new Comparable[array.length];
		sortUsingInOrder(root);
		return this.array;
	}

	/**
	 * Sort using InOrder
	 * @param root
	 */
	@SuppressWarnings("rawtypes")
	private void sortUsingInOrder(Node root) {

		if (root == null) {
			return;
		}
		sortUsingInOrder(root.getLeft());
		// Add Student to array in sorted order
		array[indexCounter++] = (Comparable) root.getData();
		sortUsingInOrder(root.getRight());

	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of students you want to add ");
		int size = 0;

		// Loop until user inputs non integer values or negative values
		while (!scan.hasNextInt()|| (scan.hasNextInt() && (size = scan.nextInt()) <= 0)) {
			System.out.print("Enter Positive Integer !");
			if (!scan.hasNextInt())
				scan.next();
		}

		Student[] array = new Student[size];

		// Ask for values in array
		for (int index = 0; index < size; index++) {

			System.out.println("Enter " + (index + 1)+ " Student's Roll Number ");
			int rollNumber = 0;
			while (!scan.hasNextInt()|| (scan.hasNextInt() && (rollNumber = scan.nextInt()) <= 0)) {
				System.out.print("Enter Positive Integer !");
				if (!scan.hasNextInt())
					scan.next();
			}
			System.out.println("Enter Student Name ");
			scan.nextLine();
			// Storing name
			String name = scan.nextLine();

			while (name.trim().equals("")) {
				System.out.print("Empty : Write Something");
				name = scan.next();
			}
			array[index] = new Student(rollNumber, name);
		}

		System.out.println("***************** SORTED ARRAY ***************** ");

		// Call sort function to sort Student Array
		new SortDisorderly().sort(array);

		for (Student student : array) {
			System.out.println(student);
		}
		scan.close();
	}

}
