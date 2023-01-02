package com.example.RubySpringBootMvcAnnotationsApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RubySpringBootMvcAnnotationsApplication {
	static private Logger logger= LoggerFactory.getLogger(RubySpringBootMvcAnnotationsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RubySpringBootMvcAnnotationsApplication.class, args);
		logger.trace("Starting application in TRACE log level after spring start");
		logger.debug("Starting application in DEBUG log level after spring start");
		logger.info("Starting application in INFO log level after spring start");
		logger.warn("Starting application in WARN log level after spring start");
		logger.error("Starting application in ERROR log level after spring start");


	}


}
