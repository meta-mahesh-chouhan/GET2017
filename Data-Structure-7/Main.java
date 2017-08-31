import java.util.Scanner;

/**
 * Main class which drives all the functionality
 * 
 * @author Mahesh Chouhan
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size = 0;

		//Loop until user inputs non integer values or negative values
		while (!scan.hasNextInt()|| (scan.hasNextInt() && (size = scan.nextInt()) <= 0)) {
			System.out.print("Enter Positive Integer !");
			if (!scan.hasNextInt())
				scan.next();
		}
		
		Integer[] array = new Integer[size];
		
		//Ask for values in array
		for (int index = 0; index < size; index++) {
			System.out.println("Enter " + (index + 1) + " element :");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer !");
				scan.next();
			}
			//Store input value in array
			array[index] = scan.nextInt();
		}

		System.out.println("Enter element to be searched");

		while (!scan.hasNextInt()) {
			System.out.println("Enter Integer !");
		}
		
		int element = scan.nextInt();
		
		BinarySearch search = new BinarySearch();
		int index = search.performBinarySearch(array, element);
		
		if(index != -1)
		System.out.println("Left most index of " + element + " : "+index );
		else
		System.out.println("Element not found");

		scan.close();
	}
}
