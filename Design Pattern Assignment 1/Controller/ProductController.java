package Controller;

import java.util.List;

import Entity.Product;
import Facade.ProductFacade;

/**
 * Act as Interface between View and Facade layer.
 * 
 * @author Mahesh Chouhan
 *
 */
public class ProductController {
	private static ProductController productController;

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Product Controller object
	 */
	public static ProductController getInstance() {

		if (productController == null) {
			synchronized (ProductController.class) {
				if (productController == null) {
					productController = new ProductController();
				}

			}
		}

		return productController;
	}

	/**
	 * Returns list of products in store.
	 * 
	 * @return List of products
	 */
	public List<Product> getProdcutsInStore() {
		return ProductFacade.getInstance().getProductsInStore();
	}

	/**
	 * Check if porductId is valid or not
	 * 
	 * @param productId
	 * @return true or false
	 */
	public boolean isValidProductId(int productId) {
		return ProductFacade.getInstance().isValidProductId(productId);
	}

	/**
	 * Change quantity of product in Store.
	 * 
	 * @param product
	 */
	public void updateQuantity(Product product) {

		ProductFacade.getInstance().updateQuantity(product);

	}
}
