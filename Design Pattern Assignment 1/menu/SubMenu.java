package menu;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import menuitems.AddProduct;
import menuitems.ChangeQuantity;
import menuitems.Exit;
import menuitems.PrintBill;
import menuitems.RemoveProduct;
import menuitems.ViewCart;
import menuitems.ViewProductList;

public class SubMenu {

	private static Scanner scan=new Scanner(System.in);
	/**
	 * Creates a Menu
	 * 
	 */
	public static Menu createMenu() {
		Menu mainMenu = new Menu();
		List<MenuItem> subMenu = mainMenu.getSubMenu();
		
		MenuItem viewProductsList = new ActionableMenuItem(new ViewProductList());
		viewProductsList.setDisplayName("1.View Product List");
		subMenu.add(viewProductsList);
		
		MenuItem addToCart = new ActionableMenuItem(new AddProduct());
		addToCart.setDisplayName("2.Add Products To Cart");
		subMenu.add(addToCart);

		MenuItem viewCart = new ActionableMenuItem(new ViewCart());
		viewCart.setDisplayName("3.View Cart");
		subMenu.add(viewCart);
		
		MenuItem removeProduct = new ActionableMenuItem(new RemoveProduct());
		removeProduct.setDisplayName("4.Remove Product From Cart");
		subMenu.add(removeProduct);
		
		MenuItem changeQuantity = new ActionableMenuItem(new ChangeQuantity());
		changeQuantity.setDisplayName("5.Change Quantity");
		subMenu.add(changeQuantity);
		
		MenuItem placeOrder = new ActionableMenuItem(new PrintBill());
		placeOrder.setDisplayName("6.Generate Bill");
		subMenu.add(placeOrder);
		
		MenuItem exit = new ActionableMenuItem(new Exit());
		exit.setDisplayName("7.Exit");
		subMenu.add(exit);
		
		return mainMenu;
		
	}
	
	/**
	 * Display the menu and perform function as per given choice.
	 * 
	 */
	public static void display(Menu menu){

		Iterator<MenuItem> itr = menu.getSubMenu().iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next().getDisplayName());
		}

	}
	
	/**
	 *Gets user choice form console.
	 * @return choice
	 */
	public static int getInput() {
		
		boolean flag = true;
		int choice = 0;
		while (flag) {
			try {
				choice = scan.nextInt();
				
				if	(choice>0){
				flag = false;
				}else{
				System.out.print("Enter a Positive Number :");
				}
			} catch (InputMismatchException e) {
				System.out.print("Input a number :");
				scan.nextLine();
			}
		}
	
		return choice - 1;
	}
	
	/**
	 * Displays menu and perform action according to choice.
	 */
	public static void displayAndPerformAction(Menu menu){
		
		display(menu);
		
		int choice = getInput();
		
		MenuItem menuItem = menu.getSelection(choice);
	
		if (menuItem == null){
			System.out.println("\nChoose from above Options\n");
			displayAndPerformAction(menu);
		}
		else if (menuItem instanceof ActionableMenuItem){	
			((ActionableMenuItem)menuItem).triggerAction();
		}
		else {
			displayAndPerformAction((Menu)menuItem);
		}
		
	}

	public static void main(String args[]) {
		Menu menu = createMenu();

		while (true) {
			displayAndPerformAction(menu);
		}

	}
}
