package com.metacube.controller;

import com.metacube.entity.Candidate;
import com.metacube.facade.CandidateFacade;
import com.metacube.queue.Queue;
/**
 * Candidate controller act as interface between Candidate Facade and View Layer
 * @author Mahesh Chouhan
 *
 */
public class CandidateController {
	private static CandidateController candidateController;

	private CandidateController() {

	}

	/**
	 * Ensure only single instance of CandidateController is created
	 * @return Instance of CandidateController
	 */
	public static CandidateController getInstance() {
		if (candidateController == null) {
			synchronized (CandidateController.class) {
				if (candidateController == null) {
					candidateController = new CandidateController();
				}
			}
		}
		return candidateController;
	}

	/**
	 * Get Queue of all the Candidates for counselling
	 * @return Queue of candidates
	 */
	public Queue<Candidate> getCandidateQueue() {

		return CandidateFacade.getInstance().getCandidateQueue();
	}

}
