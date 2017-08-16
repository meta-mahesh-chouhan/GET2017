package menuitems;

import menu.Action;
import View.Output;

public class ViewProductList implements Action {

	@Override
	public void performAction() {
		Output.getInstance().displayProductsInStroe();
	}

}
