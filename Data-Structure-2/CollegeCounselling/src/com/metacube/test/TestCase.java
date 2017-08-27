package com.metacube.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.metacube.entity.Candidate;
import com.metacube.entity.College;
import com.metacube.facade.CandidateFacade;
import com.metacube.facade.CollegeFacade;
import com.metacube.queue.Queue;
/**
 * Test case for College Counselling assignment
 * @author Mahesh Chouhan
 *
 */
public class TestCase {

	/**
	 * Check if candidate list is read successfully
	 */
	@Test
	public void getCandidateQueueTest(){
		
		Queue<Candidate> candidateQueue = CandidateFacade.getInstance().getCandidateQueue();
		assertEquals("Akki Channgani", candidateQueue.peek().getName());
	}
	
	/**
	 * Check if college list is read successfully
	 */
	@Test
	public void getCollegeListTest(){
		
		List<College> listOfCollege = CollegeFacade.getInstance().getCollegeList();
		assertEquals("MBM",listOfCollege.get(0).getName());
	}
	
	@Test
	public void getIndexByCollegeName(){
		
		assertEquals(4,CollegeFacade.getInstance().getIndexByCollegeName("VYAS"));
		
	}
}
