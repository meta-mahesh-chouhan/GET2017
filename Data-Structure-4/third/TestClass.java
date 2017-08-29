package third;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Iterator;

import org.junit.Test;

import entity.Employee;

public class TestClass {

	@Test
	public void duplicateTestPass() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		// Employee with same Id is not added to set
		collection.add(new Employee(1001, "Prateek", "Choti Peepli"));

		assertEquals(4, collection.size());
	}

	@Test
	public void duplicateTestFail() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		// Employee with same Id is not added to set
		collection.add(new Employee(1001, "Prateek", "Choti Peepli"));

		assertNotEquals(5, collection.size());
	}

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

	@Test
	public void duplicateTestFail2() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(null);

		// Employee with same Id is not added to set
		collection.add(null);

		collection.remove(null);

		assertNotEquals(4, collection.size());
	}

	@Test
	public void iteratorPass() {

		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));

		Iterator<Employee> iterator = collection.iterator();

		assertEquals(Integer.valueOf(1002), iterator.next().getEmployeeId());

	}

	@Test
	public void iteratorFail() {

		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));

		Iterator<Employee> iterator = collection.iterator();

		assertNotEquals(Integer.valueOf(1003), iterator.next().getEmployeeId());

	}

}
