package com.metacube.entity;

/**
 * College class for each college
 * 
 * @author Mahesh Chouhan
 *
 */
public class College implements BaseEntity, Comparable<College> {

	private String name;
	private int rank;
	private int noOfSeats;

	public College(String collegeName, int rank, int noOfSeats) {
		this.name = collegeName;
		this.rank = rank;
		this.noOfSeats = noOfSeats;

	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public int getNofOfSeats() {

		return noOfSeats;

	}

	public void setNofOfSeats(int nofOfSeats) {

		this.noOfSeats = nofOfSeats;

	}

	/**
	 * Compare Colleges on the basis of rank
	 */
	@Override
	public int compareTo(College college) {
		if (this.getRank() > college.getRank()) {
			return 1;
		} else if (this.getRank() < college.getRank()) {
			return -1;
		}

		return 0;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	/**
	 * Decrease nofSeats when a seat is assigned to candidate
	 */
	public void decreaseNoOfSeats() {
		this.noOfSeats--;
	}

}
