package second;

import java.util.Comparator;

import entity.Employee;

/**
 * User defined comparator which compares on the basis of employee name
 * 
 * @author Mahesh Chouhan
 *
 */
@SuppressWarnings("rawtypes")
public class NameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Employee firstEmployee = (Employee) o1;
		Employee secondEmployee = (Employee) o2;

		return firstEmployee.getName().compareTo(secondEmployee.getName());
	}

}
