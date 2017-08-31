package first;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

import entity.Employee;

public class TestClass {

	/**
	 * Adding all different employee
	 */
	@Test
	public void naturalSortingPass1() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(1001, "Yogender", "Badi Peepli");

		assertEquals(expected, list.get(0));
	}

	/**
	 * Adding employee with same id
	 */
	@Test
	public void naturalSortingPass2() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1001, "Yogender", "University Road"));
		collection.add(new Employee(1001, "Lokesh", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(1001, "Yogender", "University Road");

		assertEquals(expected, list.get(0));
	}

	/**
	 * Adding different employee - Fail
	 */
	@Test
	public void naturalSortingFail() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(1004, "Mahesh", "Pratap Nagar");
		assertNotEquals(expected, list.get(0));
	}

	/**
	 * Adding null in collection
	 */
	@Test(expected = NullPointerException.class)
	public void naturalSortingException1() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(null);
		collection.add(null);
		collection.add(null);
		collection.add(null);

		collection.sort();
		List<Employee> list = collection.getArrayList();

		assertEquals(Integer.valueOf(1001), list.get(0).getEmployeeId());
	}

	/**
	 * Adding same employee multiple times
	 */
	@Test
	public void naturalSortingPass3() {
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
	 * Adding employee with null id
	 */
	@Test(expected = NullPointerException.class)
	public void naturalSortingException2() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(null, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(null, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1001, "Lokesh", "University Road"));
		collection.add(new Employee(1002, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();

		assertEquals(Integer.valueOf(1001), list.get(0).getEmployeeId());
	}

	/**
	 * Adding no employee
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void naturalSortingException3() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.sort();
		List<Employee> list = collection.getArrayList();

		assertNull(list.get(0));
	}

	/**
	 * Adding employee with null names
	 */
	@Test
	public void naturalSortingPass4() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, null, "Pratap Nagar"));
		collection.add(new Employee(1003, null, "Pratap Nagar"));
		collection.add(new Employee(1001, null, "University Road"));
		collection.add(new Employee(1002, null, "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();
		Employee expected = new Employee(1001, null, "University Road");

		assertEquals(expected, list.get(0));
	}

	/**
	 * Remove employee by index
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
		Employee expected = new Employee(1002, "Udit", "Pratap Nagar");

		assertEquals(expected, list.get(0));
	}

	/**
	 * Remove employee by index - Fail
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
		Employee expected = new Employee(1001, "Yogender", "Badi Peepli");

		assertNotEquals(expected, list.get(0));
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
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		Employee expected = new Employee(1004, "Mahesh", "Pratap Nagar");

		Iterator<Employee> iterator = collection.iterator();

		assertEquals(expected, iterator.next());

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
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		Employee expected = new Employee(1002, "Udit", "Pratap Nagar");

		Iterator<Employee> iterator = collection.iterator();

		assertNotEquals(expected, iterator.next());

	}

	/**
	 * Iterator for empty collection
	 */
	@Test(expected = NoSuchElementException.class)
	public void iteratorException() {

		Collection<Employee> collection = new Collection<Employee>();

		Iterator<Employee> iterator = collection.iterator();

		iterator.next();

	}

}
