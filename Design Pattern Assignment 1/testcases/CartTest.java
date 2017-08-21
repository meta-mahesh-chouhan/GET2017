package testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Enums.ProductStatus;
import Enums.Status;
import Facade.CartFacade;
public class CartTest {
	

	@Test
	public void getQuantityFromStore(){
		assertEquals(15, CartFacade.getInstance().getQuantityFormStore(1003));
	}
	
	@Test
	public void checkAvailibiltyFail(){	
		assertEquals(ProductStatus.Unavaliable, CartFacade.getInstance().checkAvaliability(1004, 10));
	}
	
	@Test
	public void checkAvailibiltyPass(){	
		assertEquals(ProductStatus.Avaliable, CartFacade.getInstance().checkAvaliability(1001, 10));
	}

	@Test
	public void removeProductFail(){
		assertEquals(Status.Failed, CartFacade.getInstance().removeProduct(1001));
	}
	
	@Test
	public void removeProductPass(){
		CartFacade.getInstance().addProdcutsInCart(1001, 13);
		assertEquals(Status.Success, CartFacade.getInstance().removeProduct(1001));
	}
	
	@Test
	public void checkAvailibiltyLimited(){	
		assertEquals(ProductStatus.Limited, CartFacade.getInstance().checkAvaliability(1001, 50));
	}
	
	@Test
	public void addProductPass(){
		assertEquals(Status.Success, CartFacade.getInstance().addProdcutsInCart(1003, 10));
			
	}
	
	@Test
	public void getQuantityFromCart(){
		CartFacade.getInstance().addProdcutsInCart(1001, 13);
		assertEquals(13, CartFacade.getInstance().getQuantityFormCart(1001));
	}
	
	@Test
	public void changeQuantity(){
		CartFacade.getInstance().addProdcutsInCart(1002, 10);
		assertEquals(Status.Success, CartFacade.getInstance().changeQuantity(1002, 5));
		assertEquals(5, CartFacade.getInstance().getQuantityFormCart(1002));
		
		
	}
	

	
	
	
}
