package com.example.Rubyspringbootdemo;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class RubyspringbootdemoApplication {

	private static Logger logger = LoggerFactory.getLogger(RubyspringbootdemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RubyspringbootdemoApplication.class, args);
		logger.info("Application started");
		logger.error("Error in application");

	}

}
