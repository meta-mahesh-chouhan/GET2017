import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;
public class QueueTest {
	
	@Test
	public void enqueuePass(){
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
	
		assertEquals(3, queue.size());
	}
	
	@Test
	public void enqueueFail(){
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
	
		assertNotEquals(6, queue.size());
	}
	
	
	@Test
	public void dequeuePass(){
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		assertEquals(Integer.valueOf(12), queue.dequeue());
		assertEquals(2, queue.size());
	}
	
	@Test
	public void dequeueFail(){
		Queue<Integer> queue = new Queue<Integer>();
		
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		assertNotEquals(Integer.valueOf(15), queue.dequeue());
		assertNotEquals(4, queue.size());
	}
	
	@Test
	public void isEmptyPass() {

		Queue<Integer> queue = new Queue<Integer>();
		assertTrue(queue.isEmpty());
	}
	

	@Test
	public void isEmptyFail() {

		Queue<Integer> queue = new Queue<Integer>();

		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);

		assertFalse(queue.isEmpty());

	}
	
	@Test
	public void sizePass(){
		

		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		assertEquals(3, queue.size());
		
	}
	

	@Test
	public void sizeFail(){
		

		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		assertNotEquals(0, queue.size());
		
	}
	
	@Test
	public void peekPass(){

		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		assertEquals(Integer.valueOf(12), queue.peek());
		
	}
	
	@Test
	public void peekFail(){

		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		assertNotEquals(Integer.valueOf(15), queue.peek());
		
	}
	
	@Test
	public void clearPass(){
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		queue.clear();
		
		assertEquals(0, queue.size());
		
	}
	
	@Test
	public void clearFail(){
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		queue.clear();
		
		assertNotEquals(3, queue.size());
		
	}
	
	@Test
	public void printPass(){
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		String expected = "12\n14\n15\n";
		
		assertEquals(expected, queue.print());
	}

	@Test
	public void printFail(){
		
		Queue<Integer> queue = new Queue<Integer>();

		String expected = "Empty Queue";
		
		assertEquals(expected, queue.print());
	}

	@Test
	public void iteratorPass(){
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		Iterator<Integer> iterator = queue.iterator();
		
		assertEquals(Integer.valueOf(12), iterator.next());
		
	}
	
	@Test
	public void iteratorFail(){
		
		Queue<Integer> queue = new Queue<Integer>();
		queue.enqueue(12);
		queue.enqueue(14);
		queue.enqueue(15);
		
		Iterator<Integer> iterator = queue.iterator();
		
		assertNotEquals(Integer.valueOf(14), iterator.next());
		
	}


}
