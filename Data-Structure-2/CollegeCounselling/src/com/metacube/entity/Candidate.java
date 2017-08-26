package com.metacube.entity;

import com.metacube.queue.Queue;

/**
 * Candidate Class for each applicant
 * 
 * @author Mahesh Chouhan
 *
 */
public class Candidate implements BaseEntity, Comparable<Candidate> {

	private String name;

	private int rank;

	private Queue<String> choices;

	private String assignedCollege;

	public Candidate(String name, int rank, Queue<String> choices) {
		this.name = name;
		this.rank = rank;
		this.choices = choices;

	}

	@Override
	public String getName() {

		return name;

	}

	@Override
	public void setName(String name) {

		this.name = name;

	}

	public Queue<String> getChoices() {

		return choices;

	}

	public void setChoices(Queue<String> choices) {

		this.choices = choices;
	}

	public int getRank() {

		return rank;

	}

	public void setRank(int rank) {

		this.rank = rank;

	}

	/**
	 * Compare candidates on the basis of rank
	 * 
	 */
	@Override
	public int compareTo(Candidate candidate) {

		if (this.getRank() > candidate.getRank()) {
			return 1;
		} else if (this.getRank() < candidate.getRank()) {
			return -1;
		}
		return this.name.compareTo(candidate.name);
	}

	public String getAssignedCollege() {
		return assignedCollege;
	}

	/**
	 * Assigns college to candidate
	 * 
	 * @param assignedCollege
	 */
	public void setAssignedCollege(String assignedCollege) {
		this.assignedCollege = assignedCollege;
	}

	@Override
	public String toString() {
		return this.getName();
	}
}
