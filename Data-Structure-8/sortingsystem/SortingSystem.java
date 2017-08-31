package sortingsystem;

import java.util.Scanner;

public class SortingSystem {
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter total number of elements");
		
		int size = 0;

		//Loop until user inputs non integer values or negative values
		while (!scan.hasNextInt()|| (scan.hasNextInt() && (size = scan.nextInt()) <= 0)) {
			System.out.print("Enter Positive Integer !");
			if (!scan.hasNextInt())
				scan.next();
		}
		
		Integer array[] = new Integer[size];
		
		// Ask for values in array
		for (int index = 0; index < size; index++) {
			System.out.println("Enter " + (index + 1) + " element :");
			while (!scan.hasNextInt()) {
				System.out.println("Enter Integer !");
				scan.next();
			}
			// Store input value in array
			array[index] = scan.nextInt();
		}
		
		System.out.println("Choose Type of Sorting !");
		System.out.println("1.Comparison Sorting ( Bubble / Quick Sort )");
		System.out.println("2.Linear Sorting ( Counting / Radix Sort )");
		
		int choice = 0;
		while (!scan.hasNextInt()||( (scan.hasNextInt() && (choice = scan.nextInt()) <= 0  && choice > 2 ) )) {
			System.out.print("Enter Correct Option !");
			if (!scan.hasNextInt()){
				scan.next();
			}
			choice = scan.nextInt();
		}
		
		
	
		switch (choice) {
		case 1:
				if(array.length <= 10){
					System.out.println("Performing Bubble Sort");
					BubbleSort.performBubbleSort(array);
				}
				else{
					System.out.println("Performing Quick Sort");
					QuickSort.performQuickSort(array);
				}
			
			break;
		case 2:
			int max = RadixSort.getMaximum(array);
			if(max >= 99){
				System.out.println("Performing Radix Sort");
				RadixSort.performRadixSort(array);
			}
			else{
				System.out.println("Performing Counting Sort");
				CountingSort.performCountingSort(array, max + 1);
			}
		
		break;

		default: System.out.println("Enter correct choice !");
		
			break;
		}
		
		System.out.println("******************* AFTER SORTING **********************");
		for (int index = 0; index < array.length; index++) {
			System.out.println(array[index]);
		}
		
		scan.close();
	}

}
