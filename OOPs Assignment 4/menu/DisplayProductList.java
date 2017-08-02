package menu;
import shop.ShoppingStore;

/**
 * Menu Option 1- Displays Product List
 * 
 * @author Mahesh Chouhan
 *
 */
public class DisplayProductList implements Action {

	@Override
	public void performAction() {	
		ShoppingStore myStore=new ShoppingStore();
		
		myStore.displayProducts();
		
	}

}
