import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Order class contains all the product in the cart.
 * 
 * @author Mahesh Chouhan
 */
public class Order {
	private int noOfProductsInOrder;
	private Product[] productsInOrder;
	private double orderPrice;
	private String productPromoFilePath = "D:/ProductPromo.csv";
	private double orderDiscount;
	private String appliedOrderPromotion;

	public int getNoOfProductsInOrder() {
		return noOfProductsInOrder;
	}

	/**
	 * Constructor which sets the numberOfProductsInOrder.
	 */
	public Order(int number) {
		noOfProductsInOrder = number;

		productsInOrder = new Product[number];
	}

	/**
	 * Returns Array of products ordered.
	 */
	public Product[] getProductsInOrder() {
		return productsInOrder;
	}

	/**
	 * Adds particular product to order.
	 * 
	 * @param product
	 * @param index
	 */
	public void addProductInOrder(Product product, int index) {
		productsInOrder[index] = product;
	}

	/**
	 * Sets the quantity of each Product.
	 * 
	 * @param index
	 * @param quantity
	 */
	public void setProductQuantity(int index, int quantity) {
		productsInOrder[index].setQuantity(quantity);
	}

	/**
	 * Sets the name and price of products in cart by searching through all the
	 * products in store.
	 * 
	 * @param myStore
	 */
	public void setRemainingAttributes(ShoppingStore myStore) {

		for (int index = 0; index < noOfProductsInOrder; index++) {
			Product[] productsInStore = myStore.getStore();
			for (int jIndex = 0; jIndex < myStore.getTotalProuctsInStore(); jIndex++) {

				// Check for product in order in the store.
				if (productsInOrder[index].getProductId() == productsInStore[jIndex].getProductId()) {

					productsInOrder[index].setProductName(productsInStore[jIndex].getProductName());

					productsInOrder[index].setProductPrice(productsInStore[jIndex].getProductPrice());

				}

			}
		}

	}

	/**
	 * Print customer order to console.
	 * 
	 * @param myStore
	 */
	public void printOrder(ShoppingStore myStore, Promotion myPromo) {

		System.out
				.println("################################################################");
		System.out.println("                          YOUR ORDER");
		System.out
				.println("################################################################\n\n");

		System.out.println("PURCHASED PRODUCTS:\n");
		double subTotal = 0;
		for (int i = 0; i < noOfProductsInOrder; i++) {
			System.out.println("Product : " + productsInOrder[i].getProductId()
					+ " - " + productsInOrder[i].getProductName());
			System.out.println("Cost : Rs"
							+ (productsInOrder[i].getProductPrice() * productsInOrder[i].getQuantity()) + " ("
							+ productsInOrder[i].getQuantity() + " X "
							+ productsInOrder[i].getProductPrice() + ")");
			subTotal += (productsInOrder[i].getProductPrice() * productsInOrder[i]
					.getQuantity());
			System.out.println("\n\n");

		}

		System.out.println("APPLIED PROMOTIONS/DISCOUNTS :\n\n");

		double productDiscount = myPromo.displayProductPromotion(productsInOrder, myStore);

		String returnString[] = myPromo.calculateOrderPromotion(orderPrice- productDiscount);

		setOrderDiscount(Double.parseDouble(returnString[1]));
		setAppliedOrderPromotion(returnString[0]);

		System.out.println("SubTotal : Rs." + subTotal);
		System.out.println("Product Level Discounts : Rs." + productDiscount);
		System.out.println("Order Level Discounts : Rs." + orderDiscount);
		System.out.println("Total Discounts : Rs."+ (orderDiscount + productDiscount));
		System.out.println("Total : Rs."+ (subTotal - (orderDiscount + productDiscount)));

	}

	/**
	 * Returns price of order.
	 */
	public double getOrderPrice() {
		return orderPrice;
	}

	/**
	 * Calculate the price of order and sets in the variable orderPrice.
	 */
	public void setOrderPrice() {
		int totalPrice = 0;

		for (int i = 0; i < productsInOrder.length; i++) {
			totalPrice += (productsInOrder[i].getProductPrice() * productsInOrder[i].getQuantity());
		}

		orderPrice = totalPrice;
	}

	public double getOrderDiscount() {
		return orderDiscount;
	}

	public void setOrderDiscount(double orderDiscount) {
		this.orderDiscount = orderDiscount;
	}

	public String getAppliedOrderPromotion() {
		return appliedOrderPromotion;
	}

	public void setAppliedOrderPromotion(String appliedOrderPromotion) {
		this.appliedOrderPromotion = appliedOrderPromotion;
	}
}
