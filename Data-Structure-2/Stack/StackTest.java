import java.util.EmptyStackException;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Test class for stack
 * @author Mahesh Chouhan
 *
 */
public class StackTest {
	
	@Test
	public void pushPass(){
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("mahesh");
		stack.push("chouhan");
		
		assertEquals("chouhan", stack.peek().getData());
		
	}
	@Test(expected = EmptyStackException.class)
	public void peekElementException(){
		
		Stack<String> stack = new Stack<String>();
		stack.peek();
		
	}
	
	@Test
	public void popPass(){
		Stack<String> stack = new Stack<String>();
		
		stack.push("mahesh");
		stack.push("chouhan");
		
		assertEquals("chouhan", stack.pop());
		
	}
	
	@Test(expected = EmptyStackException.class)
	public void popException(){
		Stack<String> stack = new Stack<String>();
		
		stack.pop();
		
	}
	
	@Test
	public void infixToPostfix(){
		
		Stack<String> stack = new Stack<String>();
		
		assertEquals("AT+BAC++CD+^*",stack.convertInfixToPostfix("( ( A + T ) * ( (B +(A+C))^(C+D)))"));
		
	}
	
	

}
