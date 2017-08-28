import java.util.Iterator;

import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Test class for SortedLinkedList
 * @author Mahesh Chouhan
 *
 */
public class SortedLinkedListTest {

	@Test
	public void addElementPass() {

		SortedLinkedList<Integer> linkedList = new SortedLinkedList<Integer>();

		linkedList.add(3);
		linkedList.add(4);
		linkedList.add(5);
		linkedList.add(2);
		linkedList.add(1);

		assertEquals(Integer.valueOf(1), linkedList.getFirst());
	}

	@Test
	public void isEmptyPass() {

		SortedLinkedList<Integer> linkedList = new SortedLinkedList<>();
		assertTrue(linkedList.isEmpty());
	}

	@Test
	public void isEmptyFail() {

		SortedLinkedList<Integer> linkedList = new SortedLinkedList<>();

		linkedList.add(12);
		linkedList.add(14);
		linkedList.add(15);

		assertFalse(linkedList.isEmpty());

	}

	@Test
	public void iteratorPass() {

		SortedLinkedList<Integer> linkedList = new SortedLinkedList<Integer>();
		linkedList.add(12);
		linkedList.add(14);
		linkedList.add(15);

		Iterator<Integer> iterator = linkedList.iterator();

		assertEquals(Integer.valueOf(12), iterator.next());

	}

	@Test
	public void iteratorFail() {

		SortedLinkedList<Integer> linkedList = new SortedLinkedList<Integer>();
		linkedList.add(12);
		linkedList.add(14);
		linkedList.add(15);

		Iterator<Integer> iterator = linkedList.iterator();

		assertNotEquals(Integer.valueOf(14), iterator.next());

	}

	@Test
	public void printPass() {

		SortedLinkedList<Integer> linkedList = new SortedLinkedList<Integer>();
		linkedList.add(12);
		linkedList.add(14);
		linkedList.add(15);

		String expected = "12\n14\n15\n";

		assertEquals(expected, linkedList.print());
	}

	@Test
	public void printFail() {

		SortedLinkedList<Integer> linkedList = new SortedLinkedList<Integer>();
		linkedList.add(12);
		linkedList.add(14);
		linkedList.add(15);

		String expected = "12\n40\n15\n";

		assertNotEquals(expected, linkedList.print());
	}

}
