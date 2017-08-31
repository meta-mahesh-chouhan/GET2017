import java.util.Iterator;
import java.util.LinkedList;
/**
 * Queue Implementation using Linked List collection
 * @author Mahesh Chouhan
 *
 * @param <T>
 */
public class Queue<T> implements Iterable<T> {

	private LinkedList<T> linkedList;

	public LinkedList<T> getLinkedList() {
		return linkedList;
	}

	public void setLinkedList(LinkedList<T> linkedList) {
		this.linkedList = linkedList;
	}

	public Queue() {
		linkedList = new LinkedList<T>();
	}

	/**
	 * Enqueue new element into list
	 * @param element
	 */
	public void enqueue(T element) {
		linkedList.add(element);
	}

	/**
	 * Dequeue element at top
	 * @return element at top
	 */
	public T dequeue() {
		return linkedList.remove();
	}

	/**
	 * Returns iterator to Queue
	 */
	@Override
	public Iterator<T> iterator() {
		return linkedList.iterator();
	}

	/**
	 * Check if Queue is empty
	 * @return True if Queue is empty otherwise false
	 */
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}

	/**
	 * Returns element at front
	 */
	public T peek() {
		return linkedList.getFirst();
	}

	/**
	 * Clear Queue
	 */
	public void clear() {
		linkedList.clear();
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
	
	public int size(){
		return linkedList.size();
	}

}
