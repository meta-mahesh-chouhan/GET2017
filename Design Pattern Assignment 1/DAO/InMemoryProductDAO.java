package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Entity.Product;
import Enums.ProductType;

/**
 * Data Acces Object to handle list of products in memory.
 * 
 * @author Mahesh Chouhan
 *
 */
public class InMemoryProductDAO implements ProductDAO {
	private static InMemoryProductDAO inMemoryProductDao;
	private List<Product> listOfProducts;

	private InMemoryProductDAO() {

		listOfProducts = new ArrayList<Product>();

		listOfProducts.add(new Product(1001, "Reebok Shoes", 3500.00,ProductType.Shoe, 20));
		listOfProducts.add(new Product(1002, "Mufti Shirt", 1050.00,ProductType.Shirt, 10));
		listOfProducts.add(new Product(1003, "UCB Jeans", 4500.15,ProductType.Trouser, 15));
		listOfProducts.add(new Product(1004, "Levis Jeans", 6500.15,ProductType.Trouser, 0));

	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return InMemoryProductDAO object
	 */
	public static InMemoryProductDAO getInstance() {

		if (inMemoryProductDao == null) {
			synchronized (InMemoryProductDAO.class) {

				if (inMemoryProductDao == null) {
					inMemoryProductDao = new InMemoryProductDAO();
				}

			}
		}
		return inMemoryProductDao;
	}

	@Override
	public void create(Product t) {

	}

	/**
	 * Updates the Quantity of products in store in memory.
	 * 
	 */
	@Override
	public void update(Product t) {
		Iterator<Product> iterator = listOfProducts.iterator();
		Product product;
		while (iterator.hasNext()) {
			product = iterator.next();

			if (product.getCode() == t.getCode()) {
				product.setQuantity(product.getQuantity() - t.getQuantity());
			}
		}

	}

	@Override
	public void delete(Product t) {
		
	}

	@Override
	public List<Product> getAll() {
		return listOfProducts;
	}

}
