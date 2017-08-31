package first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import entity.Employee;
/**
 * Collection class to store list of employees
 * 
 * @author Mahesh Chouhan
 * @param <T>
 */
class Collection<T extends Comparable<T>> implements Iterable<T> {

	private ArrayList<T> arrayList;

	public Collection() {
		setArrayList(new ArrayList<T>());
	}

	public ArrayList<T> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<T> arrayList) {
		this.arrayList = arrayList;
	}

	/**
	 * Sorts the list in natural order
	 */
	public void sort() {
		Collections.sort(arrayList);
	}

	/**
	 * Add new element to list
	 * @param element
	 */
	public void add(T element) {
		arrayList.add(element);
	}

	/**
	 * Remove element at given index
	 * @param index
	 */
	public void remove(int index) {
		arrayList.remove(index);
	}

	/**
	 * Returns an iterator to list
	 */
	@Override
	public Iterator<T> iterator() {
		return arrayList.iterator();
	}

	/**
	 * Main function which drives all the functionality
	 * @param args
	 */
	public static void main(String[] args) {

		Collection<Employee> collection = new Collection<Employee>();

		collection.add(new Employee(1001, "Mahesh", "Pratap Nagar"));
		collection.add(new Employee(1004, "Udit", "Pratap Nagar"));
		collection.add(new Employee(1003, "Lokesh", "University Road"));
		collection.add(new Employee(1002, "Yogender", "Badi Peepli"));

		Iterator<Employee> employee = collection.iterator();
		System.out.println("**********************Before Natual Sorting**********************");
		while (employee.hasNext()) {
			System.out.println(employee.next());
		}

		collection.sort();

		System.out.println("**********************After Natural Sorting**********************");
		employee = collection.iterator();

		while (employee.hasNext()) {
			System.out.println(employee.next());
		}

	}

}
