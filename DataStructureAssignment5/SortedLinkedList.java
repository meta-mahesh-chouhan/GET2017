import java.util.Iterator;
import java.util.LinkedList;
/**
 * SortedLinkedList inserts element in sorted order
 * 
 * @author Mahesh Chouhan
 * @param <T>
 */
public class SortedLinkedList<T extends Comparable<T>> implements Iterable<T> {

	private LinkedList<T> linkedList;

	public SortedLinkedList() {
		linkedList = new LinkedList<T>();
	}

	/**
	 * Calls recursive function to add new element
	 * @param element
	 */
	public void add(T element) {
		add(element, 0);
	}
	
	
	/**
	 * Adds new element to Linked List using recursion
	 * @param element
	 * @param position
	 */
	public void add(T element, int position) {

		if (position >= linkedList.size()) {
			linkedList.add(position, element);
			return;
		}

		if (linkedList.get(position).compareTo(element) <= 0) {
			add(element, position + 1);
		} else {
			linkedList.add(position, element);
		}
	}

	/**
	 * Returns iterator to Linked List
	 */
	@Override
	public Iterator<T> iterator() {
		return linkedList.iterator();
	}
	
	/**
	 * Check if Linked List is empty
	 * @return True if Linked List is empty otherwise false
	 */
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	/**
	 * Return print String
	 */
	public String print() {
		String result = "";
		Iterator<T> iterator = iterator();

		if (!isEmpty()) {
			while (iterator.hasNext()) {
				result += iterator.next() + "\n";
			}
		} else {
			result = "Empty Queue";
		}
		return result;
	}
	
	/**
	 * Returns element at first
	 */
	public T getFirst(){
		return linkedList.getFirst();
	}

}
