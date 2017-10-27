package com.metacube.shoppingcart.dao;

import java.io.Serializable;


public interface BaseDao<T, ID extends Serializable>
{
	T findOne(ID primaryKey);
	Iterable<T> findAll();
	void delete(ID primaryKey);
	void update(T entity);
	T create(T entity);
}
