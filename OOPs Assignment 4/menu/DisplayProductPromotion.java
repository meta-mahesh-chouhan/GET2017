package menu;
import shop.Promotion;

/**
 * Menu Option 2,SubMenu option 1 - Displays Product Promotion List
 * 
 * @author Mahesh Chouhan
 *
 */
public class DisplayProductPromotion implements Action {

	@Override
	public void performAction() {
		Promotion myPromo=new Promotion();
		
		myPromo.displayProductPromotion();
	}

}
