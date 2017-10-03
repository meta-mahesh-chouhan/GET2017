package com.metacube.shoppingcart.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.model.Product;
import com.metacube.shoppingcart.service.ProductService;


@Component("productFacade")
public class DefaultProductFacade implements ProductFacade
{
	
	@Autowired
	 private ProductService productService;
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public DefaultProductFacade(){
	}

	public DefaultProductFacade(ProductService ProductService) {
		this.productService = ProductService;
	}


	public Iterable<ProductDto> getAllProducts()
	{
		List<ProductDto> productDtoList = new ArrayList<ProductDto>();

		for (Product Product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(Product));
		}

		return productDtoList;
	}

	public ProductDto getProductById(final int id)
	{
		return modelToDto(productService.getProductById(id));
	}

	protected Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(productDto.getPrice());
	
		return product;
	}

	protected ProductDto modelToDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());

		return productDto;
	}
}
