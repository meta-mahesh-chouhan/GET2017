package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.Product;

public interface ProductService
{
	Iterable<Product> getAllProducts();
	Product getProductById(int id);
}
