import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TowerOfHanoiTest {

	@Test
	public void positiveTestCase1() {

		TowerOfHanoi object = new TowerOfHanoi();
		List<String> expected = new ArrayList();

		expected.add("Move Disk 1 from A to B");

		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 1);
		assertEquals(expected, actual);

	}

	@Test
	public void positiveTestCase2() {

		TowerOfHanoi object = new TowerOfHanoi();
		List<String> expected = new ArrayList();

		expected.add("Move Disk 2 from A to C");
		expected.add("Move Disk 1 from A to B");
		expected.add("Move Disk 2 from C to B");

		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 2);
		assertEquals(expected, actual);
	}

	@Test
	public void positiveTestCase3() {

		TowerOfHanoi object = new TowerOfHanoi();
		List<String> expected = new ArrayList();

		expected.add("Move Disk 3 from A to B");
		expected.add("Move Disk 2 from A to C");
		expected.add("Move Disk 3 from B to C");
		expected.add("Move Disk 1 from A to B");
		expected.add("Move Disk 3 from C to A");
		expected.add("Move Disk 2 from C to B");
		expected.add("Move Disk 3 from A to B");

		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 3);
		assertEquals(expected, actual);

	}

	@Test
	public void negativeTestCase1(){
		TowerOfHanoi object = new TowerOfHanoi();
		List<String> expected = new ArrayList();

		expected.add("No disk present");
		

		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", 0);
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void negativeTestCase2(){
		TowerOfHanoi object = new TowerOfHanoi();
		List<String> expected = new ArrayList();

		expected.add("No disk present");
		

		List<String> actual = object.towerOfHanoiUtil("A", "B", "C", -1);
		assertEquals(expected, actual);
		
	}
}
