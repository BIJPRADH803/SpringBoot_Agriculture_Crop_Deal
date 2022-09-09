package com.aglcropsystem.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.aglcropsystem.exceptions.AdminNotFoundException;
import com.aglcropsystem.models.Admin;
import com.aglcropsystem.models.DatabaseSequence;
import com.aglcropsystem.repository.AdminRepo;

@Service
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepo adminrepo;

	Logger logger = LoggerFactory.getLogger(AdminServiceImplementation.class);

	@Override
	public List<Admin> findAll() {
		// TODO Auto-generated method stub
		logger.info("Getting Admin list");
		List<Admin> admin = adminrepo.findAll();
		logger.info(" Successfull search of all admins");
		return admin;
	}

	
	
//	@Override
//	public Admin adminLogin(String name, String password) {
//	
//		Admin  admin = adminrepo.findByUsernameAndPassword(name, password);
//
//	if (admin == null) {
//		throw new AuthenticationFailureException("Username or password is incorrect");
//		}
//
//		return admin;
//	}
	

	@Override
	public void saveAdmin(Admin admin) {
		// TODO Auto-generated method stub
		logger.info("Adding Admins");
		adminrepo.save(admin);
		logger.info("Admin added Successfully");
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		logger.info("Updating Admin");
		Optional<Admin> optionalAdmin = adminrepo.findById(admin.getId());

		if (optionalAdmin == null) {
			throw new AdminNotFoundException("Admin not exising with id: " + admin.getId());
		}
		adminrepo.save(admin);
		logger.info("Admin Updated Successfully");

	}

	@Override
	public void deleteAdmin(int id) {
		// TODO Auto-generated method stub
		logger.info("Deleting admin by id");
		Optional<Admin> optionalAdmin = adminrepo.findById(id);

		if (optionalAdmin == null) {
			throw new AdminNotFoundException("Admin not exising with id: " + id);
		}

		Admin student = optionalAdmin.get();

		adminrepo.delete(student);
		logger.info("Admin Deleted Successfully");
	}

	@Autowired
	private MongoOperations mongoOperations;

	public int getSequenceNumber(String sequenceName) {
		// get sequence no
		Query query = new Query(Criteria.where("id").is(sequenceName));
		// update the sequence no
		Update update = new Update().inc("seq", 1);
		// modify in document
		DatabaseSequence counter = mongoOperations.findAndModify(query, update, options().returnNew(true).upsert(true),
				DatabaseSequence.class);

		return (int) (!Objects.isNull(counter) ? counter.getSeq() : 1);

	}

}
