package entity;


/**
 * Employee class to store employee information
 * @author Mahesh Chouhan
 *
 */
public class Employee implements Comparable<Employee> {

	private Integer employeeId;
	private String name;
	private String address;
	
	public Employee(Integer employeeId , String name , String address){
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * CompareTo for natural ordering
	 */
	@Override
	public int compareTo(Employee employee) {

		return this.getEmployeeId().compareTo(employee.getEmployeeId());
	}

	
	@Override
	public String toString() {
		return getEmployeeId()+" "+getName()+" "+getAddress();
	}
	
	
	@Override
	public int hashCode() {
		
		int hash = 17;
		hash = 31 * hash + ((employeeId == null) ? 0 : employeeId.hashCode());
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		//If object is compared with itself
		if (this == object)
			return true;
		
		//If object is null
		if (object == null)
			return false;
		
		//If object is not an instance of Employee class
		if (!(object instanceof Employee))
			return false;
		
		//Typecast object to Employee class so that we can compare employee Id
		Employee other = (Employee) object;
		
		//If employeeId of first object is null and other object is not
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			//If employee Id's of both object is not same
			return false;
		
		//If name of first object is null and other object is not
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			//If name of both object is not same
			return false;

		//If address of first object is null and other object is not
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			//If name of both object is not same
			return false;
		
		
		
		return true;
	}
	
	
}
