/**
 * @Date 02-October-2017
 * @author Rajat Jain
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.facade.CartFacade;
import com.metacube.shoppingcart.facade.OrderFacade;
import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.model.Cart;
import com.metacube.shoppingcart.model.Order;
import com.metacube.shoppingcart.model.OrderDetail;

/**
 * The Class ProductController.
 */
@CrossOrigin
@Controller
@RequestMapping("/product")
public class ProductController {

	/** The product facade. */
	@Autowired
	ProductFacade productFacade;

	/** The user facade. */
	@Autowired
	UserFacade userFacade;

	/** The cart facade. */
	@Autowired
	CartFacade cartFacade;

	/** The order facade. */
	@Autowired
	OrderFacade orderFacade;
	
	/**
	 * Gets the products.
	 *
	 * @return the products
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<ProductDto> getProducts() {
		return productFacade.getAllProducts();
	}

	/**
	 * Gets the by id.
	 *
	 * @param id the id
	 * @return the by id
	 */
	@RequestMapping(value = "/getOne/{id}")
	public @ResponseBody ProductDto getById(@PathVariable("id") int id) {
		return productFacade.getProductById(id);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@RequestMapping(value = "/delete/{id}")
	public @ResponseBody Boolean deleteById(@PathVariable("id") int id) {
		return productFacade.deleteById(id);
	}

	/**
	 * Save.
	 *
	 * @param product the product
	 * @return the product dto
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody ProductDto save(@RequestBody ProductDto product) {
		return productFacade.save(product.getId(), product.getName(),
				product.getPrice());
	}

	/**
	 * Update by id.
	 *
	 * @param product the product
	 * @return the product dto
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public @ResponseBody ProductDto updateById(@RequestBody ProductDto product) {
		return productFacade.update(product.getId(), product.getName(),
				product.getPrice());
	}
	
	/**
	 * Gets the by id.
	 *
	 * @param username the username
	 * @param password the password
	 * @return the by id
	 */
	@RequestMapping(value = "/getUser/{username}/{password}")
	public @ResponseBody Object getById(
			@PathVariable("username") String username,
			@PathVariable("password") String password) {
		UserDto user = userFacade.getUserById(username);
		System.out.println("i m called");
		System.out.println((user.getName()) + user.getPassword());
		if ((username.equals(user.getName()))
				&& (password.equals(user.getPassword()))) {
			JSONObject obj = new JSONObject();
			obj.put("authenticationFlag", true);
			obj.put("userId", user.getId());
			System.out.print(obj);
			return obj;
		} else {
			JSONObject obj = new JSONObject();
			obj.put("authenticationFlag", false);
			obj.put("userId", -1);
			System.out.print(obj);
			return obj;
		}
	}
	
	/**
	 * Gets the all cart items.
	 *
	 * @param id the id
	 * @return the all cart items
	 */
	@RequestMapping(value = "/getAllCart/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<Cart> getAllCartItems(
			@PathVariable("id") String id) {
		return cartFacade.getAll(id);
	}

	/**
	 * Addto cart.
	 *
	 * @param cart the cart
	 * @return the cart
	 */
	@RequestMapping(value = "/saveToCart", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody Cart addtoCart(@RequestBody Cart cart) {
		return cartFacade.addToCart(cart.getPname(), cart.getPrice(),
				cart.getProductId(), cart.getUserId());
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	@RequestMapping(value = "/checkout/{id}")
	public @ResponseBody Boolean deleteById(@PathVariable("id") String id) {
		return cartFacade.checkout(id);
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @param order the order
	 * @return true, if successful
	 */
	@RequestMapping(value = "/order/{id}", method = RequestMethod.POST)
	public @ResponseBody boolean deleteById(@PathVariable("id") String id,
			@RequestBody Order order) {
		return orderFacade.saveOrder(id, order);
	}

	/**
	 * Gets the all order.
	 *
	 * @param id the id
	 * @return the all order
	 */
	@RequestMapping(value = "/getAllOrder/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<Order> getAllOrder(
			@PathVariable("id") String id) {
		return orderFacade.getAllOrder(id);
	}

	/**
	 * Gets the order detail.
	 *
	 * @param id the id
	 * @return the order detail
	 */
	@RequestMapping(value = "/getOrderDetail/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Iterable<OrderDetail> getOrderDetail(
			@PathVariable("id") int id) {
		return orderFacade.getOrderDetail(id);
	}

}
