import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main Class which drives all the functionality.
 * 
 * @author Mahesh Chouhan
 *
 */
public class Main {
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		ShoppingStore myStore = new ShoppingStore();

		myStore.displayProducts();

		Promotion myPromo = new Promotion();
		myPromo.displayProductPromotion(myStore);
		myPromo.displayOrderPromotion();

		int noOfProducts = 0;
		System.out.print("Enter the number of products you want to buy : ");

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

		Order order = new Order(noOfProducts);

		for (int i = 0; i < noOfProducts; i++) {
			System.out.print("Enter product Id for Product " + (i + 1) + " : ");
			int productId = 0;

			/*
			 * If user inputs non-numerical value.
			 */
			while (true) {
				try {
					productId = scan.nextInt();

					if (!myStore.checkProductId(productId)) {
						System.out.println("Invalid Prouduct Id:No such product in store");
						System.out.print("Enter Valid Product Id:");
					} else {
						break;
					}
				} catch (InputMismatchException e) {
					System.out.print("Enter a numberical Product Id :");
					scan.nextLine();
				}
			}

			order.addProductInOrder(new Product(productId), i);
			System.out.println();
			System.out.print("Enter desired quantity for Product " + (i + 1)
					+ " : ");
			int quantity = 0;

			/*
			 * If user inputs non-numerical value.
			 */
			while (true) {
				try {
					quantity = scan.nextInt();

					if (quantity <= 0)
						System.out.print("Enter a Positive Value :");
					else
						break;
				} catch (InputMismatchException e) {
					System.out.print("Enter a number :");
					scan.nextLine();
				}
			}

			order.setProductQuantity(i, quantity);

		}

		order.setRemainingAttributes(myStore);
		order.setOrderPrice();
		order.printOrder(myStore, myPromo);

		Record record = new Record();
		record.recordFile(order, myStore);

		System.out.println("\n\nTHANK YOU FOR SHOPPING !");
	}

}
