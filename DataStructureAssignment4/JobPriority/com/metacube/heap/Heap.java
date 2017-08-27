package com.metacube.heap;

import java.util.Arrays;

/**
 * Heap implementation using array
 * 
 * @author Mahesh Chouhan
 * @param <T>
 */
public class Heap<T extends Comparable<T>> {

	private T[] array;
	private int size;
	private int capacity;

	
	@SuppressWarnings("unchecked")
	public Heap() {
		this.size = -1;
		this.capacity = 1;
		array = (T[]) new Comparable[capacity];
	}

	/**
	 * Creates a heap of given size
	 * @param capacity
	 */
	@SuppressWarnings("unchecked")
	public Heap(int capacity) {
		this.capacity = capacity;
		this.size = -1;
		array = (T[]) new Comparable[capacity];
	}

	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
		this.size = array.length - 1;
		this.capacity = array.length;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * Check if heap is full
	 * @return True if heap is full otherwise false
	 */
	public boolean isFull() {
		if (size >= capacity - 1) {
			return true;
		}
		return false;
	}

	/**
	 * Increase size of heap by double
	 */
	public void increaseSize() {
		array = Arrays.copyOf(array, 2 * capacity);
		capacity = 2 * capacity;
	}

	/**
	 * get parent index from given index
	 * @param index
	 * @return Parent index
	 */
	public int getParentIndex(int index) {
		return (index - 1) / 2;
	}

	/**
	 * Get index of left child
	 * @param index
	 * @return Lift child index
	 */
	public int getLeftChildIndex(int index) {
		return 2 * index + 1;
	}

	/**
	 * Get right child index
	 * @param index
	 * @return Right child index
	 */
	public int getRightChildIndex(int index) {
		return 2 * index + 2;
	}

	/**
	 * Insert new element into heap
	 * @param element
	 */
	public void insert(T element) {

		if (isFull()) {
			increaseSize();
		}

		//Insert new element at leaf 
		array[++size] = element;

		int index = size;
		/*
		 * Until root is encountered , swap parent and child element if child is greater than parent 
		 */
		while (index > 0) {
			int parentIndex = getParentIndex(index);

			if (array[index].compareTo(array[parentIndex]) > 0) {
				T temp = array[index];
				array[index] = array[parentIndex];
				array[parentIndex] = temp;

			}
			index--;
		}
	}

	/**
	 * Delete element from root of heap
	 * @return
	 */
	public T delete() {
		T root = array[0];
		array[0] = array[size--];
		Heapify(0);
		return root;
	}

	/**
	 * This function ensures max heap property i.e. value of a node is greater than its left and right subtree
	 * @param index
	 */
	public void Heapify(Integer index) {
		
		if(index == null){
			return ;
		}
		
		Integer leftChildIndex = getLeftChildIndex(index) <= size ? getLeftChildIndex(index) : null;
		Integer rightChildIndex = getRightChildIndex(index) <= size ? getRightChildIndex(index) : null ;

		//Traverse until leaf nodes are encountered
		if (leftChildIndex != null && rightChildIndex != null) {
			
			
			if (array[leftChildIndex].compareTo(array[rightChildIndex]) >= 0 && array[leftChildIndex].compareTo(array[index]) > 0) {
				//If left child is greater than parent , swap parent and left child
				T temp = array[index];
				array[index] = array[leftChildIndex];
				array[leftChildIndex] = temp;
			} else if (array[rightChildIndex].compareTo(array[leftChildIndex]) > 0 && array[rightChildIndex].compareTo(array[index]) > 0) {
				//If right child is greater than parent , swap parent and right child
				T temp = array[index];
				array[index] = array[rightChildIndex];
				array[rightChildIndex] = temp;
			}

			//Ensure max heap property for left subtree
			Heapify(leftChildIndex);
			
			//Ensure max heap property for right subtree
			Heapify(rightChildIndex);

		} else if (leftChildIndex != null && rightChildIndex == null) {
			//If left child is greater than parent , swap parent and left child
			if (array[leftChildIndex].compareTo(array[index]) > 0) {
				T temp = array[index];
				array[index] = array[leftChildIndex];
				array[leftChildIndex] = temp;

			}

			Heapify(leftChildIndex);

		} else if (leftChildIndex == null && rightChildIndex != null) {
			//If right child is greater than parent , swap parent and right child
			T temp = array[index];
			array[index] = array[rightChildIndex];
			array[rightChildIndex] = temp;

			Heapify(rightChildIndex);

		}

	}

	/**
	 * Check is heap is empty
	 * @return True if heap is empty otherwise false
	 */
	public boolean isEmpty() {

		if (size == -1) {
			return true;
		}
		return false;
	}

}
