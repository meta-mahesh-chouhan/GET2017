package Facade;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import Controller.ProductController;
import DAO.BaseDAO;
import DAO.DAOFactory;
import Entity.Cart;
import Entity.EntityFactory;
import Entity.Product;
import Enums.DBType;
import Enums.EntityName;
import Enums.ProductStatus;
import Enums.Status;

/**
 * Handles all the calculations related to Cart.
 * 
 * @author Mahesh Chouhan
 *
 */
public class CartFacade {

	private static CartFacade cartFacade;
	private Cart cart;
	@SuppressWarnings("unchecked")
	private static BaseDAO<Product> productDao = (BaseDAO<Product>) DAOFactory.getDAOForEntity(EntityName.Product, DBType.InMemory);

	private CartFacade() {
		setCart((Cart) EntityFactory.getEntityFromFactory(EntityName.Cart));
	}

	/**
	 * Ensure only single instance of class is created
	 * 
	 * @return CartFacade object
	 */
	public static CartFacade getInstance() {

		if (cartFacade == null) {
			synchronized (CartFacade.class) {

				if (cartFacade == null) {
					cartFacade = new CartFacade();
				}

			}
		}
		return cartFacade;
	}

	/**
	 * Check if product is Available or not.
	 * 
	 * @param productId
	 * @param quantity
	 * @return Status representing Available , Unavailable or Limited
	 */
	public ProductStatus checkAvaliability(int productId, int quantity) {

		Iterator<Product> itr = productDao.getAll().iterator();
		Product product;
		while (itr.hasNext()) {
			product = itr.next();
			if (product.getCode() == productId
					&& product.getQuantity() >= quantity) {
				return ProductStatus.Avaliable;
			} else if (product.getCode() == productId
					&& product.getQuantity() == 0) {
				return ProductStatus.Unavaliable;
			} else if (product.getCode() == productId
					&& product.getQuantity() < quantity) {
				return ProductStatus.Limited;
			}
		}
		return null;

	}

	public Cart getCart() {
		return cart;
	}

	/**
	 * Set all the attributes of products in the cart
	 */
	public void setRemainingAttributes() {

		Iterator<Product> iterator1 = cart.getListOfProductsInCart().iterator();

		Iterator<Product> iterator2 = productDao.getAll().iterator();
		Product product1, product2;

		while (iterator1.hasNext()) {

			product1 = iterator1.next();
			iterator2 = productDao.getAll().iterator();
			while (iterator2.hasNext()) {
				product2 = iterator2.next();
				if (product1.getCode() == product2.getCode()) {
					product1.setName(product2.getName());
					product1.setPrice(product2.getPrice());
					product1.setType(product2.getType());
				}
			}

		}

	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	/**
	 * Change Quantity of products in Cart
	 * 
	 * @param productId
	 * @param quantity
	 */
	public Status changeQuantity(int productId, int quantity) {
		Status status = Status.Failed;
		Iterator<Product> iterator = cart.getListOfProductsInCart().iterator();
		Product product;
		Product updatedProduct = new Product();
		updatedProduct.setCode(productId);

		while (iterator.hasNext()) {
			product = iterator.next();
			if (product.getCode() == productId) {

				updatedProduct.setQuantity(quantity - product.getQuantity());
				status =  Status.Success;
				product.setQuantity(quantity);
				ProductFacade.getInstance().updateQuantity(updatedProduct);
			}

		}
		return status;

	}

	/**
	 * Removes product form cart with given product Id.
	 * 
	 * @param productId
	 */
	public Status removeProduct(int productId) {
		
		Status status = Status.Failed;
		Iterator<Product> iterator = cart.getListOfProductsInCart().iterator();
		Product product;
		int quantity = 0;
		try {
			while (iterator.hasNext()) {
				product = iterator.next();
				if (product.getCode() == productId) {
					quantity = product.getQuantity();
					cart.getListOfProductsInCart().remove(product);
					status =  Status.Success;

				}
			}
		} catch (ConcurrentModificationException e) {
			status =  Status.Success;
		}
		
			Product negativeQuantity = new Product();
			negativeQuantity.setCode(productId);
			negativeQuantity.setQuantity(-quantity);
			ProductController.getInstance().updateQuantity(negativeQuantity);
		
		
		
		
		return status;
	}

	/**
	 * Add product to cart with given product Id.
	 * 
	 * @param productId
	 * @param quantity
	 */
	public Status addProdcutsInCart(int productId, int quantity) {
		
		Status status = Status.Failed;
		Iterator<Product> iterator = cart.getListOfProductsInCart().iterator();
		Product product;
		boolean flag = true;
		while (iterator.hasNext()) {
			product = iterator.next();
			if (product.getCode() == productId) {
				product.setQuantity(product.getQuantity() + quantity);
				flag = false;
				status =  Status.Success;
			}
		}

		if (flag){
			cart.addProductsInCart(productId, quantity);
			status =  Status.Success;
		}
	
			
	
		
		return status;
	}

	/**
	 * Return quantity of product in store from given product Id
	 * 
	 * @param productId
	 * @return
	 */
	public int getQuantityFormStore(int productId) {
		Iterator<Product> iterator = productDao.getAll().iterator();
		Product product;
		while (iterator.hasNext()) {
			product = iterator.next();
			if (product.getCode() == productId) {
				return product.getQuantity();
			}

		}
		return 0;
	}

	/**
	 * Return quantity of product in cart from given product id
	 * 
	 * @param productId
	 * @return
	 */
	public int getQuantityFormCart(int productId) {
		Iterator<Product> iterator = cart.getListOfProductsInCart().iterator();
		Product product;
		while (iterator.hasNext()) {
			product = iterator.next();
			if (product.getCode() == productId) {
				return product.getQuantity();
			}

		}
		return 0;
	}

}
