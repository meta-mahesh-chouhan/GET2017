package com.metacube.shoppingcart.dao;

import java.io.Serializable;


public interface BaseDao<T, ID extends Serializable>
{
	T findOne(ID primaryKey);
	Iterable<T> findAll();
	void delete(T entity);
	boolean exists(ID primaryKey);
}
