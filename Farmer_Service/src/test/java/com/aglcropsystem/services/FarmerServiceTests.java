package com.aglcropsystem.services;




import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.aglcropsystem.model.Farmer;

import com.aglcropsystem.repository.FarmerRepository;
import com.aglcropsystem.service.FarmerService;


@SpringBootTest
public class FarmerServiceTests {

    @Autowired
    FarmerService   farmerService;

    @MockBean
    FarmerRepository  farmerRepo;

    Farmer f1;
    


    @BeforeEach
    void setUp() throws Exception {


    f1= new Farmer();
        f1.setFarmerId("121");
        f1.setFirstName("Rajesh");
        f1.setLastName("sahu");
        f1.setUsername("Raju123");
        f1.setPassword("Raju@123");
        
        f1.setEmail("rajesh@gmail.com");
        f1.setPhoneNumber("7406558848");
        
        f1.setLocation("Delhi");
        f1.setBank("Axis");
        
        f1.setAccountNo("123456789012345");
        f1.setBankbranch("Rourkela");
        f1.setAbout("this is all details of farmer");
        
        
         }
//	Farmer farmerLogin(String username, String password);
//	Farmer getFarmerById(String farmerId);

/*
 * 	List<Farmer> getAllFarmers();  
 */
@Test
  void testGetAllFarmers() {
	List<Farmer> l1= new ArrayList<Farmer>();
	Farmer f2= new Farmer();
	    f2.setFarmerId("131");
	    f2.setFirstName("Kunal");
	    f2.setLastName("sahu");
	    f2.setUsername("Raju123");
	    f2.setPassword("Raju@123");
	    
	    f2.setEmail("rajesh@gmail.com");
	    f2.setPhoneNumber("7406558848");
	    
	    f2.setLocation("Delhi");
	    f2.setBank("Axis");
	    
	    f2.setAccountNo("123456789012345");
	    f2.setBankbranch("Rourkela");
	   f2.setAbout("this is all details of farmer");
	   
	   l1.add(f2);
	   l1.add(f1);
	   
	   Mockito.when(farmerRepo.findAll()).thenReturn(l1);
       assertThat(farmerService.getAllFarmers()).isEqualTo(l1);
	   
}


    
    
/*
 * 	Farmer addFarmer(Farmer farmer);
 */
  @Test
    void testAddFarmer() {
        Mockito.when(farmerRepo.save(f1)).thenReturn(f1);
        assertThat(farmerService.addFarmer(f1)).isEqualTo(f1);
    }

/*
 * 	Farmer updateFarmer(Farmer farmer);
 */
    @Test
    void testUpdateFarmer() {
        Mockito.when(farmerRepo.existsById(f1.getFarmerId())).thenReturn(true);
        Mockito.when(farmerRepo.save(f1)).thenReturn(f1);
        assertThat(farmerService.updateFarmer(f1)).isEqualTo(f1);
    }

    
 /*
  * void deleteFarmer(String farmerId);
  */
    @Test
    void testDeleteFarmer() {
        Mockito.when(farmerRepo.existsById(f1.getFarmerId())).thenReturn(true);
      assertThat(farmerService.deleteFarmer(f1.getFarmerId())).isEqualTo(" Farmer deleted successfully with Id121");

    }
    
}