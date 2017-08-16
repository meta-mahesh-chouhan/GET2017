package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Blueprint for cart entity
 * 
 * @author Mahesh Chouhan
 *
 */
public class Cart implements BaseEntity {
	private static Cart cart;

	private List<Product> listOfProductsInCart;

	private Cart() {
		listOfProductsInCart = new ArrayList<Product>();
	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Cart object
	 */
	public static Cart getInstance() {

		if (cart == null) {
			synchronized (Cart.class) {
				if (cart == null) {
					cart = new Cart();
				}
			}
		}
		return cart;
	}


	public List<Product> getListOfProductsInCart() {
		return listOfProductsInCart;
	}

	public void setListOfProductsInCart(List<Product> listOfProductsInCart) {
		this.listOfProductsInCart = listOfProductsInCart;
	}

	/**
	 * Adds new product in Cart
	 * 
	 * @param productId
	 * @param quantity
	 */
	public void addProductsInCart(int productId, int quantity) {
		Product product = new Product();
		product.setQuantity(quantity);
		product.setCode(productId);
		listOfProductsInCart.add(product);
	}

}
