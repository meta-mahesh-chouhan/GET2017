package menuitems;

import menu.Action;
import View.Output;

public class ViewCart implements Action {

	@Override
	public void performAction() {
		Output.getInstance().viewCart();
	}

}
