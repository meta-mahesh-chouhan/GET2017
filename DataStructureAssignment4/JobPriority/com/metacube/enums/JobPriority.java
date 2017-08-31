package com.metacube.enums;

public enum JobPriority {

	CHAIRMAN(4), PROFESSOR(3), GRADUATE(2), UNDER_GRADUATE(1);

	private int priority;

	private JobPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}
}
