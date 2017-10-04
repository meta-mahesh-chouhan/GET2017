package com.metacube.shoppingcart.dao.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dao.GenericJdbcDao;
import com.metacube.shoppingcart.dao.JdbcConnectionFactory;
import com.metacube.shoppingcart.model.Product;

@Component
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao
{

	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();
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


	public Product create(Product product){
		
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			
			
			stmt.executeUpdate("INSERT INTO product(name, price) VALUES ('"+product.getName()+"', "+product.getPrice()+");");
			
			ResultSet resultSet = stmt.executeQuery("SELECT id FROM product ORDER BY id DESC LIMIT 1;");
			resultSet.next();
			int id = resultSet.getInt("id");
			product.setId(id);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	@Override
	public void update(Product product){
		
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			String query = "UPDATE "+getTableName()+" SET name ='"+product.getName()+"', price='"+product.getPrice()+"' WHERE id='"+product.getId()+"'";
			stmt.executeUpdate(query);
		} catch (Exception e) {
		}

	}
	
}
