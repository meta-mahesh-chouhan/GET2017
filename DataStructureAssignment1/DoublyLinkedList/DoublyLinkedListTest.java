import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class DoublyLinkedListTest {
	
	@Test
	public void createLinkedListPass(){
		
		DoublyLinkedList<String> linkedList = new DoublyLinkedList<String>();
		
		linkedList.addElement("mahesh");
		linkedList.addElement("chouhan");

		assertEquals("chouhan", linkedList.getElement(1));
		
	}
	
	@Test
	public void addElementToListIndex(){
		
		DoublyLinkedList<String> linkedList = new DoublyLinkedList<String>();
		
		linkedList.addElement("chouhan",0);

		assertEquals("chouhan", linkedList.getElement(0));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void addElementToListIndexException(){
		
		DoublyLinkedList<String> linkedList = new DoublyLinkedList<String>();
		
		linkedList.addElement("chouhan",1);

		
	}
	@Test
	public void reversalTest(){
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.addElement(1);
		linkedList.addElement(2);
		linkedList.addElement(3);
	
		linkedList.reversal();
		DoublyLinkedList<Integer> expected = new DoublyLinkedList<Integer>();
		expected.addElement(3);
		expected.addElement(2);
		expected.addElement(1);
		
		assertEquals(linkedList.getElement(0), expected.getElement(0));
		assertEquals(linkedList.getElement(1), expected.getElement(1));
		assertEquals(linkedList.getElement(2), expected.getElement(2));
		
		
	}
	
	@Test
	public void sort(){
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		
		linkedList.sort();
		DoublyLinkedList<Integer> expected = new DoublyLinkedList<Integer>();
		expected.addElement(12);
		expected.addElement(13);
		expected.addElement(22);
		
		assertEquals(linkedList.getElement(0), expected.getElement(0));
		assertEquals(linkedList.getElement(1), expected.getElement(1));
		assertEquals(linkedList.getElement(2), expected.getElement(2));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getElementException(){
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		
		linkedList.getElement(3);
		
	}
	
	@Test
	public void removeElementPass(){
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		
		linkedList.removeByIndex(0);
		Integer expected = 13;
		assertEquals(expected, linkedList.getElement(1));
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void removeElementException(){
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		
		linkedList.removeByIndex(3);

		
	}
	
	@Test
	public void removeByValuePass(){
		
		DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<Integer>();
		linkedList.addElement(12);
		linkedList.addElement(22);
		linkedList.addElement(13);
		linkedList.addElement(14);
		linkedList.addElement(22);
		linkedList.addElement(22);
		
		linkedList.removeByValue(22);
		
		DoublyLinkedList<Integer> expected = new DoublyLinkedList<Integer>();
		expected.addElement(12);
		expected.addElement(13);
		expected.addElement(14);
		
		assertEquals(expected.getElement(0), linkedList.getElement(0));
		assertEquals(expected.getElement(1), linkedList.getElement(1));
		assertEquals(expected.getElement(1), linkedList.getElement(1));
		

		
		
	}

}
