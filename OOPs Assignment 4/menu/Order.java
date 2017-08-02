package menu;
/**
 * Menu Option 3- Helps user to place an order
 * 
 * @author Mahesh Chouhan
 *
 */
public class Order implements Action{

	@Override
	public void performAction() {
		
		shop.Order order=new shop.Order();
		order.takeOrder();
		
	}

}
