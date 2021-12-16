use librarydb;

create table book (
	author VARCHAR (100) NOT NULL,
    nameOfBook VARCHAR (100) PRIMARY KEY,
    yearOfPublishing YEAR NOT NULL,
    amountOfPages INT NOT NULL
);


create table specificBook (
	inventoryNumber BIGINT PRIMARY KEY,
    booksName VARCHAR (100) NOT NULL,
    isHandedOut BOOL NOT NULL,
    FOREIGN KEY(booksName) REFERENCES book(nameOfBook)
);


create table reader (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    readerName VARCHAR (100) NOT NULL,
    hasBook BOOL NOT NULL,
    whichBook BIGINT,
	FOREIGN KEY(whichBook) REFERENCES specificBook(inventoryNumber)
);

create table library (
	specificBook BIGINT,
    FOREIGN KEY(specificBook) REFERENCES specificBook(inventoryNumber)
);



