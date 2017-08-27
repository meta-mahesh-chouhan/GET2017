package com.metacube.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.metacube.controller.CollegeController;
import com.metacube.entity.Candidate;
import com.metacube.entity.College;
import com.metacube.queue.Queue;
/**
 * Handles all the calculations related to Counseling
 * @author Mahesh Chouhan
 *
 */
public class CounsellingFacade {
	private static CounsellingFacade counsellingFacade;

	/**
	 * Ensures only single instance of CounsellingFacade is created
	 * @return Instance of CounsellingFacade
	 */
	public static CounsellingFacade getInstance() {
		if (counsellingFacade == null) {
			synchronized (CounsellingFacade.class) {
				if (counsellingFacade == null) {
					counsellingFacade = new CounsellingFacade();
				}
			}
		}
		return counsellingFacade;
	}

	/**
	 * Performs Counseling
	 * @return List containing name of students who have been assigned college
	 */
	@SuppressWarnings("resource")
	public List<Candidate> getCounsellingResults() {
		Queue<Candidate> candidateQueue = CandidateFacade.getInstance().getCandidateQueue();

		List<College> listOfCollege = CollegeController.getInstance().getCollegeList();

		List<Candidate> result = new ArrayList<Candidate>();
		
		int count = 1;

		//Traversing until all the candidates in Queue are assigned college
		while (!candidateQueue.isEmpty()) {

			int loopIndex = 0;
			int size = candidateQueue.getSize();
			
			//Traversing for all unassigned candidates
			while (loopIndex <= size && candidateQueue.peek() != null) {
			
				Candidate candidate = candidateQueue.dequeue();
				Queue<String> choices = candidate.getChoices();

				int index = -1;
				if (choices.peek() != null) {
					index = CollegeController.getInstance().getIndexByCollegeName(choices.peek());
				}
				
				//While no of seats in desired college is less than or equal to zero,pop choices.
				while (choices.peek() != null && listOfCollege.get(index).getNofOfSeats() <= 0) {
					choices.dequeue();
					index = CollegeController.getInstance().getIndexByCollegeName(choices.peek());
				}
				//After completion of above loop choices contains available college at top of Queue
				
				boolean flag = true;
				
				//loop for taking input
				while (!choices.isEmpty() && flag) {
					System.out.println(candidate + " ,do you want "+ choices.peek() + " college ?(Y/N)");
					String s = new Scanner(System.in).nextLine();
					
					if (s.equalsIgnoreCase("y")) {
						//If Candidate want assigned college then dequeue college name from choices
						choices.dequeue();
						//Decrease no of seats in choose college
						listOfCollege.get(index).decreaseNoOfSeats();
						
						candidate.setAssignedCollege(listOfCollege.get(index).getName());
						//Add assigned candidate name in result list
						result.add(candidate);
						//break the loop
						flag = false;
					} else if (s.equalsIgnoreCase("n")) {
						//If candidate doesn't want assigned college,enqueue it again
						candidateQueue.enqueue(candidate);
						//break the loop
						flag = false;
					} else {
						//Continue loop until Candidate enter Y or N
						System.out.println("Enter either Y or N");
					}

				}

				loopIndex++;
			}
			
			//Display result after each round
			if (!candidateQueue.isEmpty()) {
				System.out.println("***************** RESULT AFTER ROUND "+ (count++) + " *******************");
				for (Candidate candi : result) {
					System.out.println(candi.getName() + " is assigned "+ candi.getAssignedCollege());
				}
			}
		}

		return result;
	}

}
