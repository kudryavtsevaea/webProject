use librarydb;

create table Reader(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Reader_name VARCHAR(100)
);

create table Authour(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Author_name VARCHAR(100)
);

create table Name_of_book(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Name_of_book VARCHAR(100)
);

create table Info(
	Id INT,
    Info_text VARCHAR(10000)
);

create table Book(
	Inventory_number INT PRIMARY KEY AUTO_INCREMENT,
    Year_of_publishing INT,
    Page_amount INT,
    Is_handed_out BOOL
);

create table Book_turnover(
	Inventory_number INT,
    Reader_id INT,
    Date_of_getting DATE,
    FOREIGN KEY(Inventory_number) REFERENCES Book(Inventory_number),
    FOREIGN KEY(Reader_id) REFERENCES Reader(Id)
);
