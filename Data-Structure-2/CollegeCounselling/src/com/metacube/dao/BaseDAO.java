package com.metacube.dao;

import com.metacube.entity.BaseEntity;
/**
 * BaseDAO for Base Entity
 * @author Mahesh Chouhan
 * @param <T>
 */
public interface BaseDAO <T extends BaseEntity > {
	
	public void create(T t);
	public void update(T t);
	public void delete(T t);


}
