package com.aglcropsystem.services;



import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.aglcropsystem.model.Crops;
import com.aglcropsystem.repository.CropsRepo;
import com.aglcropsystem.service.CropsService;



@SpringBootTest
public class CropsServiceTests {

    @Autowired
    CropsService   cropsService;

    @MockBean
    CropsRepo cropsRepo;

   Crops c1;
    

    @BeforeEach
    void setUp() throws Exception {
    	
    c1= new  Crops();
     


        c1.setId("213");
        c1.setFarmerId("123");
        c1.setCropName("Potato");
        c1.setCropType("vegetables");
        c1.setQuantity(5.0);
        c1.setPrice(20.0);
        c1.setAddress("Andhra");
        
        
 
        }
 





/*
 * 	public List<Crops> getAllCrop();
 */
@Test
  void testGetAllCrop() {
	List<Crops> l1= new ArrayList<Crops>();
	Crops c2= new Crops();
	    

    c2.setId("512");
    c2.setFarmerId("123");
    c2.setCropName("tomato");
    c2.setCropType("vegetables");
    c2.setQuantity(6.0);
    c2.setPrice(30.0);
    c2.setAddress("cuttack");
     
	   l1.add(c2);
	   l1.add(c1);
	   
	   Mockito.when( cropsRepo.findAll()).thenReturn(l1);
       assertThat(cropsService.getAllCrop()).isEqualTo(l1);
	   
}


    
    
/*
 * 	 public Crops addCrop(Crops crop);
 */
  @Test
    void testAddCrop() {
        Mockito.when(cropsRepo.save(c1)).thenReturn(c1);
        assertThat(cropsService.addCrop(c1)).isEqualTo(c1);
    }

/*
 * 	public Crops updateCrop(Crops crop);
 */
//    @Test
//    void testUpdateCrop() {
//        Mockito.when(cropsRepo.existsById(c1.getId())).thenReturn(true);
//        Mockito.when(cropsService.save(c1)).thenReturn(c1);
//        assertThat(cropsService.updateCrop(c1)).isEqualTo(c1);
//    }

    
 /*
  * public String  deleteCrop(String cropId);
  */
    @Test
    void testDeleteCrop() {
        Mockito.when(cropsRepo.existsById(c1.getId())).thenReturn(true);
      assertThat(cropsService.deleteCropById(c1.getId())).isEqualTo(" Crop  deleted successfully with Id213");

    }
    
}