package com.demo.spring.boot.assignment.DemoStudentSpringBootApp;

import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration                
@ComponentScan (basePackages = {"com.demo.spring.boot.assignment"})
@EnableMongoRepositories ("com.demo.spring.boot.assignment.repository")
public class DemoStudentSpringBootAppApplication {

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication.run(DemoStudentSpringBootAppApplication.class, args);
    }
}
