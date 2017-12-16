package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.demo.model.QuestionnaireRepository;

@EnableDiscoveryClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
public class QuestionnaireApplication implements CommandLineRunner {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Autowired
	private QuestionnaireRepository questionnaireRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(QuestionnaireApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
//		questionnaireRepository.save(new Questionnaire((long) 00001,"test"));
//		System.out.println(questionnaireRepository.findAll());
	}
}
