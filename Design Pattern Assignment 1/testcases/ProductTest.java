package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Facade.ProductFacade;

public class ProductTest {


	@Test
	public void isValidProductIdFail(){
		
		assertEquals(false, ProductFacade.getInstance().isValidProductId(1006));
		
	}
	
	@Test
	public void isValidProductIdPass(){
		
		assertEquals(true, ProductFacade.getInstance().isValidProductId(1004));
		
	}
}
