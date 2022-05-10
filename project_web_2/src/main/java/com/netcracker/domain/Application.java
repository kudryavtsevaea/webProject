package com.netcracker.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.repository.BookRepository;
import com.netcracker.domain.services.DataManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

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

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				//System.out.println(beanName);
			}

			List<Book> books = new ArrayList<>();

			try{
				PreparedStatement preparedStatement = DataManagerService.getInstance()
						//		.getConnection().prepareStatement("select * from LIBRARY.BOOKS");
						.getConnection().prepareStatement("select * from BOOKS");
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					books.add(new Book(resultSet.getInt(1), resultSet.getString(2),
							resultSet.getString(3), resultSet.getInt(4),
							resultSet.getInt(5), resultSet.getString(6), false));
					System.out.println();
				}
			}
			catch(SQLException e){
				e.printStackTrace();
			}

		bookRepository.saveAll(books);
		};
	}

}