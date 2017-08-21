import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked List implementation
 * 
 * @author Mahesh Chouhan
 *
 * @param <T>
 */
public class LinkedList<T extends Comparable<T>> implements Iterable<T> {

	private Node<T> head;
	private int size;

	public Node<T> getHead() {
		return head;
	}

	public void setHead(Node<T> head) {
		this.head = head;

	}

	/**
	 * Utility function to add given element to the linked list
	 * @param data
	 * @param head
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Node<T> addElementUtil(T data, Node<T> head) {

		if (head == null) {
			Node newNode = new Node<T>();

			newNode.setData(data);
			head = newNode;

			size++;
			return newNode;
		}

		head.setNext(addElementUtil(data, head.getNext()));

		return head;
	}

	/**
	 * Add given element to the linked list
	 * @param data
	 */
	public void addElement(T data) {

		head = addElementUtil(data, head);
	}

	/**
	 * Add given element at given index
	 * @param data
	 * @param index
	 * @throws IllegalArgumentException
	 */
	public void addElement(T data, int index) throws IllegalArgumentException {

		head = addElementUtil(data, head, index);
	}

	/**
	 * Utility function to add given element at given index.
	 * 
	 * @param data
	 * @param head
	 * @param index
	 * @throws IllegalArgumentException
	 */
	private Node<T> addElementUtil(T data, Node<T> head, int index)
			throws IllegalArgumentException {

		if (index > size) {
			throw new IllegalArgumentException("Index: " + index + ", Size: "+ size);
			
		} else if (head == null) {
			head = addElementUtil(data, head);

		} else {
			Node<T> iterator = head;
			int currentIndex = 1;

			while (iterator != null && currentIndex < index) {
				iterator = iterator.getNext();
				currentIndex++;
			}
			Node<T> newNode = new Node<T>();
			newNode.setData(data);
			newNode.setNext(iterator.getNext());
			iterator.setNext(newNode);
		}
		return head;

	}
	
	
	/**
	 * Returns iterator to linked list
	 */
	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {

			private Node<T> currentIndex = head;

			@Override
			public boolean hasNext() {

				if (currentIndex == null) {
					return false;
				}
				return true;
			}

			@Override
			public T next() {

				T data = currentIndex.getData();
				currentIndex = currentIndex.getNext();
				return data;
			}
		};

		return iterator;
	}

	/**
	 * Utility function to reverse linked list.
	 *
	 */
	private void reversalUtil(Node<T> node) {

		if (node.getNext() == null) {
			head = node;
			return;
		}

		reversalUtil(node.getNext());

		node.getNext().setNext(node);
		node.setNext(null);
	}

	/**
	 * Reverse a linked list.
	 */
	public void reversal() {
		reversalUtil(head);
	}

	/**
	 * Sorts the linked list
	 */
	public void sort() {
		Node<T> firstTterator = head;

		while (firstTterator != null) {
			Node<T> secondIterator = firstTterator.getNext();

			while (secondIterator != null) {

				if (firstTterator.getData().compareTo(secondIterator.getData()) > 0) {
					T temp = firstTterator.getData();
					firstTterator.setData(secondIterator.getData());
					secondIterator.setData(temp);

				}
				secondIterator = secondIterator.getNext();
			}
			firstTterator = firstTterator.getNext();
		}

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * 
	 * @param index
	 * @return
	 */
	public T getElement(int index)throws IllegalArgumentException {
		if (index < 0) {
			throw new IllegalArgumentException(index
					+ " : index must be positive");
		}
		
		if(index >= size){
			throw new IllegalArgumentException(index+"");
		}

		int currentIndex = 0;
		Node<T> iterator = head;
		while (currentIndex < index) {
			iterator = iterator.getNext();
			currentIndex++;
		}

		return iterator.getData();
	}

	/**
	 * Removes element by index
	 * @param index
	 */
	public void removeByIndex(int index) {
		if (index < 0) {
			throw new IllegalArgumentException(index + " : index must be positive");
		}
		if (index == 0){
			head = head.getNext();
			return;
		}
		
		if(index >= size){
			throw new IllegalArgumentException(index+"");
		}

		int currentIndex = 1;
		Node<T> iterator = head;
		while (currentIndex < index) {
			iterator = iterator.getNext();
			currentIndex++;
		}

		iterator.setNext(iterator.getNext().getNext());
		size--;

	}

	/**
	 * Removes element by value
	 * @param value
	 */
	public void removeByValue(T value) {

		if (head.getData().equals(value)) {
			head = head.getNext();
		}

		Node<T> iterator = head;
		Node<T> previous = head;
		boolean flag = false;
		while (iterator != null) {

			if (iterator.getData().equals(value)) {
				flag = true;
				previous.setNext(iterator.getNext());
				size--;

			}
			previous = iterator;
			iterator = iterator.getNext();

		}

		if (!flag) {
			throw new NoSuchElementException(value + "");
		}

	}

}
