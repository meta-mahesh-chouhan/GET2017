package com.metacue.hashmap;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		//Ask user for number of total number of rooms
		System.out.println("Enter the total number of rooms :");
		int size = 0;
		boolean breakFlag = false;
		
		//Loop until user inputs valid number of rooms
		while (!breakFlag) {
			try {

				size = scan.nextInt();

				if (size <= 0) {
					System.out.println("Enter positive number !");
				} else {
					breakFlag = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter a Integer !");
				scan.next();
			}

		}
		HashTable<Integer, String> hashTable = new HashTable<>(size);
		boolean flag = true;
		
		//Loop until user chooses exit option
		while (flag) {

			System.out.println("1.Allocate Room");
			System.out.println("2.All Room Status");
			System.out.println("3.Get Customer Status");
			System.out.println("4.Exit");

			int choice = 0;
			breakFlag = false;
			//Loop while user chooses valid option
			while (!breakFlag) {
				try {
					choice = scan.nextInt();

					breakFlag = true;

				} catch (InputMismatchException e) {
					System.out.println("Enter a Integer !");
					scan.next();
				}

			}

			switch (choice) {

			case 1://Allocate Room
					if(!hashTable.isFull()){
					System.out.println("Enter your name ");
					scan.nextLine();
					String name = scan.nextLine();
					
					//loop until user inputs non empty name
					while (name.trim().equals("")) {
						System.out.println("Empty String : Write Something");
						scan.nextLine();
						name = scan.nextLine();
					}
					System.out.println("Enter age ");
	
					int age = 0;
					breakFlag = false;
					//loop until user inputs valid age
					while (!breakFlag) {
						try {
							age = scan.nextInt();
	
							if (age <= 0) {
								System.out.println("Enter Positive Number !");
							} else {
								breakFlag = true;
							}
						} catch (InputMismatchException e) {
							System.out.println("Enter a Integer !");
							scan.next();
						}
					}
					//Store in hash table
					int roomAlloted = hashTable.put(age, name);
					
					System.out.println(name + " is alloted room no. " + (roomAlloted+1));
					}
					else{
					System.out.println("Hash Table is Full !");	
					}
					break;
			case 2://Show Room status
					Object[] array = hashTable.getArray();
					for (int index = 0; index < size; index++) {
						System.out.println("Room "+ (index + 1)+ (array[index] == null ? " is not allocated to anyone ": " is allocated to "+ array[index]));
					}
					break;
			case 3://Show Room status for particular username
					System.out.println("Enter your name ");
					scan.nextLine();
					String name = scan.nextLine().trim();
	
					while (name.trim().equals("")) {
						System.out.println("Empty String : Write Something");
						scan.nextLine();
						name = scan.nextLine();
					}
					int index = hashTable.search(name);
					if (index != -1) {
						System.out.println(name + " is allocated room no. "+ (index + 1));
					} else {
						System.out.println(name + " is not allocated any room ");
					}
					break;
			case 4://Exit the loop
					flag = false;
					break;
			default://User does not choose valid option
					System.out.println("Choose only from above options !");

			}

		}

		scan.close();
	}

}
