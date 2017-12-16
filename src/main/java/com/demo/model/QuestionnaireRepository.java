package com.demo.model;



import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionnaireRepository extends MongoRepository<Questionnaire, BigInteger>{
	
}
