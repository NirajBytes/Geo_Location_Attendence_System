package com.gpi.repository;

import com.gpi.entity.AdminForm;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends MongoRepository<AdminForm, String> {
	// Additional query methods can be defined here if needed
	List<AdminForm> findBySubjectCode(String myCode);

}
