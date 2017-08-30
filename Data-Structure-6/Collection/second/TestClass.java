package second;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

import static org.junit.Assert.*;
import entity.Employee;
import second.Collection;

public class TestClass {

	/**
	 * Sorting different employee in collection
	 */
	@Test
	public void sortingByNamePass1() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(1003, "Lokesh", "University Road");
		assertEquals(expected, list.get(0));
	}

	/**
	 * Adding employee with null ids
	 */
	@Test
	public void sortingByNamePass2() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(null, "Lokesh", "University Road"));
		collection.add(new Employee(null, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(null, "Lokesh", "University Road");
		assertEquals(expected, list.get(0));
	}

	/**
	 * Adding employee with same name
	 */
	@Test
	public void sortingByNamePass3() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Lokesh", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(1003, "Lokesh", "University Road");
		assertEquals(expected, list.get(0));
	}

	/**
	 * Adding same employee multiple times
	 */
	@Test
	public void sortingByNamePass4() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(1001, "Yogender", "Badi Peepli");
		assertEquals(expected, list.get(0));
	}

	/**
	 * Adding null in collection
	 */
	@Test(expected = NullPointerException.class)
	public void sortingByNameException1() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(null);
		collection.add(null);
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();

	}

	/**
	 * Adding employee with null name
	 */
	@Test(expected = NullPointerException.class)
	public void sortingByNameException2() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, null, "Choti Peepli"));
		collection.add(new Employee(1002, null, "Pratap Nagar"));
		collection.add(new Employee(1003, null, "University Road"));
		collection.add(new Employee(1005, "Yogender", "Badi Peepli"));

		collection.sort();

	}

	/**
	 * Adding no employee
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void sortingByNameException3() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.sort();
		List<Employee> list = collection.getArrayList();

		assertNull(list.get(0));
	}

	/**
	 * Remove employee at given index
	 */
	@Test
	public void removePass() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		collection.remove(0);

		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(1004, "Mahesh", "Pratap Nagar");
		assertEquals(expected, list.get(0));
	}

	/**
	 * Remove employee at given index - Fail
	 */
	@Test
	public void removeFail() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		collection.remove(0);

		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(1001, "Lokesh", "University Road");
		assertNotEquals(expected, list.get(0));
	}

	/**
	 * Sorting different employee - Fail
	 */
	@Test
	public void sortingByNameFail() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();

		Employee expected = new Employee(1001, "Mahesh", "Pratap Nagar");

		assertNotEquals(expected, list.get(0));
	}
	
	/**
	 * Tearator Test Pass
	 */
	@Test
	public void iteratorPass(){
		
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		
		
		Employee expected = new Employee(1004, "Mahesh", "Pratap Nagar");
		
		Iterator<Employee> iterator = collection.iterator();
		
		assertEquals(expected, iterator.next());
		
	}
	
	
	/**
	 * Iterator Test Fail
	 */
	@Test
	public void iteratorFail(){
		
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		
		
		Employee expected = new Employee(1002, "Udit", "Pratap Nagar");
		
		Iterator<Employee> iterator = collection.iterator();
		
		assertNotEquals(expected, iterator.next());
		
	}
	
	/**
	 * Iterator for empty collection
	 */
	@Test(expected = NoSuchElementException.class)
	public void iteratorException(){
		
		Collection<Employee> collection = new Collection<Employee>();

		Iterator<Employee> iterator = collection.iterator();
		
		iterator.next();
		
	}

}
