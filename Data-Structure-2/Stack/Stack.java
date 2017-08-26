import java.util.EmptyStackException;
import java.util.Iterator;
/**
 * Stack implementation using linked list
 * @author Mahesh Chouhan
 *
 * @param <T>
 */
public class Stack<T> implements Iterable<T> {

	private Node<T> top;

	public Node<T> getTop() {
		return top;
	}

	public void setTop(Node<T> top) {
		this.top = top;
	}

	/**
	 * Check if stack is empty
	 * @return True if empty otherwise false
	 */
	public boolean isEmpty() {

		if (top == null) {
			return true;
		}
		return false;
	}

	/**
	 * Insert new element at top
	 * @param element
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void push(T element) {

		Node newNode = new Node();
		newNode.setNext(top);
		top = newNode;
		newNode.setData(element);

	}

	/**
	 * Remove element form top
	 * @return Element at top
	 */
	public T pop() {

		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T data = top.getData();
		top = top.getNext();
		return data;
	}

	/**
	 * Returns iterator for stack
	 */
	@Override
	public Iterator<T> iterator() {
		Iterator<T> iterator = new Iterator<T>() {

			private Node<T> currentIndex = top;

			@Override
			public boolean hasNext() {
				return currentIndex != null;
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
	 * Returns element at top
	 */
	public Node<T> peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}

		return top;
	}

	/**
	 * Return precedence of different operators 
	 * 
	 * @param character
	 * @return integer representing precedence
	 */
	private int precedence(char character) {
		int precedence;
		switch (character) {
		case '+':
		case '-':
			precedence = 1;
			break;
		case '*':
		case '/':
			precedence = 2;
			break;
		case '^':
			precedence = 3;
			break;
		default:
			precedence = -1;
		}

		return precedence;
	}

	/**
	 * Prints the stack
	 */
	public void printStack() {
		if (isEmpty()) {
			System.out.println("Empty Stack");
			return;
		}

		Iterator<T> iterator = iterator();

		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	/**
	 * Convert infix expression to postfix
	 * @param infix
	 * @return postfix expression string
	 */
	public String convertInfixToPostfix(String infix) {
		Stack<Character> myStack = new Stack<Character>();

		String postfix = "";
		for (int index = 0; index < infix.length(); index++) {

			char c = infix.charAt(index);
			if (c != ' ') {
				//If character is digit or letter append to Postfix string
				if (Character.isLetterOrDigit(c)) {
					postfix += infix.charAt(index);
				} else if (myStack.isEmpty()) {
					//If stack is initially empty ,push character without checking precedence 
					myStack.push(c);
				} else if (c == '('|| precedence(c) > precedence(myStack.peek().getData())) {
					/*If character is '(' push it in stack or if precedence of character is greater 
					 * than precedence of element at top push it in stack
					 */
					myStack.push(c);
				} else if (c == ')') {
					//If character is ')',pop until '(' is encountered
					while (myStack.peek().getData() != '(') {
						postfix += myStack.pop();
					}
					myStack.pop();
				} else {
					/* Pop until precedence of character is less than precedence of peek
					 */
					while (!myStack.isEmpty() && precedence(c) <= precedence(myStack.peek().getData())) {
						postfix += myStack.pop();
					}

					myStack.push(c);
				}
				//Print stack status in each iteration
				myStack.printStack();
				System.out.println("################");
			}
		}

		/*
		 * When all the characters of string are parsed, pop elements from stack and append to
		 * postfix string until stack is empty
		 */
		while (!myStack.isEmpty()) {
			postfix += myStack.pop();
		}

		return postfix;
	}

}
