import java.util.Iterator;

/**
 * Main class to drive all the functionality
 * @author Mahesh Chouhan
 *
 */
public class Main {
	
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		System.out.println("***********************Adding elements to stack**********************");
		stack.push("mahesh");
		stack.push("chouhan");
		stack.push("udit");
		stack.push("saxena");
		
	
		Iterator<String> iterator = stack.iterator();
		
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		

		System.out.println("***********************Pushing element 'gaurav' to stack**********************");
		stack.push("gaurav");
		
		iterator = stack.iterator();
		
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		System.out.println("***********************Popping element 'gaurav' to stack**********************");
		stack.pop();
		
		iterator = stack.iterator();
		
		while (iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
		System.out.println("***********************Peeking element at top of stack**********************");
		System.out.println(stack.peek());
		
		System.out.println("***********************Infix to Postfix conversion of '((A+B)*(Z+X))' with stack status**********************");
		System.out.println(stack.convertInfixToPostfix("((A+B)*(Z+X))"));
	}

}
