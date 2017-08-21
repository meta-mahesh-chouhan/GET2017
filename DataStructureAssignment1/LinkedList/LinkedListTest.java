import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class LinkedListTest {
	
	@Test
	public void createLinkedListPass(){
		
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.addElement("mahesh");
		linkedList.addElement("chouhan");

		assertEquals("chouhan", linkedList.getElement(1));
		
	}
	
	@Test
	public void addElementToListIndex(){
		
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.addElement("chouhan",0);

		assertEquals("chouhan", linkedList.getElement(0));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addElementToListIndexException(){
		
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.addElement("chouhan",1);

		
	}
	@Test
	public void reversalTest(){
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addElement(1);
		linkedList.addElement(2);
		linkedList.addElement(3);
	
		linkedList.reversal();
		LinkedList<Integer> expected = new LinkedList<Integer>();
		expected.addElement(3);
		expected.addElement(2);
		expected.addElement(1);
		
		assertEquals(linkedList.getElement(0), expected.getElement(0));
		assertEquals(linkedList.getElement(1), expected.getElement(1));
		assertEquals(linkedList.getElement(2), expected.getElement(2));
		
		
	}
	
	@Test
	public void sort(){
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		
		linkedList.sort();
		LinkedList<Integer> expected = new LinkedList<Integer>();
		expected.addElement(12);
		expected.addElement(13);
		expected.addElement(22);
		
		assertEquals(linkedList.getElement(0), expected.getElement(0));
		assertEquals(linkedList.getElement(1), expected.getElement(1));
		assertEquals(linkedList.getElement(2), expected.getElement(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getElementException(){
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		
		linkedList.getElement(3);
		
	}
	
	@Test
	public void removeElementPass(){
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		
		linkedList.removeByIndex(1);
		Integer expected = 13;
		assertEquals(expected, linkedList.getElement(1));
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeElementException(){
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		
		linkedList.removeByIndex(3);

		
	}
	
	@Test
	public void removeByValuePass(){
		
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		linkedList.addElement(14);
		linkedList.addElement(22);
		linkedList.addElement(22);
		
		linkedList.removeByValue(22);
		
		LinkedList<Integer> expected = new LinkedList<Integer>();
		expected.addElement(12);
		expected.addElement(13);
		expected.addElement(14);
		
		assertEquals(expected.getElement(0), linkedList.getElement(0));
		assertEquals(expected.getElement(1), linkedList.getElement(1));
		assertEquals(expected.getElement(1), linkedList.getElement(1));
		

		
		
	}

}
