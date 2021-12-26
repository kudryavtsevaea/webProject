use librarydb2;

create table book (
	inventory_number BIGINT NOT NULL AUTO_INCREMENT,
	author VARCHAR (100) NOT NULL,
    book_name VARCHAR (100) NOT NULL,
    year_of_publishing YEAR NOT NULL,
    amount_of_pages INT NOT NULL,
    is_handed_out BOOL NOT NULL,
    PRIMARY KEY(inventory_number)
);

insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('А.С. Пушкин', 'Капитанская дочка', 1936, 384, false);
insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('А.С. Пушкин', 'Евгений Онегин', 1933, 448, false);
insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('Г. Гессе', 'Сиддхартха', 1922, 152, false);
insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('Д. Керуак', 'Бродяги Дхармы', 1958, 187, false);
insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('Г. Флобер', 'Госпожа Бовари', 1956, 384, false);
insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('Л.Н. Толстой', 'Анна Каренина', 1977, 800, false);
insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('В.В. Набоков', 'Лолита', 1955, 416, false);
insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('А. Дюма', 'Три мушкетёра', 1944, 680, false);
insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('М.А. Булгаков', 'Собачье сердце', 1925, 320, false);
insert book(author, book_name, year_of_publishing, amount_of_pages, is_handed_out) values ('П. Зюскинд', 'Парфюмер', 1985, 320, false);

create table reader (
	id BIGINT NOT NULL AUTO_INCREMENT,
    readerName VARCHAR (100) NOT NULL,
    PRIMARY KEY(id)
);

insert into reader (readerName) values ('Иванов Иван');
insert into reader (readerName) values ('Васильева Анна');
insert into reader (readerName) values ('Билоус Антон');
insert into reader (readerName) values ('Лисичкин Павел');
insert into reader (readerName) values ('Исмаилова Эльвина');
insert into reader (readerName) values ('Королёва Татьяна');
insert into reader (readerName) values ('Пронин Антон');
insert into reader (readerName) values ('Щеглова Елизавета');
insert into reader (readerName) values ('Осинкин Роман');

create table book_turnover (
	inventory_number BIGINT NOT NULL,
    reader_id BIGINT NOT NULL,
	date_of_getting DATE NOT NULL,
    FOREIGN KEY(inventory_number) REFERENCES book(inventory_number),
    FOREIGN KEY(reader_id) REFERENCES reader(id)
);

create table library (
	FOREIGN KEY(book_inventory_number) REFERENCES book(inventory_number)
);


create view book_turnover_with_info as
select book_turnover.reader_id, book.inventory_number, book.author, book.book_name,
book.year_of_publishing, book.amount_of_pages, date_of_getting, book.is_handed_out
from book inner join book_turnover on book.inventory_number = book_turnover.inventory_number;

create view book_turnover_with_info2 as
select reader.readerName, book_turnover_with_info.inventory_number, book_turnover_with_info.author, 
book_turnover_with_info.book_name, book_turnover_with_info.year_of_publishing, 
book_turnover_with_info.amount_of_pages, book_turnover_with_info.date_of_getting,  
book_turnover_with_info.is_handed_out
from reader inner join  book_turnover_with_info on  book_turnover_with_info.reader_id = reader.id