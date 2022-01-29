package us.spring.edm.springedmcrudapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEdmCrudAppApplication {

	static final Logger logger  = LogManager.getLogger(SpringEdmCrudAppApplication.class.getName());
	public static void main(String[] args) {
		logger.info("Application Started");
		SpringApplication.run(SpringEdmCrudAppApplication.class, args);
	}

}
