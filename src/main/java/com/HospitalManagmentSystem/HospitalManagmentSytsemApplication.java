package com.HospitalManagmentSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class HospitalManagmentSytsemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalManagmentSytsemApplication.class, args);
	}
	 @Bean
	   public RestTemplate employeeTemplate() {
		   return new RestTemplate();
	   }
	
}
