package com.metacube.heap;

public class Main {

	public static void main(String[] args) {
		Heap<Integer> heap = new Heap<Integer>(5);

		//Insert values into heap 
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		
		System.out.println("***********************After Insertion***********************");
		Object[] array = heap.getArray();
		for (int i = 0; i <= heap.getSize(); i++) {
			System.out.println(array[i].toString());
		}

		//delete value for root
		heap.delete();

		System.out.println("***********************After Deletion***********************");
		array = heap.getArray();
		for (int i = 0; i <= heap.getSize(); i++) {
			System.out.println(array[i].toString());
		}
	}
}
