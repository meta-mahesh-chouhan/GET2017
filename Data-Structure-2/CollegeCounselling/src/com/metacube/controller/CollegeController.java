package com.metacube.controller;

import java.util.List;

import com.metacube.entity.College;
import com.metacube.facade.CollegeFacade;

/**
 * CollegeController act as interface between College Facade and View Layer
 * 
 * @author Mahesh Chouhan
 *
 */
public class CollegeController {

	private static CollegeController collegeController;

	private CollegeController() {

	}

	/**
	 * Ensure only single instance of CollegeController is created
	 * @return Instance of CollegeController
	 */
	public static CollegeController getInstance() {
		if (collegeController == null) {
			synchronized (CollegeController.class) {
				if (collegeController == null) {
					collegeController = new CollegeController();
				}
			}
		}
		return collegeController;
	}

	/**
	 * Returns List of all the colleges
	 */
	public List<College> getCollegeList() {

		return CollegeFacade.getInstance().getCollegeList();

	}

	/**
	 * Returns index of college in the list from college name
	 */
	public int getIndexByCollegeName(String collegeName) {

		return CollegeFacade.getInstance().getIndexByCollegeName(collegeName);

	}
}
