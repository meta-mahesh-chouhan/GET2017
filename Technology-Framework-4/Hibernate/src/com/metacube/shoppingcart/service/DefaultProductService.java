package com.metacube.shoppingcart.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.model.Product;

/**
 * Implementation of Product Service Interface
 * @author Mahesh
 *
 */
@Component("productService")
@Transactional
public class DefaultProductService implements ProductService
{
	
	@Resource(name="hibernateProductDao")
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
	
	public void deleteProductById(int id) {
		 productDao.delete(id);
	}
	
	@Override
	public void editProduct(Product product){
		productDao.update(product);
	}
	@Override
	public Product createProduct(Product product) {
	 	return productDao.create(product);
		
	}

}
