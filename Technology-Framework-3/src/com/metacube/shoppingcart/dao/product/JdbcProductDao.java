package com.metacube.shoppingcart.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dao.GenericJdbcDao;
import com.metacube.shoppingcart.model.Product;

@Component("productDao")
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao
{

	private String tableName = "product";
	
	
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override protected String getTableName()
	{
		return tableName;
	}

	@Override protected Product extractResultSetRow(final ResultSet resultSet)
	{
		Product product = new Product();

		try
		{
			product.setName(resultSet.getString("name"));
			product.setId(resultSet.getInt("id"));
			product.setPrice(resultSet.getDouble("price"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}


		return product;
	}

	@Override protected String getPrimaryKeyColoumnName()
	{
		return "id";
	}
}
