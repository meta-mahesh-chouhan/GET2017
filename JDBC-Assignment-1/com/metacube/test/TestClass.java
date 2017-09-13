package com.metacube.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.metacube.entity.Title;
import com.metacube.helper.DBHelper;

public class TestClass {
	
	/**
	 * Book Issued - Pass
	 */
	@Test
	public void isBookIssuedPass(){
		assertEquals("Issued",DBHelper.getInstance().isBookIssued("Concepts Of C++"));
	}


	/**
	 * Book Issued - Fail
	 */
	@Test
	public void isBookIssuedFail(){
		assertEquals("Not Issued",DBHelper.getInstance().isBookIssued("Concepts Of PHP"));
	}
	

	/**
	 * Book Issued - Book Not Present
	 */
	@Test
	public void isBookIssuedNotPresent(){
		assertEquals("No Such Book present in Library",DBHelper.getInstance().isBookIssued("The Monk Who Sold His Ferrari"));
	}
	
	/**
	 * Get Titles by Author name - Pass
	 */
	@Test
	public void getTitlesByAuthorNamePass(){
		
		List<Title> listOfTitles = new ArrayList<Title>();
		
		listOfTitles.add(new Title(10003, "Concepts Of Chemistry", 3, 3));
		listOfTitles.add(new Title(10004, "Concepts Of C++", 2, 4));
		
		assertEquals(listOfTitles, DBHelper.getInstance().getTitlesByAuthorName("John Green"));
		
	}
	

	/**
	 * Get Titles by Author name - Fail
	 */
	@Test
	public void getTitlesByAuthorNameFail(){
		assertTrue(DBHelper.getInstance().getTitlesByAuthorName("Mahesh").isEmpty());
	}
	
	/**
	 * Delete Books - Pass
	 */
	@Test
	public void deleteBooksPass(){
		assertEquals(1, DBHelper.getInstance().deleteBooks());
	}
	
	/**
	 * Delete Books - Fail
	 */
	@Test
	public void deleteBooksFail(){
		assertEquals(0, DBHelper.getInstance().deleteBooks());
	}
}
