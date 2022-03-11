package com.netcracker.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import javax.swing.tree.TreePath;

@SpringBootApplication
public class Application {

	public static void main(String[] args)
	{
		SpringApplication.run(Application.class, args);
	}

	@Autowired
	BookRepository bookRepository;
	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
			//System.out.println("Create  Random Books for Tests");

			List<Book> generatedBooks = IntStream.range(0, 100).boxed()
					.map(booknumber -> new Book(
							booknumber,
							"author"+booknumber,
							"bookName"+booknumber,
							1800+booknumber,
							booknumber,
							"info"+booknumber,
							false
							))
					.collect(Collectors.toList());


		//	generatedBooks.forEach(System.out::println);
		//	System.out.println(jdbcTemplate);

			bookRepository.saveAll(generatedBooks);

			List<Book> books = jdbcTemplate.query("select * from books", new RowMapper<Book>() {
				@Override
				public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
					return null;
				}
			});

		};
	}

}