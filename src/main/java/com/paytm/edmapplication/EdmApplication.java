package com.paytm.edmapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EdmApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdmApplication.class, args);
	}

}
