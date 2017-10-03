package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.metacube.shoppingcart.dto.ProductDto;


public abstract class GenericJdbcDao<T, ID extends Serializable> implements BaseDao<T,ID>
{
	
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	protected abstract String getTableName();
	protected  abstract T extractResultSetRow(ResultSet resultSet);
	protected abstract String getPrimaryKeyColoumnName();


	public T findOne(final ID primaryKey)
	{
			Connection connection;
			try {
				connection = connectionFactory.getConnection();
				Statement stmt = connection.createStatement();
				ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'");
				while(resultSet.next()) {
					return  extractResultSetRow(resultSet);
				}
			
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		
	}

	public Iterable<T> findAll ()
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " +getTableName());
			List<T> productList = new ArrayList<T>();
			while(resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;

		} catch (Exception e) {
			return Collections.emptyList();
		}

	}

	

	public void delete(final T entity)
	{
		//Code to delete entity
	}

	public boolean exists(final ID primaryKey)
	{
		//Check if primaryKey exist or not
		return false;
	}
}
