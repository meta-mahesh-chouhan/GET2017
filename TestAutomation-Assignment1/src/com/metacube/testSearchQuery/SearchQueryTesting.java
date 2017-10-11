package com.metacube.testSearchQuery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SearchQueryTesting {
	public static void main(String[] args) {
		try {
			WebDriver driver = new InternetExplorerDriver();
			driver.get("http://automationpractice.com/index.php");
			Thread.sleep(1000);
			driver.findElement(By.id("search_query_top")).click();
			driver.findElement(By.id("search_query_top")).sendKeys("Faded");
			System.out.println("test over");
			driver.findElement(By.name("submit_search")).click();
//			Thread.sleep(6000);
//			driver.quit();
		} catch (InterruptedException e) {
			System.out.println("Error: "+e);
		}
	}
}
