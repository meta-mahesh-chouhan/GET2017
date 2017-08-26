package com.metacube.dao;

import com.metacube.entity.Candidate;
import com.metacube.queue.Queue;
import com.metacube.util.FileHandling;

/**
 * Stores the all the Candidates in a Queue
 * 
 * @author Mahesh Chouhan
 *
 */
public class InMemoryCandidateDAO implements CandidateDAO {

	private static Queue<Candidate> queueOfCandidates;
	private static InMemoryCandidateDAO inMemoryCandidateDAO;

	private InMemoryCandidateDAO() {
		//Read Candidate list file and store in Queue
		createFromFile();
	}

	/**
	 * Ensures only single Instance is created
	 * @return Instance of DAO
	 */
	public static InMemoryCandidateDAO getInstance() {

		if (inMemoryCandidateDAO == null) {
			synchronized (InMemoryCandidateDAO.class) {

				if (inMemoryCandidateDAO == null) {
					inMemoryCandidateDAO = new InMemoryCandidateDAO();
				}
			}
		}
		return inMemoryCandidateDAO;
	}

	@Override
	public void create(Candidate t) {
		queueOfCandidates.enqueue(t);
	}

	@Override
	public void update(Candidate t) {

	}

	@Override
	public void delete(Candidate t) {
		queueOfCandidates.dequeue();

	}

	/**
	 * Read Candidate list and store in Queue
	 */
	public void createFromFile() {
		
		queueOfCandidates = FileHandling.readCandidateFile();
	}

	/**
	 * Return Queue storing Candidates
	 */
	@Override
	public Queue<Candidate> read() {

		return queueOfCandidates;
	}


}
