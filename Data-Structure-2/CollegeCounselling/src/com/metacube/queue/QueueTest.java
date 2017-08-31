package com.metacube.queue;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test cases for Queue Class
 * @author Mahesh Chouhan 
 *
 */
public class QueueTest {

	@Test
	public void enqueueTest() {
		Queue<String> queue = new Queue<String>(2);

		queue.enqueue("mahesh");
		queue.enqueue("chouhan");

		assertEquals("mahesh", queue.peek());

	}

	@Test
	public void dequeueTest() {
		Queue<String> queue = new Queue<String>(4);

		queue.enqueue("mahesh");
		queue.enqueue("chouhan");
		queue.enqueue("udit");
		queue.enqueue("saxena");

		queue.dequeue();
		assertEquals("chouhan", queue.peek());

	}

	@Test
	public void clearTest() {
		Queue<String> queue = new Queue<String>(4);

		queue.enqueue("mahesh");
		queue.enqueue("chouhan");
		queue.enqueue("udit");
		queue.enqueue("saxena");
		
		queue.makeEmpty();
		
		assertNull(queue.getArray());

	}
	
	@Test
	public void isEmptyPassTest(){
		Queue<String> queue = new Queue<String>(4);

		queue.enqueue("mahesh");
		queue.enqueue("chouhan");
		queue.dequeue();
		queue.dequeue();
		
		assertTrue(queue.isEmpty());
		
		
	}
	@Test
	public void isEmptyPassFail(){
		Queue<String> queue = new Queue<String>(4);

		queue.enqueue("mahesh");
		queue.enqueue("chouhan");
		queue.dequeue();

		
		assertFalse(queue.isEmpty());
		
		
	}
	@Test
	public void sortTest(){
		Queue<Integer> queue = new Queue<Integer>(5);
		
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(5);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.sort();
		
		assertEquals(Integer.valueOf(1), queue.peek());
		
	}
	
	@Test
	public void toStringTest(){
		Queue<Integer> queue = new Queue<Integer>(5);
		
		queue.enqueue(4);
		queue.enqueue(1);
		queue.enqueue(5);
		queue.enqueue(2);
		queue.enqueue(3);

		assertEquals("4 1 5 2 3 ", queue.toString());
		
	}
	
}
