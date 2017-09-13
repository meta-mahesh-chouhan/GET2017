package com.metacube.helper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.entity.Title;
/**
 * Database Helper Class which executes database queries
 * 
 * @author Mahesh Chouhan
 *
 */
public class DBHelper {
	
	private static DBHelper dbHelper;
	private Connection connection; 
	
	private DBHelper(){
		connection = ConnectDatabase.getInstance().getConnection();
	}
	
	/**
	 * Ensures only single instance of DBHelper is created
	 * 
	 * @return Single Instance of DBHelper
	 */
	public static DBHelper getInstance(){
		if(dbHelper == null){
			synchronized (Connection.class) {
				if(dbHelper == null){
					dbHelper = new DBHelper();
				}
			}
		}
		return dbHelper;
	}
	
	/**
	 * Checks whether book is issued or not
	 * 
	 * @param bookName
	 * @return "Issued" if book is issued otherwise "Not Issued"
	 */
	public String isBookIssued(String bookName) {

		String resultString = "";
		boolean result = false;
		String query = "SELECT * FROM titles INNER JOIN book USING(title_id) "
				+ "INNER JOIN book_issue USING(accession_no) "
				+ "WHERE title_name ='" + bookName + "';";

		ResultSet resultSet;
		Statement statement ;
		try {
			 statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			result = resultSet.next();
			
			// If book is not present in book_issue table
			if(result == false){
				
				//Check whether book is present in library or not
				String searchQuery = "SELECT * FROM titles INNER JOIN book USING(title_id) WHERE title_name ='" + bookName +"';";
				resultSet = statement.executeQuery(searchQuery);
				
				if(resultSet.isBeforeFirst()){
					resultString = "Not Issued";
				}
				else{
					resultString = "No Such Book present in Library";
				}
			}
			else{
				resultString = "Issued";
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultString;
	}

	/**
	 * Returns list of book titles by author
	 * 
	 * @param authorName
	 * @return
	 */
	public List<Title> getTitlesByAuthorName(String authorName) {

		List<Title> resultList = new ArrayList<Title>();

		String query = "SELECT title_id, title_name, subject_id, publisher_id"
				+ " FROM title_author INNER JOIN titles USING(title_id) "
				+ "INNER JOIN authors USING(author_id) "
				+ "WHERE author_name ='" + authorName + "';";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				resultList.add(new Title(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getInt(4)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	/**
	 * Delete books which have not been issued for last one year
	 * 
	 * @return Number of deleted books
	 */
	public int deleteBooks() {

		int noOfDeletedRows = 0;

		String query = "DELETE "
				+ " FROM book "
				+ "WHERE status <> 'unavaliable' "
				+ "AND  accession_no NOT IN (SELECT accession_no FROM  book_issue WHERE TIMESTAMPDIFF(year, issue_date, now()) < 1)";

		try {
			Statement statement = connection.createStatement();
			noOfDeletedRows = statement.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return noOfDeletedRows;
	}
}
