package com.metacube.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.spring.Factory;

@CrossOrigin
@Controller
@RequestMapping("/product")
public class ProductController
{
	@Autowired
	ProductFacade productFacade;


	@RequestMapping(value ="/list",method = RequestMethod.GET )
	public @ResponseBody Iterable<ProductDto> getProducts() {	
		return  productFacade.getAllProducts();
	}
}
