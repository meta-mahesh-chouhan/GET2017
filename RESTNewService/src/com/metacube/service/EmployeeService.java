package com.metacube.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;

import com.metacube.dao.EmployeeDAO;
import com.metacube.entity.Employee;

/**
 * Provides all the services related to addition, removal and retrival of employees.
 * 
 * @author User19
 *
 */
@Path("/employeeservice")
public class EmployeeService {

	EmployeeDAO dao = EmployeeDAO.getInstance();

	/**
	 * Service method to get list of all employees
	 * 
	 * @return Result in XML format
	 */
	@GET
	@Path("/getallemployees")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> getAllEmployee() {

		return dao.getListOfEmployee();
	}

	/**
	 * Service method to add employee 
	 * @param id
	 * @param name
	 * @param age
	 * @return String representing status
	 */
	@POST
	@Path("/addemployee")
	@Produces(MediaType.TEXT_PLAIN)
	public String addEmployee(@QueryParam("id") int id,@QueryParam("name") String name, @QueryParam("age") int age) {

		return dao.addUser(id, name, age);
	}

	/**
	 * Service method to get employee by id.
	 * 
	 * @param id
	 * @return Result in XML format
	 */
	@GET
	@Path("/getemployeebyid")
	@Produces(MediaType.APPLICATION_XML)
	public Object getEmployeeById(@QueryParam("id") String id) {
		
	
		try{
		Employee employee = dao.getEmployeeById(Integer.parseInt(id));

		if (employee != null)
			return employee;
		else
			return "Employee Not found !";
		
		}
		catch(NumberFormatException e){
			return "Input integer value";
		}
	}

	/**
	 * Service method to get employee by name
	 * @param name
	 * @return Result in XML format
	 */
	@GET
	@Path("/getemployeebyname")
	@Produces(MediaType.TEXT_PLAIN)
	public String getEmployeeByName(@QueryParam("name") String name) {

		List<Employee> listOfEmployees = dao.getEmployeeByName(name);
		
		if(listOfEmployees.isEmpty()){
			return "No such Employee present !";
		}
		JSONArray array =  new JSONArray(listOfEmployees);

			try {
				return array.toString(3);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
	}
	
	/**
	 * Service method to delete employee by id
	 * @param id
	 * @return String representing status
	 */
	@POST
	@Path("/deleteemployeebyid")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployeeById(@QueryParam("id") int id) {

		return dao.deleteEmployeeById(id);
		
	}
}
