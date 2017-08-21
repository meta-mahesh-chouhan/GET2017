package menuitems;

import menu.Action;
import View.Output;

public class PrintBill implements Action {

	@Override
	public void performAction() {
		Output.getInstance().printBill();
	}

}
