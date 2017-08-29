package second;

import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import entity.Employee;

public class TestClass {

	@Test
	public void sortingByNamePass() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();
		assertEquals(Integer.valueOf(1003), list.get(0).getEmployeeId());
	}

	@Test(expected = NullPointerException.class)
	public void sortingByNamePass1() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(null);
		collection.add(null);
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();

		assertEquals(Integer.valueOf(1003), list.get(0).getEmployeeId());
	}

	@Test(expected = NullPointerException.class)
	public void sortingByNamePass2() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, null, "Choti Peepli"));
		collection.add(new Employee(1002, null, "Pratap Nagar"));
		collection.add(new Employee(1003, null, "University Road"));
		collection.add(new Employee(1005, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();

		assertEquals(Integer.valueOf(1003), list.get(0).getEmployeeId());
	}

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

		assertEquals(Integer.valueOf(1004), list.get(0).getEmployeeId());
	}

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

		assertNotEquals(Integer.valueOf(1003), list.get(0).getEmployeeId());
	}

	@Test
	public void sortingByNameFail() {
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));

		collection.sort();
		List<Employee> list = collection.getArrayList();

		assertNotEquals(Integer.valueOf(1004), list.get(0).getEmployeeId());
	}

}
