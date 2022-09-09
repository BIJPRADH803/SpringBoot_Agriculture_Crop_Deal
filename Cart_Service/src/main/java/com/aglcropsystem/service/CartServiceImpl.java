package com.aglcropsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aglcropsystem.exceptions.CropsAlreadyExistException;
import com.aglcropsystem.exceptions.CropsNotFoundException;
import com.aglcropsystem.model.Cart;
import com.aglcropsystem.repository.CartRepository;


@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Override
	public Cart addCart(Cart cart) {
		Optional<Cart> savedCart = cartRepository.findById(cart.getCartId());
		if (savedCart.isPresent()) {
			throw new CropsAlreadyExistException();
		} else
			return cartRepository.save(cart);
	}

	@Override
	public void deleteCartById(int cartId) {
		Optional<Cart> optionalCart = cartRepository.findById(cartId);
		if (optionalCart == null) {
			throw new CropsNotFoundException();
		}

	}

	@Override
	public List<Cart> getAllCarts() {
		List<Cart> carts = cartRepository.findAll();
		if (carts == null) {
			throw new CropsNotFoundException();
		} else
			return carts;
	}

}
