import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Doubly Linked List Implementation
 * @author Mahesh Chouhan
 *
 * @param <T>
 */
public class DoublyLinkedList<T extends Comparable<T>> implements Iterable<T> {

	private DoublyLinkedListNode<T> head;
	private int size;

	public DoublyLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(DoublyLinkedListNode<T> head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * Utility function to add element to linked list
	 * @param data
	 * @param head
	 */
	private DoublyLinkedListNode<T> addElementUtil(T data,
			DoublyLinkedListNode<T> head) {

		if (head == null) {
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();

			newNode.setData(data);
			head = newNode;

			size++;
			return newNode;
		}

		head.setNext(addElementUtil(data, head.getNext()));
		head.getNext().setPrevious(head);

		return head;
	}

	/**
	 * Add given element to linked list
	 * @param data
	 */
	public void addElement(T data) {

		head = addElementUtil(data, head);
	}

	/**
	 * Returns iterator to linked list
	 */
	@Override
	public Iterator<T> iterator() {

		Iterator<T> iterator = new Iterator<T>() {

			private DoublyLinkedListNode<T> currentIndex = head;

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
	 * Utility function to reverse Linked list.
	 * @param node
	 */
	private void reversalUtil(DoublyLinkedListNode<T> node) {

		if (node.getNext() == null) {
			head = node;
			head.setPrevious(null);
			return;
		}

		reversalUtil(node.getNext());

		node.getNext().setNext(node);
		node.setPrevious(node.getNext());
		node.setNext(null);

	}

	/**
	 * Reverse linked list
	 */
	public void reversal() {
		reversalUtil(head);
	}

	/**
	 * Sort the elements of linked list
	 */
	public void sort() {
		DoublyLinkedListNode<T> firstTterator = head;

		while (firstTterator != null) {
			DoublyLinkedListNode<T> secondIterator = firstTterator.getNext();

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

	/**
	 * Remove element by index
	 * @param index
	 */
	public void removeByIndex(int index){
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException(index
					+ " : index must be positive");
		}
	
		
		if (index == 0) {
			head = head.getNext();
			head.setPrevious(null);
			size--;
			return ;
		
		}

		if (index == size - 1) {
			DoublyLinkedListNode<T> iterator = head;
			while (iterator.getNext().getNext() != null) {
				iterator = iterator.getNext();
			}
			iterator.setNext(null);
			size--;
			return;
		}
		
		int currentIndex = 1;
		DoublyLinkedListNode<T> iterator = head;
		while (currentIndex < index) {
			iterator = iterator.getNext();
			currentIndex++;
		}

		iterator.setNext(iterator.getNext().getNext());
		iterator.getNext().setPrevious(iterator);
		size--;

	}

	/**
	 * Remove element by value
	 * @param value
	 */
	public void removeByValue(T value) {

		if (head.getData().equals(value)) {
			head = head.getNext();
			head.setPrevious(null);
			
		}

		DoublyLinkedListNode<T> iterator = head;

		boolean flag = false;
		while (iterator != null) {

			if (iterator.getData().equals(value)) {
				flag = true;

				if (iterator.getNext() != null)
					iterator.getNext().setPrevious(iterator.getPrevious());

				iterator.getPrevious().setNext(iterator.getNext());

				iterator.setPrevious(null);
				iterator.setNext(null);

			}

			iterator = iterator.getNext();

		}

		if (!flag) {
			throw new NoSuchElementException(value + "");
		}
		else
			size--;

	}

	/**
	 * Add element to linked list at given index
	 * @param data
	 * @param index
	 * @throws IllegalArgumentException
	 */
	public void addElement(T data, int index) throws IllegalArgumentException {

		head = addElementUtil(data, head, index);
	}

	/**
	 * Utility function to add element to linked list at given index
	 * 
	 * @param data
	 * @param head
	 * @param index
	 * @return
	 * @throws IllegalArgumentException
	 */
	private DoublyLinkedListNode<T> addElementUtil(T data,DoublyLinkedListNode<T> head, int index){

		if (index > size) {
			throw new IllegalArgumentException("Index: " + index + ", Size: "+ size);
		} else if (head == null) {
			head = addElementUtil(data, head);

		} else if (index == 0) {
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
			newNode.setData(data);
			newNode.setNext(head);
			head = newNode;

		} else {
			DoublyLinkedListNode<T> iterator = head;
			int currentIndex = 1;

			while (iterator != null && currentIndex < index) {
				iterator = iterator.getNext();
				currentIndex++;
			}
			DoublyLinkedListNode<T> newNode = new DoublyLinkedListNode<T>();
			newNode.setData(data);
			newNode.setNext(iterator.getNext());
			newNode.getNext().setPrevious(newNode);
			newNode.setPrevious(iterator);
			iterator.setNext(newNode);

		}
		return head;

	}

	/**
	 * Get Element by given index
	 * @param index
	 * @return Node at given index
	 */
	public T getElement(int index) {
		if (index < 0 || index >= size) {
			throw new IllegalArgumentException(index + "");
		}

		int currentIndex = 0;
		DoublyLinkedListNode<T> iterator = head;
		while (currentIndex < index) {
			iterator = iterator.getNext();
			currentIndex++;
		}

		return iterator.getData();
	}

}
