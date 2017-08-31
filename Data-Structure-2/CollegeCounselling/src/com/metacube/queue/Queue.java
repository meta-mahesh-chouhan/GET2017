package com.metacube.queue;

import java.util.Arrays;
import java.util.Iterator;
/**
 * Queue Implementation using array
 * @author Mahesh Chouhan
 * @param <T>
 */
public class Queue<T extends Comparable<T>> implements Iterable<T> {

	private int front;
	private int rear;
	private int size;
	private T[] array;

	public Queue(int size) {
		this.size = size;
		front = rear = -1;
	}

	public int getFront() {
		return front;
	}

	public void setFront(int front) {
		this.front = front;
	}

	public int getRear() {
		return rear;
	}

	public void setRear(int rear) {
		this.rear = rear;
	}

	public T[] getArray() {
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}

	/**
	 * Insert element from rear
	 * @param element
	 */
	@SuppressWarnings("unchecked")
	public void enqueue(T element) {

		if (front == -1 && rear == -1) {
			array = (T[]) new Comparable[size];
			front = 0;
		}
		
		if(rear == size -1){
			increaseSize();
			size++;
		}

		array[++rear] = element;

	}

	/**
	 * Remove element from front
	 * @return
	 */
	public T dequeue() {
		T data = array[front];

		for (int index = 0; index < rear; index++) {
			array[index] = array[index + 1];
		}

		array[rear] = null;
		rear--;
		return data;
	}

	public T peek() {
		return array[front];
	}

	public void printQueue() {

		if (array != null) {
			for (int index = front; index <= rear; index++) {
				System.out.println(array[index]);
			}
		} else {
			System.out.println("Empty Queue!");
		}

	}

	public int getSize() {
		return rear - front;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void makeEmpty() {
		array = null;
		front = rear = -1;
	}

	/**
	 * Sorts the elements of Queue
	 */
	public void sort() {
		for (int fristIndex = front; fristIndex < rear; fristIndex++) {
			for (int secondIndex = fristIndex + 1; secondIndex <= rear; secondIndex++) {
				if (array[fristIndex].compareTo(array[secondIndex]) > 0) {
					T temp = array[fristIndex];
					array[fristIndex] = array[secondIndex];
					array[secondIndex] = temp;
				}
			}
		}
	}

	/**
	 * Returns iterator to Queue
	 */
	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex <= rear;
			}

			@Override
			public T next() {
				return array[currentIndex++];
			}
		};

		return iterator;
	}

	/**
	 * Check if queue is empty
	 * @return True if it is empty otherwise false
	 */
	public boolean isEmpty() {

		if (rear == -1) {
			return true;
		}

		return false;
	}
	
	public void increaseSize(){
		array = Arrays.copyOf(array, array.length + 1);
	}

	/**
	 * Returns Queue in string form
	 */
	@Override
	public String toString() {
		Iterator<T> iterator = iterator();
		String result = "";
		while (iterator.hasNext()) {
			result += iterator.next() + " ";
		}
		return result;
	}

}
