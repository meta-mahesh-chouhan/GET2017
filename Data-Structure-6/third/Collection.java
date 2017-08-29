package third;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import entity.Employee;

/**
 * Collection class to store list of employees
 * 
 * @author Mahesh Chouhan
 * @param <T>
 */
public class Collection<T> implements Iterable<T> {

	private Set<T> set;

	public Collection() {
		set = new HashSet<T>();
	}

	/**
	 * Add given element to set
	 * 
	 * @param element
	 */
	public void add(T element) {
		set.add(element);
	}

	/**
	 * Remove given element from set
	 * 
	 * @param elment
	 */
	public void remove(T elment) {
		set.remove(elment);
	}

	/**
	 * Returns iterator to collection
	 */
	@Override
	public Iterator<T> iterator() {
		return set.iterator();
	}
	
	
	
	public Set<T> getSet(){
		return set;
	}
	/**
	 * Main function which drives all the functionality
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1001, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1005, "Prateek", "Mansarovar"));
		collection.add(new Employee(1002, "Lokesh", "University Road"));
		collection.add(new Employee(1002, "Yogender", "Badi Peepli"));

		Iterator<Employee> employee = collection.iterator();

		while (employee.hasNext()) {
			System.out.println(employee.next());
		}

	}
	/**
	 * Returns size of collection
	 * @return
	 */
	public int size(){
		return set.size();
	}


}
