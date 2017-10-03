package com.metacube.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.model.Product;


@Component("productService")
public class DefaultProductService implements ProductService
{
	
	@Autowired
	ProductDao productDao;
	
	public DefaultProductService() {
	}
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	public Iterable<Product> getAllProducts() {
		return productDao.findAll();
	}

	public Product getProductById(int id) {
		return productDao.findOne(id);
	}
}
