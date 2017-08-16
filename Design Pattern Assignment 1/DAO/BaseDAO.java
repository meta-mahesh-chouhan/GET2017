package DAO;

import java.util.List;

import Entity.BaseEntity;

/**
 * Base interface for all kinds of DAP
 * 
 * @author Mahesh Chouhan
 * @param <T>
 */
public interface BaseDAO<T extends BaseEntity> {

	public void create(T t);

	public List<T> getAll();

	public void update(T t);

	public void delete(T t);

}
