package com.metacube.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.service.ProductService;
/**
 * Controller to handle all rest requests
 * @author Mahesh
 *
 */
@CrossOrigin
@Controller
@RequestMapping("/product")
public class ProductController
{
	@Autowired
	ProductService productService;


	/**
	 * Returns List of all products
	 */
	@RequestMapping(value ="/list",method = RequestMethod.GET )
	public @ResponseBody Iterable<Product> getProducts() {	
		return  productService.getAllProducts();
	}
	
	/**
	 * Deletes product by id
	 */
	@RequestMapping(value ="/deleteproduct/{id}",method = RequestMethod.DELETE )
	public @ResponseBody void deleteProduct(@PathVariable("id") int id){
		 productService.deleteProductById(id);
	}
	
	/**
	 * Updates product 
	 */
	@RequestMapping(value ="/updateproduct",method = RequestMethod.PUT )
	public @ResponseBody void editProduct(@RequestBody Product product){
		productService.editProduct(product);
	}
	
	/**
	 * Get product by Id
	 */
	@RequestMapping(value ="/{id}",method = RequestMethod.GET )
	public @ResponseBody Product getProduct(@PathVariable("id") int id){
		return productService.getProductById(id);
	}
	
	/**
	 * Create new Product
	 */
	@RequestMapping(value ="/addproduct",method = RequestMethod.POST)
	public @ResponseBody Product addProduct(@RequestBody Product product){
		 
		 return productService.createProduct(product);

	}
}
