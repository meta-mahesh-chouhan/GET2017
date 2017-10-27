package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.Product;

/**
 * Product Service Interface
 * @author Mahesh
 *
 */
public interface ProductService
{
	Iterable<Product> getAllProducts();
	Product getProductById(int id);
	void deleteProductById(int id);
	void editProduct(Product product);
	Product createProduct(Product product);
}
