package com.metacube.dao;

import java.util.Iterator;
import java.util.List;

import com.metacube.entity.College;
import com.metacube.util.FileHandling;

/**
 * Store all the colleges in a list
 * 
 * @author Mahesh Chouhan
 *
 */
public class InMemoryCollegeDAO implements CollegeDAO {

	private static List<College> listOfCollege;
	private static InMemoryCollegeDAO inMemoryCollegeDAO;

	private InMemoryCollegeDAO() {
		//Read College list file and store in List
		createFromFile();
	}

	/**
	 * Ensures only single instance is created
	 * @return Instance of DAO
	 */
	public static InMemoryCollegeDAO getInstance() {

		if (inMemoryCollegeDAO == null) {
			synchronized (InMemoryCollegeDAO.class) {
				if (inMemoryCollegeDAO == null) {
					inMemoryCollegeDAO = new InMemoryCollegeDAO();

				}
			}
		}
		return inMemoryCollegeDAO;
	}

	@Override
	public void create(College t) {
		listOfCollege.add(t);

	}

	public void createFromFile() {
		listOfCollege = FileHandling.readCollegeFile();
	}

	@Override
	public void update(College t) {

	}

	@Override
	public void delete(College t) {
		listOfCollege.remove(t);

	}

	/**
	 * Returns list of college
	 */
	@Override
	public List<College> read() {

		return listOfCollege;
	}

	/**
	 * Returns index of college in the list from college name
	 */
	public int getIndexByCollegeName(String collegeName) {
		Iterator<College> iterator = listOfCollege.iterator();

		while (iterator.hasNext()) {
			College college = iterator.next();

			if (college.getName().equals(collegeName)) {
				return listOfCollege.indexOf(college);
			}
		}
		return -1;
	}

}
