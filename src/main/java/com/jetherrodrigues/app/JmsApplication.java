package com.jetherrodrigues.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.jetherrodrigues")
@EntityScan("com.jetherrodrigues.domain")
@EnableMongoAuditing
@EnableReactiveMongoRepositories(basePackages = {
		"com.jetherrodrigues.repository"
})
public class JmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmsApplication.class, args);
	}

}

