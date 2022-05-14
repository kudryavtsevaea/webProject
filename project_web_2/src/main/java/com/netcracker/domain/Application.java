package com.netcracker.domain;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Application {

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			List<Book> books = jdbcTemplate.query("select * from books",
					(rs, rowNum) -> new Book(rs.getString(2),rs.getString(3),
					rs.getInt(4), rs.getInt(5),
					rs.getString(6))).stream().collect(Collectors.toList());

			bookRepository.saveAll(books);
			books.forEach(System.out::println);


		};

	}


}