package first;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.junit.Test;

import entity.Employee;
public class TestClass {
	
	@Test
	public void naturalSortingPass1(){
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		
		collection.sort();
		List<Employee> list = collection.getArrayList();
		
		assertEquals(Integer.valueOf(1001), list.get(0).getEmployeeId());
	}
	
	
	@Test
	public void naturalSortingFail(){
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1004, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1002, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		
		collection.sort();
		List<Employee> list = collection.getArrayList();
		
		assertNotEquals(Integer.valueOf(1002), list.get(0).getEmployeeId());
	}
	
	@Test(expected = NullPointerException.class)
	public void naturalSortingPass2(){
		Collection<Employee> collection = new Collection<Employee>();

		collection.add(null);
		collection.add(null);
		collection.add(null);
		collection.add(null);
	
		collection.sort();
		List<Employee> list = collection.getArrayList();
		
		assertEquals(Integer.valueOf(1001), list.get(0).getEmployeeId());
	}
	
	@Test
	public void naturalSortingPass3(){
		Collection<Employee> collection = new Collection<Employee>();

	
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		collection.add(new Employee(1001, "Yogender", "Badi Peepli"));
		
		collection.sort();
		List<Employee> list = collection.getArrayList();
		
		assertEquals(Integer.valueOf(1001), list.get(0).getEmployeeId());
	}
	
	
	@Test(expected = NullPointerException.class)
	public void naturalSortingPass4(){
		Collection<Employee> collection = new Collection<Employee>();


		collection.add(new Employee(null, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(null, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1001, "Lokesh", "University Road"));
		collection.add(new Employee(1002, "Yogender", "Badi Peepli"));
	
	
		collection.sort();
		List<Employee> list = collection.getArrayList();
		
		assertEquals(Integer.valueOf(1001), list.get(0).getEmployeeId());
	}

	@Test
	public void naturalSortingPass5(){
		Collection<Employee> collection = new Collection<Employee>();


		collection.add(new Employee(1004, null, "Pratap Nagar"));
		collection.add(new Employee(1003, null, "Pratap Nagar"));
		collection.add(new Employee(1001, null, "University Road"));
		collection.add(new Employee(1002, null, "Badi Peepli"));
	
	
		collection.sort();
		List<Employee> list = collection.getArrayList();
		
		assertEquals(Integer.valueOf(1001), list.get(0).getEmployeeId());
	}

	
}
