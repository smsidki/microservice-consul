package com.greenfoarfece.ms.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryApplication {
	
	public static void main(String... strings) {
		SpringApplication.run(DiscoveryApplication.class, strings);
	}

}
