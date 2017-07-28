package menu;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Main class which creates , display and perform actions on Menu.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Main {

	private static Scanner scan=new Scanner(System.in);
	/**
	 * Creates a Menu
	 * 
	 */
	public static Menu createMenu() {
		Menu mainMenu = new Menu();

		MenuItem menuItem1 = new ActionableMenuItem(new DisplayProductList());
		List<MenuItem> subMenu = mainMenu.getSubMenu();
		menuItem1.setDisplayName("1.Display Product List");
		subMenu.add(menuItem1);

		MenuItem menuItem2 = new Menu();
		menuItem2.setDisplayName("2.Display Promotion List");

		subMenu.add(menuItem2);
		List<MenuItem> subPromoMenu = ((Menu) menuItem2).getSubMenu();
		MenuItem subMenuItem1 = new ActionableMenuItem(new DisplayProductPromotion());
		subMenuItem1.setDisplayName("1.Product Promotion");
		subPromoMenu.add(subMenuItem1);

		MenuItem subMenuItem2 = new ActionableMenuItem(new DisplayOrderPromotion());
		subMenuItem2.setDisplayName("2.Order Promotion");
		subPromoMenu.add(subMenuItem2);
		
		MenuItem menuItem3 = new ActionableMenuItem(new Order());
		menuItem3.setDisplayName("3.Order");
		subMenu.add(menuItem3);

		MenuItem menuItem4 = new ActionableMenuItem(new Exit());
		menuItem4.setDisplayName("4.Exit");
		subMenu.add(menuItem4);

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

				flag = false;
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
