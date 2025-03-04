package com.ttnAssignment.Assignment2SpringBoot;

import com.ttnAssignment.Assignment2SpringBoot.config.Appconfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Assignment2SpringBootApplication {

	@Autowired
	private Appconfig appconfig;

	public static void main(String[] args) {
	ApplicationContext applicationContext= SpringApplication.run(Assignment2SpringBootApplication.class, args);

	ImplementationOfQues_2 implementation=applicationContext.getBean(ImplementationOfQues_2.class);
	implementation.showProperties();


	}

}
