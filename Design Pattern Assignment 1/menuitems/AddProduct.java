package menuitems;

import View.Input;
import menu.Action;

public class AddProduct implements Action{

	@Override
	public void performAction() {
		
		Input.getInstance().addProductsInCart();;
		
	}

}
