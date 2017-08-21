import static org.junit.Assert.*;

import org.junit.Test;
/**
 * Test class for ArrayList
 * @author Mahesh Chouhan
 *
 */
public class ArrayListTest {
	
	@SuppressWarnings("unused")
	@Test(expected = IllegalArgumentException.class)
	public void createArrayException(){
		ArrayList<String> arrayList = new ArrayList<String>(-1);
		
	}
	
	@Test
	public void createArray(){
		ArrayList<String> arrayList = new ArrayList<String>(3);
		
		arrayList.addElement(1,"mahesh");

		ArrayList<String> expected = new ArrayList<String>(3);
		
		expected.addElement(0,null);
		expected.addElement(1,"mahesh");
		expected.addElement(2,null);
		
		for(int i= 0 ;i<expected.getSize();i++){
			System.out.println(expected.getElement(i));
		}
		
		assertArrayEquals(expected.getArray(), arrayList.getArray());
		
	}

	@Test
	public void addElementPass() {

		ArrayList<String> arrayList = new ArrayList<String>();

		arrayList.addElement("mahesh");

		assertEquals("mahesh", arrayList.getElement(0));

	}
	


	@Test
	public void addElementIndexPass() {

		ArrayList<String> arrayList = new ArrayList<String>();

		arrayList.addElement("mahesh");
		arrayList.addElement("prateek");
		arrayList.addElement("udit");

		arrayList.addElement(1, "chouhan");

		assertEquals("chouhan", arrayList.getElement(1));

	}


	@Test
	public void clearPass() {

		ArrayList<String> arrayList = new ArrayList<String>();

		arrayList.addElement("mahesh");
		arrayList.addElement("chouhan");

		arrayList.clear();
		assertNull(arrayList.getArray());

	}


	@Test
	public void reverseTest() {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.addElement(1);
		arrayList.addElement(2);
		arrayList.addElement(3);
		arrayList.addElement(4);

		arrayList.reverse();
		ArrayList<Integer> reverseArrayList = new ArrayList<Integer>();

		reverseArrayList.addElement(4);
		reverseArrayList.addElement(3);
		reverseArrayList.addElement(2);
		reverseArrayList.addElement(1);

		assertArrayEquals(reverseArrayList.getArray(), arrayList.getArray());

	}

	@Test
	public void firstOccurrencePass() {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.addElement(1);
		arrayList.addElement(2);
		arrayList.addElement(3);
		arrayList.addElement(2);
		arrayList.addElement(4);
		arrayList.addElement(2);

		assertEquals(1, arrayList.firstOccurence(2));

	}

	@Test
	public void firstOccurrenceAfterLocationPass() {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.addElement(1);
		arrayList.addElement(2);
		arrayList.addElement(3);
		arrayList.addElement(2);
		arrayList.addElement(4);
		arrayList.addElement(2);

		assertEquals(3, arrayList.firstOccurence(2, 2));

	}

	@Test
	public void removeTest() {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.addElement(1);
		arrayList.addElement(2);
		arrayList.addElement(3);
		arrayList.addElement(4);

		arrayList.removeByIndex(2);
		Integer expected = 4;
		assertEquals(expected, arrayList.getElement(2));
	}


	@Test
	public void removeByValue() {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.addElement(1);
		arrayList.addElement(2);
		arrayList.addElement(1);
		arrayList.addElement(4);
		arrayList.addElement(1);

		arrayList.removeByValue(1);

		ArrayList<Integer> expected = new ArrayList<Integer>();

		expected.addElement(2);
		expected.addElement(4);

		assertArrayEquals(expected.getArray(), arrayList.getArray());

	}

	
	@Test
	public void sortPass() {

		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.addElement(10);
		arrayList.addElement(12);
		arrayList.addElement(20);
		arrayList.addElement(14);
		arrayList.addElement(13);

		arrayList.sort();

		ArrayList<Integer> expected = new ArrayList<Integer>();

		expected.addElement(10);
		expected.addElement(12);
		expected.addElement(13);
		expected.addElement(14);
		expected.addElement(20);

		assertArrayEquals(arrayList.getArray(), expected.getArray());

	}

	@Test
	public void getElementPass() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.addElement(10);
		arrayList.addElement(12);
		Integer expected = 12;
		assertEquals(expected, arrayList.getElement(1));

	}

	@Test(expected = IllegalArgumentException.class)
	public void getElementException() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();

		arrayList.addElement(10);
		arrayList.addElement(12);

		arrayList.getElement(2);

	}
	

	@Test
	public void addListTest(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.addElement("mahesh");
		arrayList.addElement("chouhan");
		arrayList.addElement("udit");
		arrayList.addElement("saxena");
		
		ArrayList<String> subList = new ArrayList<String>();
		
		subList.addElement("Gaurav");
		subList.addElement("tak");
	
		arrayList.addList(subList);
		
		ArrayList<String> expected = new ArrayList<String>();
		
		expected.addElement("mahesh");
		expected.addElement("chouhan");
		expected.addElement("udit");
		expected.addElement("saxena");
		expected.addElement("Gaurav");
		expected.addElement("tak");
		
		assertArrayEquals(expected.getArray(), arrayList.getArray());
		
		
		
		
		
	}

}
