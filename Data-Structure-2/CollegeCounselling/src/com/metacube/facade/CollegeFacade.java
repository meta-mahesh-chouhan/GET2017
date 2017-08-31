package com.metacube.facade;

import java.util.List;

import com.metacube.dao.DAOFactory;
import com.metacube.dao.InMemoryCollegeDAO;
import com.metacube.entity.College;
import com.metacube.enums.Entity;
/**
 * College Facade to handle calculations related to College
 * @author Mahesh Chouhan
 *
 */
public class CollegeFacade {

	private static CollegeFacade collegeFacade;

	private CollegeFacade() {

	}

	/**
	 * Ensures only single instance of CollegeFacade is created
	 * @return Instance of CollegeFacade
	 */
	public static CollegeFacade getInstance() {
		if (collegeFacade == null) {
			synchronized (CollegeFacade.class) {
				if (collegeFacade == null) {
					collegeFacade = new CollegeFacade();
				}

			}
		}

		return collegeFacade;
	}

	/**
	 * Returns List of college
	 */
	public List<College> getCollegeList() {

		return ((InMemoryCollegeDAO) DAOFactory.getInstance().getDAOfromFactory(Entity.College)).read();

	}

	/**
	 * Returns index of college in the list from college name
	 */
	public int getIndexByCollegeName(String collegeName) {

		return ((InMemoryCollegeDAO) DAOFactory.getInstance().getDAOfromFactory(Entity.College)).getIndexByCollegeName(collegeName);

	}

}
