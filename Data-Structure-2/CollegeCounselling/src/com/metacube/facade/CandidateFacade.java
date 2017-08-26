package com.metacube.facade;

import com.metacube.dao.InMemoryCandidateDAO;
import com.metacube.entity.Candidate;
import com.metacube.queue.Queue;
/**
 * Candidate Facade to handle calculations related to candidates
 * @author Mahesh Chouhan
 *
 */
public class CandidateFacade {

	private static CandidateFacade candidateFacade;

	private CandidateFacade() {

	}

	/**
	 * Ensures only single instance of CandidateFacade is created
	 * @return Instance of CandidateFacade
	 */
	public static CandidateFacade getInstance() {
		if (candidateFacade == null) {
			synchronized (CandidateFacade.class) {
				if (candidateFacade == null) {
					candidateFacade = new CandidateFacade();
				}

			}
		}
		return candidateFacade;
	}

	/**
	 * Get Queue of Candidates from DAO
	 */
	public Queue<Candidate> getCandidateQueue() {
		return InMemoryCandidateDAO.getInstance().read();
	}
}
