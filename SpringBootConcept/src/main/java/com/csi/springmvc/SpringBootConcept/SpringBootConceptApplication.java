package com.csi.springmvc.SpringBootConcept;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.csi.controller","com.csi.dao","com.csi.model"})
public class SpringBootConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConceptApplication.class, args);
	}

}
