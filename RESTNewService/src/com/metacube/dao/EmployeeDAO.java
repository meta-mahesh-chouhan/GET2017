package com.metacube.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.metacube.entity.Employee;
/**
 * DAO for Employee Class
 * @author Mahesh Chouhan
 *
 */
public class EmployeeDAO {
	
	private static String filePath = "C:/Users/User19/workspace/RESTNewService/details.json";
	private List<Employee> listOfEmployee = new ArrayList<Employee>();
	private static EmployeeDAO employeeDAO;
	private static PrintWriter out;

	private EmployeeDAO() {

	}
	/**
	 * Ensures only single instance of class is created
	 * 
	 * @return Instance of class
	 */
	public static EmployeeDAO getInstance(){

		if (employeeDAO == null) {
			synchronized (EmployeeDAO.class) {

				if (employeeDAO == null) {
					employeeDAO = new EmployeeDAO();
				
				}

			}
		}

		return employeeDAO;

	}

	/**
	 * Read List of employees from file
	 * @return List of employees 
	 */ 
	public List<Employee> readFile() {

		try {

			JSONParser parser = new JSONParser();

			List<String> lines = Files.readAllLines(Paths.get(filePath));

			JSONObject object = null;

			Iterator<String> iterator = lines.iterator();

			while (iterator.hasNext()) {
				object = (JSONObject) parser.parse(iterator.next());
				listOfEmployee.add(new Employee(Integer.parseInt(object.get("id").toString()), (String) object.get("name"), Integer.parseInt(object.get("age").toString())));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return listOfEmployee;
	}

	/**
	 * Add new user in lisOfEmployee
	 * @param id
	 * @param name
	 * @param age
	 * @return
	 */
	public String addUser(int id, String name, int age) {
		
		Employee newEmployee = new Employee(id, name, age);
		listOfEmployee.add(newEmployee);
		writeToFile(newEmployee);
		return "Employee Successfully Added !";

	}

	/**
	 * Writes new employee to the file
	 * @param newEmployee
	 */
	public String writeToFile(Employee newEmployee) {
	
		ObjectMapper objectMapper = new ObjectMapper();
		try {

			out  = new PrintWriter(new BufferedWriter(new FileWriter(filePath, true)));
			//Writes only new employee to existing file
			String jsonString = objectMapper.writeValueAsString(newEmployee);
			out.println(jsonString);
			out.close();
				
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return "Data Successfully Written !";

	}

	/**
	 * Returns list of all the employees
	 * @return List of employees
	 */
	public List<Employee> getListOfEmployee() {

		if (listOfEmployee.isEmpty()) {
			readFile();
		}
		return listOfEmployee;
	}

	/**
	 * Get employee object by employee id
	 * @param id
	 * @return Employee object with given id
	 */
	public Employee getEmployeeById(int id) {

		if (listOfEmployee.isEmpty()) {
			readFile();
		}
		for (Employee employee : listOfEmployee) {

			if (employee.getId() == id) {
				return employee;
			}
		}

		return null;

	}

	/**
	 * Get list of employees by name
	 * @param name
	 * @return List of employees with given name
	 */
	public List<Employee> getEmployeeByName(String name) {

		if (listOfEmployee.isEmpty()) {
			readFile();
		}

		List<Employee> resultListOfEmployee = new ArrayList<Employee>();

		for (Employee employee : listOfEmployee) {

			if (employee.getName().equals(name)) {
				resultListOfEmployee.add(employee);
			}
		}

		return resultListOfEmployee;

	}

	/**
	 * Delete employee by Id
	 * @param id
	 * @return String showing status
	 */
	public String deleteEmployeeById(int id) {

		Employee employee = getEmployeeById(id);
		if (employee != null) {
			listOfEmployee.remove(employee);
			writeCompleteFile();
			return "Employee Successfully Removed !";
		}

		return "Employee Not Found";

	}
	
	/**
	 * Writes complete file after deleting the employee
	 */
	public void writeCompleteFile(){
		
		try {
			out  = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
			
			for(Employee employee : listOfEmployee){
				
				ObjectMapper objectMapper = new ObjectMapper();
				String jsonString = objectMapper.writeValueAsString(employee);	
				out.println(jsonString);
			
			}
			
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
