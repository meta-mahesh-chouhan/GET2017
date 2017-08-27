package com.metacube.entity;

import com.metacube.enums.JobPriority;

/**
 * Job class for each job
 * 
 * @author Mahesh Chouhan
 *
 */
public class Job implements Comparable<Job> {

	private String job;
	private JobPriority priority;

	public Job(String job, JobPriority priority) {
		this.job = job;
		this.priority = priority;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public JobPriority getPriority() {
		return priority;
	}

	public void setPriority(JobPriority priority) {
		this.priority = priority;
	}

	@Override
	public int compareTo(Job job) {

		if (this.getPriority().getPriority() > job.getPriority().getPriority()) {
			return 1;
		} else if (this.getPriority().getPriority() < job.getPriority().getPriority()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return job.toString();
	}

}
