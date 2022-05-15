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

//			jdbcTemplate.execute(
//					"insert into books values (180932, 'Д.Керуак', 'Бродяги Дхармы', 1958, 173, 'Роман одного из важнейших представителей литературы бит-поколения, Джека Керуака. Произведение было издано в 1958 году издательством Viking Press');" +
//					"insert into books values (79787, 'А.Дюма', 'Три мушкетера', 1844, 680, 'Историко-приключенческий роман Александра Дюма-отца, впервые опубликованный в парижской газете Le Siècle в 1844 году с 14 марта по 11 июля. Книга посвящена приключениям молодого дворянина по имени д’Артаньян, отправившегося в Париж, чтобы стать мушкетёром, и трёх его друзей-мушкетёров Атоса, Портоса и Арамиса в период между 1625 и 1628 годами. История д’Артаньяна продолжается в двух других романах трилогии: «Двадцать лет спустя» и «Виконт де Бражелон, или Десять лет спустя».');" +
//					"insert into books values (109789, 'А.С.Пушкин', 'Евгений Онегин', 1833, 400, 'Роман в стихах русского писателя и поэта Александра Сергеевича Пушкина, написанный в 1823—1830 годах, одно из самых значительных произведений русской словесности. Повествование ведётся от имени безымянного автора, который представился добрым приятелем Онегина.');" +
//					"insert into books values (6793, 'М.Ю.Лермонтов', 'Бородино', 1837, 2, 'Стихотворение поэта Михаила Юрьевича Лермонтова. Было написано в начале 1830-х годов. Опубликовано в журнале «Современник» в 1837 году. Посвящено Бородинскому сражению 7 сентября 1812 года, в котором русская армия сражалась против французского наполеоновского войска.');" +
//					"insert into books values (8293, 'О.Уальд', 'Портрет Дориана Грея', 1890, 320, 'Единственный роман Оскара Уайльда. В жанровом отношении представляет смесь романа воспитания с моральной притчей; оказался самым успешным произведением Уайльда, экранизировался в разных странах мира более 30 раз.');" +
//					"insert into books values (32098, 'Н.Гейман', 'Никогде', 2009, 464, 'Роман Нила Геймана в жанре городское фэнтези. Это новелизация его собственного сценария для одноимённого сериала. «Никогде» стало первым «сольным» романом Геймана, до этого он выпустил только «Благие знамения» в соавторстве с Терри Пратчеттом.');" +
//					"insert into books values (8888, 'Дж.Д.Сэлинджер', 'Над пропастью во ржи', 1951, 213, 'Роман американского писателя Джерома Сэлинджера, входит в 100 мировых книг. В ней от лица 16-летнего юноши по имени Холден откровенно рассказывается о его обострённом восприятии американской действительности и неприятии общих канонов и морали современного общества.');" +
//					"insert into books values(9182943, 'Л.Н.Толстой', 'Война и мир', 1867, 1225, 'Роман-эпопея Льва Николаевича Толстого, описывающий русское общество в эпоху войн против Наполеона в 1805—1812 годах. Эпилог романа доводит повествование до 1820 года.');"
//			);

			List<Book> books = jdbcTemplate.query("select * from books",
					(rs, rowNum) -> new Book(rs.getString(2),rs.getString(3),
					rs.getInt(4), rs.getInt(5),
					rs.getString(6))).stream().collect(Collectors.toList());

			bookRepository.saveAll(books);
			books.forEach(System.out::println);


		};

	}


}