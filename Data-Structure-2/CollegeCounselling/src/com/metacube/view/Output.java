package com.metacube.view;

import java.util.Iterator;
import java.util.List;

import com.metacube.controller.CandidateController;
import com.metacube.controller.CollegeController;
import com.metacube.entity.Candidate;
import com.metacube.entity.College;
import com.metacube.facade.CounsellingFacade;
import com.metacube.queue.Queue;
/**
 * Handles displaying output
 * @author Mahesh Chouhan
 *
 */
public class Output {

	public static void main(String[] args) {
		
		List<College> listOfCollege = CollegeController.getInstance().getCollegeList();
		Iterator<College> iterator = listOfCollege.iterator();
	
		System.out.println("*********************** LIST OF COLLEGES ***********************");
		System.out.println("RANK\t\tNAME\t\tNo of Seats");
		System.out.println("****************************************************************");
		College college;
		while (iterator.hasNext()){
			college = iterator.next();
			System.out.println(college.getRank()+"\t\t"+college.getName()+"\t\t"+college.getNofOfSeats());
		}
		System.out.println("****************************************************************\n\n");
		
		
		Queue<Candidate> candidateQueue = CandidateController.getInstance().getCandidateQueue();
		Iterator<Candidate> queueIterator = candidateQueue.iterator();
		
		System.out.println("*********************** LIST OF CANDIDATES ***********************");
		System.out.println("Rank\t\tName\t\t\tChoices");
		System.out.println("******************************************************************");
		
		while ( queueIterator.hasNext()){
			Candidate candidate = queueIterator.next();
			System.out.println(candidate.getRank()+"\t\t"+candidate.getName()+"\t\t"+candidate.getChoices());
		}
		System.out.println("******************************************************************\n");
		
		List<Candidate> results = CounsellingFacade.getInstance().getCounsellingResults();
		
		Iterator<Candidate> resultIterator = results.iterator();
		System.out.println("*************************FINAL RESULTS**********************************");
		
		while(resultIterator.hasNext()){
			Candidate candidate = resultIterator.next();
			System.out.println(candidate.getName() +" is assigned "+candidate.getAssignedCollege());
		}
		
		
		
		
		
		
	}
}
