package com.metacube.dao;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.metacube.entity.Employee;

public class EmployeeDAO {
	private String filePath = "C:/Users/User19/workspace/RESTNewService/details.json";
	private List<Employee> listOfEmployee = new ArrayList<Employee>();
	private static EmployeeDAO employeeDAO;

	private EmployeeDAO() {

	}

	public static EmployeeDAO getInstance() {

		if (employeeDAO == null) {
			synchronized (EmployeeDAO.class) {

				if (employeeDAO == null) {
					employeeDAO = new EmployeeDAO();
				}

			}
		}

		return employeeDAO;

	}

	@SuppressWarnings("unchecked")
	public List<Employee> readFile() {

		try {

			JSONParser parser = new JSONParser();

			JSONArray jsonArray = (JSONArray) parser.parse(new FileReader(
					filePath));

			JSONObject object = null;

			Iterator<JSONObject> iterator = jsonArray.iterator();

			while (iterator.hasNext()) {
				object = iterator.next();
				listOfEmployee.add(new Employee(Integer.parseInt(object.get("id").toString()), (String) object.get("name"), Integer.parseInt(object.get("age").toString())));

			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return listOfEmployee;
	}

	public String addUser(int id, String name, int age) {

		listOfEmployee.add(new Employee(id, name, age));

		return "Employee Successfully Added !";

	}

	public String writeToFile() {

		ObjectMapper objectMapper = new ObjectMapper();
		File file = new File(filePath);

		try {
			objectMapper.writeValue(file, listOfEmployee);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "Data Successfully Written !";

	}

	public List<Employee> getListOfEmployee() {

		if (listOfEmployee.isEmpty()) {
			readFile();
		}
		return listOfEmployee;
	}

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

	public String deleteEmployeeById(int id) {

		Employee employee = getEmployeeById(id);
		if (employee != null) {
			listOfEmployee.remove(employee);
			return "Employee Successfully Removed !";
		}

		return "Employee Not Found";

	}

}
