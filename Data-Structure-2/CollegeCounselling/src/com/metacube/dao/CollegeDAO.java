package com.metacube.dao;

import java.util.List;

import com.metacube.entity.College;
/**
 * College DAO for college entity
 * @author Mahesh Chouhan
 *
 */
public interface CollegeDAO extends BaseDAO<College> {
	public List<College> read();
}
