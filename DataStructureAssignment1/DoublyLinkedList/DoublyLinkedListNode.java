public class DoublyLinkedListNode<T extends Comparable<T>> {
	private T data;
	private DoublyLinkedListNode<T> next;
	private DoublyLinkedListNode<T> previous;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DoublyLinkedListNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyLinkedListNode<T> next) {
		this.next = next;
	}

	public DoublyLinkedListNode<T> getPrevious() {
		return previous;
	}

	public void setPrevious(DoublyLinkedListNode<T> previous) {
		this.previous = previous;
	}
}
