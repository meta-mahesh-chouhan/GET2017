package Facade;

import java.util.Iterator;
import java.util.List;

import DAO.BaseDAO;
import DAO.DAOFactory;
import Entity.Product;
import Enums.DBType;
import Enums.EntityName;

/**
 * Handles all calculations related to Products.
 * 
 * @author Mahesh Chouhan
 *
 */
public class ProductFacade {
	private static ProductFacade productFacade;
	@SuppressWarnings("unchecked")
	private static BaseDAO<Product> productDao = (BaseDAO<Product>) DAOFactory.getDAOForEntity(EntityName.Product, DBType.InMemory);
	private ProductFacade() {

	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return Cart Controller object
	 */
	public static ProductFacade getInstance() {

		if (productFacade == null) {
			synchronized (ProductFacade.class) {
				if (productFacade == null) {
					productFacade = new ProductFacade();
				}

			}
		}

		return productFacade;
	}

	/**
	 * Returns list of products in store.
	 * 
	 * @return List of products
	 */
	public List<Product> getProductsInStore() {
		
		List<Product> listOfProducts = productDao.getAll();

		return listOfProducts;

	}

	/**
	 * Check if porductId is valid or no.t
	 * 
	 * @param productId
	 * @return true or false
	 */
	public boolean isValidProductId(int productId) {

		
		Iterator<Product> iterator = productDao.getAll().iterator();

		while (iterator.hasNext()) {
			if (iterator.next().getCode() == productId) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Updates Quantity of products in Store.
	 * 
	 * @param product
	 */
	public void updateQuantity(Product product) {

		productDao.update(product);

	}

}
