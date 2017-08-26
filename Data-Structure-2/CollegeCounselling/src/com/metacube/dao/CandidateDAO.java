package com.metacube.dao;

import com.metacube.entity.Candidate;
import com.metacube.queue.Queue;
/**
 * Candidate DAO for Canddiate entity
 * @author Mahesh Chouhan
 *
 */
public interface CandidateDAO extends BaseDAO<Candidate> {
	
	public Queue<Candidate> read();

}
