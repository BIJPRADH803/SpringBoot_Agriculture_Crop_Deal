package com.aglcropsystem.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="Cartlist")
public class Cart {
	
	
	@Id
	private int cartId;

	private List<Crops> crops;
	
	

	public Cart() {

	}

	public Cart(int cartId, List<Crops> crops) {
		super();
		this.cartId = cartId;
		this.crops = crops;
	}



	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public List<Crops> getCrops() {
		return crops;
	}



	public void setCrops(List<Crops> crops) {
		this.crops = crops;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", crops=" + crops + "]";
	}



	

}
