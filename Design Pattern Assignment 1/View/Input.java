package View;

import java.util.InputMismatchException;
import java.util.Scanner;

import menu.SubMenu;
import Controller.CartController;
import Controller.ProductController;
import Controller.UserController;
import Entity.Cart;
import Entity.EntityFactory;
import Entity.Product;
import Entity.User;
import Enums.EntityName;
import Enums.ProductStatus;

/**
 * Handles all the task related to taking input from User.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Input {
	private static Input input;
	private static Scanner scan = new Scanner(System.in);

	private Input() {

	}

	/**
	 * Ensures that only Single Instance is created
	 * 
	 * @return Input object
	 */
	public static Input getInstance() {

		if (input == null) {
			synchronized (Input.class) {

				if (input == null) {
					input = new Input();
				}

			}
		}
		return input;
	}

	/**
	 * Asks user details from user
	 */
	public void inputLoginDetails() {
		System.out.println("Enter Username:");
		String username = scan.nextLine().trim();
		System.out.println("Enter Password");
		String password = scan.nextLine().trim();

		if (UserController.getInstance().checkAuthorization(username, password)) {
			SubMenu.main(null);
		} else {
			System.out.println("Enter Correct Details");
		}

	}

	/**
	 * Change the quantity of product in cart.
	 */
	public void changeQuantity() {
		if(!((Cart)EntityFactory.getEntityFromFactory(EntityName.Cart)).getListOfProductsInCart().isEmpty()){
		int productId = 0;
		int quantity = 0;

		boolean outerFlag = true;
		while (outerFlag) {
			System.out.println("Enter desired Product Id:");
			boolean flag = true;
			while (flag) {
				try {
					productId = scan.nextInt();

					if (!ProductController.getInstance().isValidProductId(productId)) {
						System.out.println("Invalid Prouduct Id:No such product in store");
						System.out.print("Enter Valid Product Id:");
					} else {
						flag = false;
					}
				} catch (InputMismatchException e) {
					System.out.print("Enter a numberical Product Id :");
					scan.nextLine();
				}
			}

			System.out.print("Enter New quantity for Product  : ");
			flag = true;

			/*
			 * If user inputs non-numerical value.
			 */
			while (flag) {
				try {
					quantity = scan.nextInt();

					if (quantity <= 0)
						System.out.print("Enter a Positive Value :");
					else if (CartController.getInstance().getQuantityFromStore(productId)+ CartController.getInstance().getQuantityFromCart(productId) >= quantity) {
						flag = false;
						outerFlag = false;
					} else if (quantity > CartController.getInstance().getQuantityFromStore(productId)+ CartController.getInstance().getQuantityFromCart(productId)) {
						System.out.println("Requested Quantity not avaliable : Try Less Quantity");
						System.out.println("Maximum PossibleQuantity :"+ (CartController.getInstance().getQuantityFromStore(productId)+ (CartController.getInstance().getQuantityFromCart(productId))));
						System.out.println("Enter new quantity for Product : ");
					}
				} catch (InputMismatchException e) {
					System.out.print("Enter a number :");
					scan.nextLine();
				}
			}
		}
		CartController.getInstance().changeQuantity(productId, quantity);
		System.out.println("\n*************************Qunatity Changed***********************************\n\n");
		}
		else{
			System.out.println("\nEMPTY CART\n");
		}

	}

	/**
	 * Removes a product from cart.
	 */
	public void removeProduct() {
		if(!((Cart)EntityFactory.getEntityFromFactory(EntityName.Cart)).getListOfProductsInCart().isEmpty()){
		System.out.println("Enter desired Product Id:");
		int productId = 0;
		boolean flag = true;
		while (flag) {
			try {
				productId = scan.nextInt();

				if (!ProductController.getInstance().isValidProductId(productId)) {
					System.out.println("Invalid Prouduct Id:No such product in store");
					System.out.print("Enter Valid Product Id:");
				} else {
					flag = false;
				}
			} catch (InputMismatchException e) {
				System.out.print("Enter a numberical Product Id :");
				scan.nextLine();
			}
		}

		CartController.getInstance().removeProduct(productId);

		System.out.println("\n*************************Product Removed***********************************\n\n");

	}
	else{
		System.out.println("\nEMPTY CART\n");
	}
}	

	/**
	 * Adds new product in cart
	 */
	public void addProductsInCart() {

		System.out.println("Enter the number of products you want to buy:");
		int noOfProducts;
		/*
		 * If user inputs non-numerical value.
		 */
		while (true) {
			try {
				noOfProducts = scan.nextInt();

				if (noOfProducts <= 0)
					System.out.print("Enter a Positive Value :");
				else
					break;
			} catch (InputMismatchException e) {
				System.out.print("Enter a number :");
				scan.nextLine();
			}
		}

		for (int index = 0; index < noOfProducts; index++) {

			int productId = 0;
			int quantity = 0;
			boolean outerFlag = true;
			while (outerFlag) {

				System.out.println("Enter desired Product Id:");
				/*
				 * If user inputs non-numerical value.
				 */
				boolean flag = true;
				while (flag) {
					try {
						productId = scan.nextInt();

						if (!ProductController.getInstance().isValidProductId(productId)) {
							System.out.println("Invalid Prouduct Id:No such product in store");
							System.out.print("Enter Valid Product Id:");
						} else {
							flag = false;
						}
					} catch (InputMismatchException e) {
						System.out.print("Enter a numberical Product Id :");
						scan.nextLine();
					}
				}

				System.out.print("Enter desired quantity for Product "+ (index + 1) + " : ");
				flag = true;
				/*
				 * If user inputs non-numerical value.
				 */
				while (flag) {
					try {
						quantity = scan.nextInt();

						if (quantity <= 0)
							System.out.print("Enter a Positive Value :");
						else if (CartController.getInstance().checkAvaliability(productId, quantity) == ProductStatus.Avaliable) {
							outerFlag = false;
							flag = false;
						} else if (CartController.getInstance().checkAvaliability(productId, quantity) == ProductStatus.Unavaliable) {
							flag = false;
							System.out.println("Sorry Product is Unavaliable");
						} else {

							System.out.println("Requested Quantity not avaliable : Try Less Quantity");
							System.out.println("Maximum PossibleQuantity :"+ CartController.getInstance().getQuantityFromStore(productId) );
							System.out.print("Enter desired quantity for Product "+ (index + 1) + " : ");
						}
					} catch (InputMismatchException e) {
						System.out.print("Enter a number :");
						scan.nextLine();
					}
				}

			}
			Product product = new Product();
			product.setCode(productId);
			product.setQuantity(quantity);
			ProductController.getInstance().updateQuantity(product);

			CartController.getInstance().addProductsInCart(productId, quantity);
		}

		CartController.getInstance().setRemainingAtrributes();

		System.out.println("\n*************************Product Added***********************************\n\n");

	}

	/**
	 * Adds new user
	 */
	public void addUser() {

		System.out.println("Enter Desired Username ");
		String username = scan.nextLine().trim();

		while (username == "") {
			System.out.println("Empty : Write Something");
			username = scan.nextLine().trim();
		}

		System.out.println("Enter Desired Password ");
		String password = scan.nextLine().trim();

		while (password == "") {
			System.out.println("Empty : Write Something");
			password = scan.nextLine().trim();
		}

		User user = (User) EntityFactory.getEntityFromFactory(EntityName.User);

		user.setUsername(username);
		user.setPassword(password);

		UserController.getInstance().addUser(user);
		
		System.out.println("*********************************************New User Added*****************************************************");

	}

}
