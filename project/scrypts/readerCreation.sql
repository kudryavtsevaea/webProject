insert into reader (readerName, hasBook, whichBook) values ('Иванов Иван', 0, null);

insert into reader (readerName, hasBook, whichBook) values ('Васильева Анна', 1, 109376);

insert into reader (readerName, hasBook, whichBook) values ('Билоус Антон', 1, 888780);

insert into reader (readerName, hasBook, whichBook) values ('Лисичкин Павел', 0, null);

insert into reader (readerName, hasBook, whichBook) values ('Исмаилова Эльвина', 1, 991123);

insert into reader (readerName, hasBook, whichBook) values ('Королёва Татьяна', 0, null);

insert into reader (readerName, hasBook, whichBook) values ('Пронин Антон', 1, 756476);

insert into reader (readerName, hasBook, whichBook) values ('Щеглова Елизавета', 1, 172946);

insert into reader (readerName, hasBook, whichBook) values ('Осинкин Роман', 0, null);

CREATE VIEW readerWithBook AS
SELECT reader.readerName AS readerName, 
		hasBook AS hasBook,
        specificbook.booksName AS whichBook
FROM reader INNER JOIN specificbook ON reader.whichBook = specificbook.inventoryNumber;
