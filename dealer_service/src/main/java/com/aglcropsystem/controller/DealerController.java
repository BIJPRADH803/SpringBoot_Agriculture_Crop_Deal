package com.aglcropsystem.controller;

import java.util.List;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.aglcropsystem.models.AuthenticationRequest;
import com.aglcropsystem.models.AuthenticationResponse;
import com.aglcropsystem.models.Dealer;
import com.aglcropsystem.services.DealerService;
import com.aglcropsystem.services.MyUserDetailsService;
import com.aglcropsystem.util.JwtUtil;



/*
 *  This controller class  contains basic crud operation
 */

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/dealer")
public class DealerController {

	/*
	 * employeeId:46195803 Created On:24-07-2022 Modified On:29-07-2022
	 * 
	 */
	 
		@Autowired
		private AuthenticationManager authenticationManager;

		@Autowired
		private JwtUtil jwtTokenUtil;

		@Autowired
		private MyUserDetailsService userDetailsService;

//		@Autowired
//		private RestTemplate restTemplate;
	 

	@Autowired
	private DealerService dealerService;

	private Logger LOGGER = LoggerFactory.getLogger(DealerController.class);
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	

	
	
	
	/*
	 * doDealerLogin() is used to login to the dealer dashboard
	 */

	@PostMapping("/dealer-login")
	public ResponseEntity<Dealer> doDealerLogin(@RequestParam("username") String username,
			@RequestParam("password") final String password) {

		LOGGER.info("dealer is logging-START");

		Dealer dealer = dealerService.dealerLogin(username, password);

		ResponseEntity<Dealer> responseEntity = new ResponseEntity<>(dealer, HttpStatus.OK);

		LOGGER.info("dealer logged in successfully-END");
		return responseEntity;

	}

	/*
	 * fetchAllDealers() is used to get list of all dealers
	 */
	@GetMapping("/allDealers")
	public List<Dealer> fetchAllDealers() {
		LOGGER.info("Inside fetchAllDealers of DealerController");
		List<Dealer> dealers= dealerService.getAllDealers();
		return dealers;
	}

	
	/*
	 * addDealer() is used to add dealer details
	 */
	@PostMapping("/save")
	public ResponseEntity<Dealer> addDealer(@Valid @RequestBody Dealer dealer) {
		LOGGER.info("Inside addDealers of  DealerController");
		Dealer newDealer = dealerService.addDealer(dealer);
		ResponseEntity<Dealer> responseEntity = new ResponseEntity<>(newDealer, HttpStatus.CREATED);
		return responseEntity;
	}
	
	

	/*
	 * fetchDealerById() is used to get detail of particular dealer
	 */
	
	@GetMapping("/get/{id}")
	public ResponseEntity<?> fetchDealerById(@PathVariable("id") String dealerId) {
		LOGGER.info("Inside fetchDealerById of dealerController");
		ResponseEntity<?> responseEntity = null;
		Dealer dealer = dealerService.getDealerById(dealerId);
		responseEntity = new ResponseEntity<>(dealer, HttpStatus.OK);
		return responseEntity;
	}


	/*
	 * deleteDealerById() is used to delete a single dealer detail
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteDealerById(@PathVariable("id") String dealerId) {
		LOGGER.info("Inside deleteDealerById of DealerController");
		ResponseEntity<String> responseEntity = null;
		dealerService.deleteDealer(dealerId);
		responseEntity = new ResponseEntity<>("Dealer deleted successfully", HttpStatus.OK);
		return responseEntity;
	}

	/*
	 * updateDealer() is used to update particular dealer detail
	 */
	
	
	 @PutMapping("/update")
	 public ResponseEntity<Object> updateDealer(@Valid @RequestBody Dealer dealer) {
		LOGGER.info("Inside updateDealer of DealerController");
		ResponseEntity<Object> responseEntity = null;
	  dealerService.updateDealer(dealer);
		responseEntity = new ResponseEntity<>("Dealer updated successfully", HttpStatus.OK);
		LOGGER.info("Dealer updated successfully");
		return responseEntity;
	}


	
	
	
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	//
//	@PostMapping("/dealer-login")
//	public ResponseEntity<Dealer> doDealerLogin(@RequestParam("username") String username,
//			@RequestParam("password") final String password) {
//
//		Dealer dealer = dealerService.dealerLogin(username, password);
//
//		ResponseEntity<Dealer> responseEntity = new ResponseEntity<>(dealer, HttpStatus.OK);
//
//		return responseEntity;
//
//	}

//	@GetMapping("/allDealers")
//	public List<Dealer> fetchAllDealers() {
//
//		List<Dealer> dealers = dealerService.getAllDealers();
//		return dealers;
//	}
	//
//	@PostMapping("/save")
//	public ResponseEntity<Dealer> addDealer(@Valid @RequestBody Dealer dealer) {
//
//		Dealer newDealer = dealerService.addDealer(dealer);
//		ResponseEntity<Dealer> responseEntity = new ResponseEntity<>(newDealer, HttpStatus.CREATED);
//		return responseEntity;
//	}
//	@GetMapping("/get/{id}")
//	public ResponseEntity<?> fetchDealerById(@PathVariable("id") String dealerId) {
//
//		ResponseEntity<?> responseEntity = null;
//		Dealer dealer = dealerService.getDealerById(dealerId);
//		responseEntity = new ResponseEntity<>(dealer, HttpStatus.OK);
//		return responseEntity;
//	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteDealerById(@PathVariable("id") String dealerId) {
//
//		return new ResponseEntity<>(dealerService.deleteDealer(dealerId), HttpStatus.OK);
//	}
	 

//		@PutMapping("/update")
//		public ResponseEntity<Object> updateDealer(@Valid @RequestBody Dealer dealer) {
	//
//			ResponseEntity<Object> responseEntity = null;
//			dealerService.updateDealer(dealer);
//			responseEntity = new ResponseEntity<>("Customer updated successfully", HttpStatus.OK);
//			return responseEntity;
//		}


//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<String> deleteDealerById(@PathVariable("id") String dealerId) {
//
//		ResponseEntity<String> responseEntity = null;
//		dealerservice.deleteDealer(dealerId);
//		responseEntity = new ResponseEntity<>("Dealer deleted successfully", HttpStatus.OK);
//		return responseEntity;
//	}
//	

}
