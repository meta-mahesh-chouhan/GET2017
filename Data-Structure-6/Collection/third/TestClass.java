package third;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

import third.Employee;

public class TestClass {

	/**
	 * Adding employee with same id
	 */
	@Test
	public void duplicateTestPass() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		// Employee with same Id is not added to set
		collection.add(new Employee(1001, "Yogender", "Choti Peepli"));

		assertEquals(4, collection.size());
	}

	/**
	 * Adding employee with same id - Fail
	 */
	@Test
	public void duplicateTestFail1() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		// Employee with same Id is not added to set
		collection.add(new Employee(1001, "Prateek", "Choti Peepli"));

		assertNotEquals(5, collection.size());
	}
	
	/**
	 * Adding same employee multiple times - Fail 
	 */
	@Test
	public void duplicateTestFail2() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));

		assertNotEquals(6, collection.size());
	}

	/**
	 * Adding null multiple times
	 */
	@Test
	public void duplicateTestPass1() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(null);

		// Employee with same Id is not added to set
		collection.add(null);

		assertEquals(4, collection.size());
	}
	
	/**
	 * Adding same employee multiple times - Pass 
	 */
	@Test
	public void duplicateTestPass2() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));

		assertEquals(1, collection.size());
	}

	/**
	 * Remove lement from set - Pass
	 */
	@Test
	public void removePass() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(null);

		collection.remove(null);

		assertEquals(3, collection.size());
	}

	/**
	 * Remove element from set - Fail
	 */
	@Test
	public void removeFail() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(null);

		collection.remove(null);

		assertNotEquals(4, collection.size());
	}
	
	/**
	 * Iterator Test Pass
	 */
	@Test
	public void iteratorPass() {

		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));

		Iterator<Employee> iterator = collection.iterator();

		assertEquals(Integer.valueOf(1002), iterator.next().getEmployeeId());

	}
	
	
	/**
	 * Iterator Test Fail
	 */
	@Test
	public void iteratorFail() {

		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));

		Iterator<Employee> iterator = collection.iterator();

		assertNotEquals(Integer.valueOf(1003), iterator.next().getEmployeeId());

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

	/**
	 * Iterator for collection with null items
	 */
	@Test
	public void iteratorPass1() {

		Collection<Employee> collection = new Collection<Employee>();

		collection.add(null);
		collection.add(null);
		collection.add(null);

		Iterator<Employee> iterator = collection.iterator();

		assertNull(iterator.next());

	}
}
