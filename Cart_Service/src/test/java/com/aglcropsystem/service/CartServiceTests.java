package com.aglcropsystem.service;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.aglcropsystem.model.Cart;
import com.aglcropsystem.model.Crops;
import com.aglcropsystem.repository.CartRepository;
import com.aglcropsystem.repository.CropsRepo;




@SpringBootTest
public class CartServiceTests {

    @Autowired
    CartService cartService;

    @MockBean
    CartRepository cartsRepo;

   Cart c1;
    

    @BeforeEach
    void setUp() throws Exception {
    	
    c1= new  Cart();
    
//    private int cartId;
//	private List<Crops> crops;	
    
     c1.setCartId(967);
   
        
        
 
    }

    /*
     * public Cart addCart(Cart cart);
     */

    
    
    
	/*
	 * public void deleteCartById(int cartId);
	 */
    
    
    

	/*
	 * public List<Cart> getAllCarts();
	 */




}

    
    