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

import com.aglcropsystem.models.Dealer;
import com.aglcropsystem.repository.DealerRepository;
import com.aglcropsystem.services.DealerService;


@SpringBootTest
public class DealerServiceTests {

    @Autowired
    DealerService   dealerService;

    @MockBean
    DealerRepository  dealerRepo;

    Dealer d1;
    

    @BeforeEach
    void setUp() throws Exception {
    	
     d1= new  Dealer();
        d1.setDealerId("131");
        d1.setFirstName("Prakash");
        d1.setLastName("Kumar");
        d1.setPhoneNumber("7406558848");
        d1.setEmail("prakash@gmail.com");
        d1.setUsername("prakash123");
        d1.setPassword("Prakash@123");
        
        
 
        }


/*
 * 	List<Dealer> getAllDealers();  
 */
@Test
  void testGetAllDealers() {
	List<Dealer> l1= new ArrayList<Dealer>();
	Dealer d2= new Dealer();
	    
	 d2.setDealerId("145");
     d2.setFirstName("Simpu");
     d2.setLastName("Kumar");
     d2.setPhoneNumber("9786453210");
     d2.setEmail("simpu@gmail.com");
     d2.setUsername("Simpu123");
     d2.setPassword("Simpu@123");
     
	   l1.add(d2);
	   l1.add(d1);
	   
	   Mockito.when(dealerRepo.findAll()).thenReturn(l1);
       assertThat(dealerService.getAllDealers()).isEqualTo(l1);
	   
}


    
    
/*
 * 	Dealer addDealer(Dealer dealer);
 */
  @Test
    void testAddDealer() {
        Mockito.when(dealerRepo.save(d1)).thenReturn(d1);
        assertThat(dealerService.addDealer(d1)).isEqualTo(d1);
    }

/*
 * 	Dealer updateDealer(Dealer dealer);
 */
    @Test
    void testUpdateDealer() {
        Mockito.when(dealerRepo.existsById(d1.getDealerId())).thenReturn(true);
        Mockito.when(dealerRepo.save(d1)).thenReturn(d1);
        assertThat(dealerService.updateDealer(d1)).isEqualTo(d1);
    }

    
 /*
  * void deleteDealer(String  dealerId);
  */
    @Test
    void testDeleteDealer() {
        Mockito.when(dealerRepo.existsById(d1.getDealerId())).thenReturn(true);
      assertThat(dealerService.deleteDealer(d1.getDealerId())).isEqualTo(" Dealer deleted successfully with Id131");

    }
    
}