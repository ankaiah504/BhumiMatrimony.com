package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApplicationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaApplicationServerApplication.class, args);
	}

}
