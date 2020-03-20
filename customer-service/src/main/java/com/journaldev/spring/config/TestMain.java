package com.journaldev.spring.config;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class TestMain {
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(TestMain.class);
	public static void main(String[] args) {

		 SpringApplication.run(TestMain.class, args);

	}

}
