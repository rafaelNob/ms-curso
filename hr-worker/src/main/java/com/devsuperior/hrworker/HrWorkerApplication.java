package com.devsuperior.hrworker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.devsuperior.hrworker.controller.WorkerController;

@SpringBootApplication
@EnableEurekaClient
public class HrWorkerApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(HrWorkerApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(HrWorkerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
