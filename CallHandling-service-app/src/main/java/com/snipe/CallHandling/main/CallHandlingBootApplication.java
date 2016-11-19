package com.snipe.CallHandling.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication      
public class CallHandlingBootApplication {       
	  
	@Bean  
	public PropertySourcesPlaceholderConfigurer configurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}  
           
	public static void main(String[] args) {  
		SpringApplication.run(CallHandlingBootApplication.class, args);  
	}                           
	                                                           
	@Bean                   
	public RestTemplate restTemplateWithoutEureka(){
		return new RestTemplate();   
	}          
}                      
                               