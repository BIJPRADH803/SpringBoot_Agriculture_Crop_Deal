package com.aglcropsystem.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aglcropsystem.model.Cart;
import com.aglcropsystem.model.Crops;
import com.aglcropsystem.service.CartService;


/*
 * @Author: Bijay Pradhan
 * Emp id:46195803
 * Created On:25-07-2022
 * Modified On:29-07-2022
 */

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	
	private Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@PostMapping("/add")
	public ResponseEntity<Cart> addCart(@RequestBody Cart cart) {
		LOGGER.info("Inside addCart of cartController");

		LOGGER.info("Adding...");

		Cart newCart = cartService.addCart(cart);
		ResponseEntity<Cart> responseEntity = new ResponseEntity<Cart>(newCart, HttpStatus.CREATED);
		return responseEntity;
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Cart>> fetchAllCarts() {
		LOGGER.info("Inside fetchAllCarts of cartController");

		LOGGER.info("Fetching list of crops");
		List<Cart> allCarts = cartService.getAllCarts();
		ResponseEntity<List<Cart>> responseEntity = new ResponseEntity<List<Cart>>(allCarts, HttpStatus.ACCEPTED);
		return responseEntity;
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCropById(@PathVariable("id") int cartId) {
		LOGGER.info("Inside deleteCropById of cartController");

		LOGGER.info("Deleting...");
		cartService.deleteCartById(cartId);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Cart deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

}