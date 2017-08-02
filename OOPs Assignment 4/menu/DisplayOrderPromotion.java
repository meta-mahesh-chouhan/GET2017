package menu;
import shop.Promotion;

/**
 * Menu Option 2 , SubMenu option 1- Display Order Promotion
 * @author User19
 *
 */
public class DisplayOrderPromotion implements Action {

	@Override
	public void performAction() {
		Promotion myPromo=new Promotion();
		myPromo.displayOrderPromotion();
	}

}
