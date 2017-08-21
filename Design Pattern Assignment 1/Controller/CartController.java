package Controller;

import Enums.ProductStatus;
import Facade.CartFacade;

/**
 * Act as an interface between View layer and Facade Layer
 * 
 * @author Mahesh Chouhan
 */
public class CartController {

	private static CartController cartController;

	private CartController() {

	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Cart Controller object
	 */
	public static CartController getInstance() {

		if (cartController == null) {
			synchronized (CartController.class) {

				if (cartController == null) {
					cartController = new CartController();
				}

			}
		}
		return cartController;
	}

	/**
	 * Set all the attributes of products in the cart
	 */
	public void setRemainingAtrributes() {
		CartFacade.getInstance().setRemainingAttributes();
	}

	/**
	 * Check if product is Available or not.
	 * 
	 * @param productId
	 * @param quantity
	 * @return Status representing Available , Unavailable or Limited
	 */
	public ProductStatus checkAvaliability(int productId, int quantity) {

		return CartFacade.getInstance().checkAvaliability(productId, quantity);

	}

	/**
	 * Change Quantity of products in Cart
	 * 
	 * @param productId
	 * @param quantity
	 */
	public void changeQuantity(int productId, int quantity) {
		CartFacade.getInstance().changeQuantity(productId, quantity);
	}

	/**
	 * Removes product form cart with given product Id.
	 * 
	 * @param productId
	 */
	public void removeProduct(int productId) {
		CartFacade.getInstance().removeProduct(productId);
	}

	/**
	 * Add prodcut to cart with given product Id.
	 * 
	 * @param productId
	 * @param quantity
	 */
	public void addProductsInCart(int productId, int quantity) {

		CartFacade.getInstance().addProdcutsInCart(productId, quantity);

	}

	/**
	 * Return quantity of product in store from given product Id
	 * 
	 * @param productId
	 * @return
	 */
	public int getQuantityFromStore(int productId) {

		return CartFacade.getInstance().getQuantityFormStore(productId);
	}

	/**
	 * Return quantity of product in cart from given product id
	 * 
	 * @param productId
	 * @return
	 */
	public int getQuantityFromCart(int productId) {

		return CartFacade.getInstance().getQuantityFormCart(productId);
	}

}
