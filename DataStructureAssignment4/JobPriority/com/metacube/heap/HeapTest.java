package com.metacube.heap;

import org.junit.Test;
import static org.junit.Assert.*;
public class HeapTest {

	@Test
	public void heapInsertTest(){
		
		Heap<Integer> heap = new Heap<Integer>();
		

		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		
		Integer expected = 5;
		Object[] array = heap.getArray();
		//Check if root contains highest element
		assertEquals(expected, array[0]);
		
	}
	@Test
	public void deleteFromHeap() {

		Heap<Integer> heap = new Heap<Integer>();

		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(4);
		heap.insert(5);
		
		heap.delete();
		Integer expected = 4;
		Object[] array = heap.getArray();
		//Check if root contains highest element
		assertEquals(expected, array[0]);
		

	}

	@Test
	public void isEmptyFail(){
		
		Heap<Integer> heap = new Heap<Integer>();
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		
		assertFalse(heap.isEmpty());
		
	}
	
	@Test
	public void isEmptyPass(){
		
		Heap<Integer> heap = new Heap<Integer>();
		heap.insert(1);
		heap.insert(2);
		heap.delete();
		heap.delete();
		
		
		assertTrue(heap.isEmpty());
		
	}
	
	@Test
	public void isFullPass(){
		
		Heap<Integer> heap = new Heap<Integer>(3);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		
		assertTrue(heap.isFull());
		
	}
	
	@Test
	public void isFullFail(){
		
		Heap<Integer> heap = new Heap<Integer>(3);
		heap.insert(1);
		heap.insert(2);
	
		
		assertFalse(heap.isFull());
		
	}
	
	@Test
	public void heapifyPass(){
		
		Heap<Integer> heap = new Heap<Integer>(3);
		Integer array[] = {3,4,5,1,2};
		
		heap.setArray(array);
		heap.Heapify(0);
		Object[] heapArray = heap.getArray();
	
		assertEquals(5, heapArray[0]);
		
	}
	
	@Test
	public void getParentPass(){
		
		Heap<Integer> heap = new Heap<Integer>(3);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		
		//Get parent index of 2
		int parentIndex = heap.getParentIndex(1);
		
		Object[] heapArray = heap.getArray();
		
		assertEquals(3, heapArray[parentIndex]);
		
	}
	
	@Test
	public void getleftChildPass(){
		
		Heap<Integer> heap = new Heap<Integer>(3);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		
		//Get left child of 3
		int leftChildIndex = heap.getLeftChildIndex(0);
		
		Object[] heapArray = heap.getArray();
		
		assertEquals(1, heapArray[leftChildIndex]);
		
	}
	
	@Test
	public void getRightChildPass(){
		
		Heap<Integer> heap = new Heap<Integer>(3);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		
		//Get right child of 3
		int rightChildIndex = heap.getRightChildIndex(0);
		
		Object[] heapArray = heap.getArray();
		
		assertEquals(2, heapArray[rightChildIndex]);
		
	}
}
