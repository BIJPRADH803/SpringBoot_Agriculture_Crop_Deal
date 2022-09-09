package com.aglcropsystem.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.aglcropsystem.model.Crops;
import com.aglcropsystem.service.CropsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/crop")
public class CropsController {
	/*
	 * employeeId:46195803
	 * Author:Bijay Pradhan
	 * Created On:21-07-2022
	 * 
	 * Modified On:29-07-22
	 */

	@Autowired
	private CropsService cropsService;
	
	private Logger LOGGER = LoggerFactory.getLogger(CropsController.class);
	
	
	@GetMapping("/allCrops")
	public ResponseEntity<List<Crops>> getAllCrop() {
		LOGGER.info("Inside getAllCrops of CropsController");
		List<Crops> allCrops = cropsService.getAllCrop();
		LOGGER.info("Crops viewed Successfully");
		ResponseEntity<List<Crops>> responseEntity = new ResponseEntity<List<Crops>>(allCrops, HttpStatus.FOUND);
		LOGGER.info("Get Crops -End");
		return responseEntity;
	}



	
	@GetMapping("/crop/{id}")
	public ResponseEntity<Crops> fetchCropById(@PathVariable("id") String id) {
		LOGGER.info("Inside fetchProductById of ProductController");
		Crops crop = cropsService.getCropsById(id);
		LOGGER.info("Fetching Product");
		ResponseEntity<Crops> responseEntity = new ResponseEntity<Crops>(crop, HttpStatus.FOUND);
		LOGGER.info("Fetch Product -END!");
		return responseEntity;
	}
	


	@PostMapping("/addCrop")
	public ResponseEntity<Crops> addProduct(@Valid @RequestBody Crops crop) {
		LOGGER.info("Inside addCrop of  CropsController");
		Crops newCrop = cropsService.addCrop(crop);
		LOGGER.info("Crop added Successfully");
		ResponseEntity<Crops> responseEntity = new ResponseEntity<>(newCrop, HttpStatus.CREATED);
		LOGGER.info("Add crop -END!");
		return responseEntity;
	}


	@PutMapping("/update")
	public ResponseEntity<Crops> updateCrop(@Valid @RequestBody Crops crop) {
		LOGGER.info("Inside updateCrop of CropsController");
		Crops updatedCrop = cropsService.updateCrop(crop);
		LOGGER.info("Updating Crop");
		ResponseEntity<Crops> responseEntity = new ResponseEntity<Crops>(updatedCrop, HttpStatus.CREATED);
		LOGGER.info("Update Product -END!");
		return responseEntity;
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCropById(@PathVariable("id") String cropId) {
		LOGGER.info("Inside deleteCropById of CropsController");
		cropsService.deleteCropById(cropId);
		LOGGER.info("Deleting Crop");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>("Crop deleted successfully",
				HttpStatus.OK);
		LOGGER.info("Delete Crop -END!");
		return responseEntity;
	}
	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@GetMapping("/allcrop")
//	public List<Crops> getAllCropsDetails() {
//		return cropsService.getAllCrop();
//	}
//	@GetMapping("/crop/{id}")
//	public Crops getCropsDetails(@PathVariable String id) {
//		return cropsService.getCropsById(id);
//	}
//
//	
//	@PostMapping("/addcrop")
//	public ResponseEntity<Crops> addCropDetails( @RequestBody Crops crop) {
//
//		Crops newcrops =cropsService.addCrop(crop);
//		ResponseEntity<Crops> responseEntity = new ResponseEntity<>(newcrops, HttpStatus.CREATED);
//		return responseEntity;
//	}

//	@PutMapping("/crop/{id}")
//	public void updateCropsDetails(@PathVariable String id, @RequestBody Crops crop) {
//		cropsService.updateCrop(crop);
//	}
	
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteCropById(@PathVariable("id") String cropId) {
//
//       return new ResponseEntity<>(cropsService.deleteCrop(cropId), HttpStatus.OK);
//	}
//
//	
	
	
	
	
//	@DeleteMapping("/delete/{id}")
//	public void deleteCropsDetails(@PathVariable("id")String cropId) {
//		cropsService.deleteCrop(cropId);
//	}
	
	
	
}
