package com.csi.sp.SpringNamApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages ={"com.csi.controller","com.csi.model","com.csi.dao"})
public class SpringNamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringNamApiApplication.class, args);
	}
}
