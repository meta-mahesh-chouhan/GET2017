package com.metacube.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Handles connection to database
 * 
 * @author Mahesh Chouhan
 *
 */
public class ConnectDatabase {

	private static ConnectDatabase connectDatabase;
	private static Connection connection;

	private static final String host = "jdbc:mysql://localhost:3306/";
	private static final String database = "library";
	private static final String userName = "root";
	private static final String password = "root";

	private ConnectDatabase() {

	}

	/**
	 * Ensures only single instance of ConnectDatabase is created
	 * @return Single Instance of ConnectDatabase
	 */
	public static ConnectDatabase getInstance() {
		if (connectDatabase == null) {
			synchronized (ConnectDatabase.class) {
				if (connectDatabase == null) {
					connectDatabase = new ConnectDatabase();
				}
			}
		}
		return connectDatabase;
	}

	/**
	 * Returns connection object 
	 */
	public Connection getConnection() {

		if (connection == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(host + database, userName, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
