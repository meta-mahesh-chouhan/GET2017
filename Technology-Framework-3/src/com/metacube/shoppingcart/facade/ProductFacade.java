package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dto.ProductDto;


public interface ProductFacade
{
	Iterable<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
}
