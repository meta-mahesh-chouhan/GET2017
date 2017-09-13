package com.metacube.entity;

/**
 * Title class to hold title table data
 * 
 * @author Mahesh Chouhan
 *
 */
public class Title {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + publisherId;
		result = prime * result + subjectId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Title other = (Title) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (publisherId != other.publisherId)
			return false;
		if (subjectId != other.subjectId)
			return false;
		return true;
	}

	private int id;
	private String name;
	private int subjectId;
	private int publisherId;

	public Title(int id, String name, int subjectId, int publisherId) {
		this.id = id;
		this.name = name;
		this.subjectId = subjectId;
		this.publisherId = publisherId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	
	@Override
	public String toString() {
		return id+" "+name+" "+subjectId+" "+publisherId;
	}
}
