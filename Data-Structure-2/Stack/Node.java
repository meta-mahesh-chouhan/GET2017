/**
 * Node class for stack
 * @author Mahesh Chouhan
 *
 * @param <T>
 */
public class Node<T> {

	private T data;
	private Node<T> next;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return data.toString();
	}

}
