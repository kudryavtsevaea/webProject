package com.netcracker.domain;

import com.netcracker.domain.services.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@SpringBootApplication
public class ProjectWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectWebApplication.class, args);
	}

}
