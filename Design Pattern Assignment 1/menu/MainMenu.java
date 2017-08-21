package menu;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import menuitems.Exit;
import menuitems.UserLogin;
import menuitems.UserSignUp;

/**
 * Main class which creates , display and perform actions on Menu.
 * 
 * @author Mahesh Chouhan
 *
 */
public class MainMenu {

	private static Scanner scan=new Scanner(System.in);
	/**
	 * Creates a Menu
	 * 
	 */
	public static Menu createMenu() {
		Menu mainMenu = new Menu();

		MenuItem login = new ActionableMenuItem(new UserLogin());
		

		List<MenuItem> subMenu = mainMenu.getSubMenu();
		login.setDisplayName("1.Login");
		subMenu.add(login);

		MenuItem displayPromotion = new ActionableMenuItem(new UserSignUp());
		displayPromotion.setDisplayName("2.Sign Up");
		subMenu.add(displayPromotion);
		
		MenuItem exit = new ActionableMenuItem(new Exit());
		exit.setDisplayName("3.Exit");
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
