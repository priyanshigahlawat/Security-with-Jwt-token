package com.example.studentsLog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class StudentsLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsLogApplication.class, args);
	}

}
