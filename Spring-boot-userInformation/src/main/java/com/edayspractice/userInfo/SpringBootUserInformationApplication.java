package com.edayspractice.userInfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;


@CrossOrigin(origins = "http://localhost:3000")
@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableHystrix
@EnableEurekaClient
@EnableCircuitBreaker
public class SpringBootUserInformationApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootUserInformationApplication.class, args);
		//System.out.println("UserInformation Application");
	}
//java developer to be changes
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {

		return new RestTemplate();
	}
}
