package com.aglcropsystem.service;

import java.util.List;


import com.aglcropsystem.model.Crops;

public interface CropsService {
	
	
	   Crops addCrop(Crops crop);

	   List<Crops> getAllCrop();
	
	//public void deleteCrop(String cropId);
	 
       String  deleteCropById(String cropId);

	   Crops updateCrop(Crops crop);
	   public int getSequenceNumber(String sequenceName);
	
       Crops getCropsById(String id);



	
}
