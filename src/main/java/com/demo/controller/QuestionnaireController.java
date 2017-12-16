package com.demo.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.model.Questionnaire;
import com.demo.model.QuestionnaireRepository;
import org.springframework.cloud.client.discovery.DiscoveryClient;



@RestController
@RequestMapping("/Questionnaire")
public class QuestionnaireController {
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@Autowired
	RestTemplate restTemplate;
	
	private QuestionnaireRepository questionnaireRepository;
	
	@Autowired
	public QuestionnaireController(QuestionnaireRepository repository){
		this.questionnaireRepository = repository;
	}
	
	@GetMapping("/findall")   //find all
	public List<Questionnaire> findAll(){
		return questionnaireRepository.findAll();
	}
	
	@GetMapping(value="/findbyId/{id}")   //Find By Id
	public Questionnaire findById(@PathVariable("id") BigInteger id){
		return questionnaireRepository.findOne(id);
	}
	
	@PostMapping(value="/create")
	public ResponseEntity<Questionnaire>  add(@RequestBody Questionnaire questionnaire){
		questionnaire.setqNumber(questionnaire.getqNumber());
		questionnaire.setqType(questionnaire.getqType());
		questionnaire.setqName(questionnaire.getqName());
		questionnaire.setQuestion(questionnaire.getQuestion());
		questionnaire.setAnswer(questionnaire.getAnswer());
		questionnaire.setProcessor(questionnaire.getProcessor());
		questionnaire.setActivity(questionnaire.getActivity());
		questionnaire.setRiskLevel(questionnaire.getRiskLevel());
		questionnaire.setCreatedBy(questionnaire.getCreatedBy());
		questionnaire.setModifiedBy(questionnaire.getModifiedBy());
		questionnaire.setCreatedAt(questionnaire.getCreatedAt());
		questionnaire.setModifiedAt(questionnaire.getModifiedAt());
		Questionnaire adquQuestionnaire = questionnaireRepository.save(questionnaire);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Questionnaire>(adquQuestionnaire, headers, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/update/{id}")
	public Questionnaire updateById(@PathVariable("id") BigInteger id,  @RequestBody Questionnaire updatedQuestionnaire){
		updatedQuestionnaire.setqNumber(updatedQuestionnaire.getqNumber());
		updatedQuestionnaire.setqType(updatedQuestionnaire.getqType());
		updatedQuestionnaire.setqName(updatedQuestionnaire.getqName());
		updatedQuestionnaire.setQuestion(updatedQuestionnaire.getQuestion());
		updatedQuestionnaire.setAnswer(updatedQuestionnaire.getAnswer());
		updatedQuestionnaire.setProcessor(updatedQuestionnaire.getProcessor());
		updatedQuestionnaire.setActivity(updatedQuestionnaire.getActivity());
		updatedQuestionnaire.setRiskLevel(updatedQuestionnaire.getRiskLevel());
		updatedQuestionnaire.setCreatedBy(updatedQuestionnaire.getCreatedBy());
		updatedQuestionnaire.setModifiedBy(updatedQuestionnaire.getModifiedBy());
		updatedQuestionnaire.setCreatedAt(updatedQuestionnaire.getCreatedAt());
		updatedQuestionnaire.setModifiedAt(updatedQuestionnaire.getModifiedAt());
		return questionnaireRepository.save(updatedQuestionnaire);
	}
	
	@DeleteMapping(value="/deleteById/{id}")
	public void deleteById(@PathVariable("id") BigInteger id){
		questionnaireRepository.delete(id);
	}
	
	@DeleteMapping(value="/deleteAll")
	public void deleteAll(){
		questionnaireRepository.deleteAll();
	}
	
	@GetMapping("/register")
	public String register() throws InterruptedException{
		String services = "Services:" + discoveryClient.getServices();
		return  services;
	}
	
}

