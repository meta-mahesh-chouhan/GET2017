import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayList Implementation using array
 * 
 * @author Mahesh Chouhan
 * @param <T>
 */
public class ArrayList<T extends Comparable<T>> implements Iterable<T> {

	private int size;
	private int end;
	private T[] array;

	/**
	 * Creates an ArrayList of size zero.
	 */
	public ArrayList() {
		size = 0;
		end = 0;
	}

	/**
	 * Creates an ArrayList of given size.
	 * 
	 * @param size
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int size){

		if (size > 0) {
			this.size = size;
			array = (T[]) new Comparable[size];
			end = 0;
		} else {
			throw new IllegalArgumentException("Illegal Capacity: " + size);
		}
	}

	public int getSize() {
		return end;
	}

	public void setSize(int size) {
		this.size = size;
	}


	public T[] getArray() {
	
		return array;
	}

	public void setArray(T[] array) {
		this.array = array;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isFull() {
		if (this.end >= this.size) {
			return true;
		}
		return false;
	}

	/**
	 * Double ArrayList Size in case of overflow
	 * 
	 * @return ArrayList of double size
	 */
	@SuppressWarnings("unchecked")
	public T[] increaseSize() {

		T[] newArray = (T[]) new Comparable[2 * size];

		for (int index = 0; index < size; index++) {
			newArray[index] = array[index];
		}
		size = 2 * size;
		return newArray;

	}

	/**
	 * Add given element to ArrayList
	 * 
	 * @param element
	 */
	@SuppressWarnings("unchecked")
	public void addElement(T element) {

		if (size == 0) {
			size++;
			array = (T[]) new Comparable[size];
		}
		if (isFull()) {
			array = increaseSize();
		}

		array[end++] = element;

	}

	/**
	 * Add given element at given index
	 * 
	 * @param index
	 * @param element
	 * @throws ArrayIndexOutOfBoundsException
	 */
	@SuppressWarnings("unchecked")
	public void addElement(int index, T element){

		if (index == 0) {
			size = size == 0 ? 1 : size;
			array = (T[]) new Comparable[size];
			array[end++] = element;
			return;
		}
		
		 if ( index == size){
				/*This is the case when user does not specify the size of ArrayList
				 * so we need to increase size in case overflow.
				 */
				array = increaseSize();
				array[index] = element;
		}
		
			array[index] = element;
	
		

	}

	/**
	 * Returns iterator to ArrayList
	 */
	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {

			private int currentIndex = 0;

			@Override
			public boolean hasNext() {
				return currentIndex < end;
			}

			@Override
			public T next() {
				return array[currentIndex++];
			}

		};
		return iterator;

	}

	/**
	 * Empty Linked List
	 */
	public void clear() {
		array = null;
		size = 0;
		end = 0;
	}

	/**
	 * Returns element at given index
	 * 
	 * @param index
	 * @return
	 */
	public T getElement(int index){

		if (index >= size) {
			throw new IllegalArgumentException(index + "");
		}
		return array[index];
	}

	/**
	 * Sorts the elements of ArrayList
	 */
	public void sort() {

		for (int i = 0; i < end - 1; i++) {

			for (int j = i + 1; j < end; j++) {
				if (getElement(i).compareTo(getElement(j)) > 0) {
					T temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	/**
	 * Reverse the ArrayList.
	 */
	public void reverse() {

		int i = 0;
		int j = end - 1;

		while (i < j) {
			T temp = array[j];
			array[j] = array[i];
			array[i] = temp;
			i++;
			j--;
		}
	}

	/**
	 * Removes element by given index
	 * 
	 * @param index
	 */
	@SuppressWarnings("unchecked")
	public void removeByIndex(int index) {

		for (int i = index; i < end - 1; i++) {
			array[i] = array[i + 1];
		}
		end--;
		size--;
		
		T[] newArray = (T[]) new Comparable[end];
		
		for (int i = 0; i < end; i++) {
		 newArray[i] = array[i];
		}
		
		array = newArray;
	}

	/**
	 * Remove element by value
	 * 
	 * @param value
	 */
	public void removeByValue(T value) {
		for (int i = 0; i < end; i++) {
			if (array[i] == value)
				removeByIndex(i);
		}
		
	}

	/**
	 * Returns index of first occurrence of given value
	 * 
	 * @param value
	 * @return
	 * @throws NoSuchElementException
	 */
	public int firstOccurence(T value){
		for (int i = 0; i < end; i++) {
			if (array[i] == value)
				return i;
		}
		throw new NoSuchElementException(value + "");
	}

	/**
	 * Returns index of first occurrence of given value after given position
	 * 
	 * @param value
	 * @param position
	 * @return
	 * @throws NoSuchElementException
	 */
	public int firstOccurence(T value, int position){
		for (int i = position; i < end; i++) {
			if (array[i] == value)
				return i;
		}
		throw new NoSuchElementException(value + "");
	}

	/**
	 * Add new ArrayList to current List.
	 * 
	 * @param subList
	 */
	public void addList(ArrayList<T> subList) {

		for (int i = 0; i < subList.getSize(); i++) {

			addElement(subList.getElement(i));

		}

	}

}
