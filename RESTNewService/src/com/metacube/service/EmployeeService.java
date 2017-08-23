package com.metacube.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.metacube.dao.EmployeeDAO;
import com.metacube.entity.Employee;

/**
 * Provides all the services related to addition, removal and retrival of employees.
 * 
 * @author User19
 *
 */
@Path("/EmployeeService")
public class EmployeeService {

	EmployeeDAO dao = EmployeeDAO.getInstance();

	/**
	 * Service method to get list of all employees
	 * 
	 * @return Result in XML format
	 */
	@GET
	@Path("/getAllEmployees")
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
	@Path("/addEmployee/{id},{name},{age}")
	@Produces(MediaType.TEXT_PLAIN)
	public String addEmployee(@PathParam("id") int id,
			@PathParam("name") String name, @PathParam("age") int age) {

		return dao.addUser(id, name, age);
	}

	/**
	 * Write changes to details.json
	 * 
	 * @return String representing status 
	 */
	@POST
	@Path("/writeToFile")
	@Produces(MediaType.TEXT_PLAIN)
	public String writeToFile() {
		return dao.writeToFile();
	}

	/**
	 * Service method to get employee by id.
	 * 
	 * @param id
	 * @return Result in XML format
	 */
	@GET
	@Path("/getEmployeeById/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public Object getEmployeeById(@PathParam("id") String id) {
		
	
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
	@Path("/getEmployeeByName/{name}")
	@Produces(MediaType.APPLICATION_XML)
	public List<Employee> getEmployeeByName(@PathParam("name") String name) {

			return dao.getEmployeeByName(name);

	}
	
	/**
	 * Service method to delete employee by id
	 * @param id
	 * @return String representing status
	 */
	@POST
	@Path("/deleteEmployeeById/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteEmployeeById(@PathParam("id") int id) {

		return dao.deleteEmployeeById(id);
	}
}
