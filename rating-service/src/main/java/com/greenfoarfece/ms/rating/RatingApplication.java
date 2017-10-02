package com.greenfoarfece.ms.rating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RatingApplication {
	
	public static void main(String... args) {
		SpringApplication.run(RatingApplication.class, args);
	}

}
