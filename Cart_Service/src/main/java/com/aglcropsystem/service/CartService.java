package com.aglcropsystem.service;


import java.util.List;
import com.aglcropsystem.model.Cart;

public interface CartService {

	public Cart addCart(Cart cart);

	public void deleteCartById(int cartId);

	public List<Cart> getAllCarts();

}