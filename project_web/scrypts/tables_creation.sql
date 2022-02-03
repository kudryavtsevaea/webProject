use libraryWeb;

create table Reader(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Reader_name VARCHAR(100)
);

insert into Reader values (1, 'Билоус Антон');
insert into Reader values (2, 'Королева Татьяна');
insert into Reader values (3, 'Григорьев Александр');
insert into Reader values (4, 'Косыч Илья');
insert into Reader values (5, 'Барсукова Варвара');
insert into Reader values (6, 'Мкоян Карен');

create table Authour(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Author_name VARCHAR(100)
);

insert into Authour values (1, 'А.С.Пушкин');
insert into Authour values (2,'М.Ю.Лермонтов');
insert into Authour values (3,'М.А.Булгаков');
insert into Authour values (4,'Дж.Д.Сэлинджер');
insert into Authour values (5,'Д.Керуак');
insert into Authour values (6,'Н.Гейман');
insert into Authour values (7,'Л.Н.Толстой');
insert into Authour values (8,'Ф.М.Достоевский');
insert into Authour values (9,'А.Дюма');
insert into Authour values (10,'О.Уальд');

create table Name_of_book(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Name_of_book VARCHAR(100)
);

insert into Name_of_book values(1,'Бродяги Дхармы');
insert into Name_of_book values(2,'Три мушкетера');
insert into Name_of_book values(3,'Евгений Онегин');
insert into Name_of_book values(4,'Бородино');
insert into Name_of_book values(5,'Портрет Дориана Грея');
insert into Name_of_book values(6,'Никогде');
insert into Name_of_book values(7,'Над пропастью во ржи');
insert into Name_of_book values(8,'Война и мир');

create table Info(
	Id INT PRIMARY KEY AUTO_INCREMENT,
    Info_text VARCHAR(10000)
);

insert into Info values(1, 'Роман одного из важнейших представителей литературы бит-поколения, Джека Керуака. Произведение было издано в 1958 году издательством Viking Press.');
insert into Info values(2, 'Историко-приключенческий роман Александра Дюма-отца, впервые опубликованный в парижской газете Le Siècle в 1844 году с 14 марта по 11 июля. Книга посвящена приключениям молодого дворянина по имени д’Артаньян, отправившегося в Париж, чтобы стать мушкетёром, и трёх его друзей-мушкетёров Атоса, Портоса и Арамиса в период между 1625 и 1628 годами. История д’Артаньяна продолжается в двух других романах трилогии: «Двадцать лет спустя» и «Виконт де Бражелон, или Десять лет спустя».');
insert into Info values(3, 'Роман в стихах русского писателя и поэта Александра Сергеевича Пушкина, написанный в 1823—1830 годах, одно из самых значительных произведений русской словесности. Повествование ведётся от имени безымянного автора, который представился добрым приятелем Онегина.');
insert into Info values(4, 'Стихотворение поэта Михаила Юрьевича Лермонтова. Было написано в начале 1830-х годов. Опубликовано в журнале «Современник» в 1837 году. Посвящено Бородинскому сражению 7 сентября 1812 года, в котором русская армия сражалась против французского наполеоновского войска.');
insert into Info values(5, 'Единственный роман Оскара Уайльда. В жанровом отношении представляет смесь романа воспитания с моральной притчей; оказался самым успешным произведением Уайльда, экранизировался в разных странах мира более 30 раз.');
insert into Info values(6, 'Роман Нила Геймана в жанре городское фэнтези. Это новелизация его собственного сценария для одноимённого сериала. «Никогде» стало первым «сольным» романом Геймана, до этого он выпустил только «Благие знамения» в соавторстве с Терри Пратчеттом.');
insert into Info values(7, 'Роман американского писателя Джерома Сэлинджера, входит в 100 мировых книг. В ней от лица 16-летнего юноши по имени Холден откровенно рассказывается о его обострённом восприятии американской действительности и неприятии общих канонов и морали современного общества.');
insert into Info values(8, 'Роман-эпопея Льва Николаевича Толстого, описывающий русское общество в эпоху войн против Наполеона в 1805—1812 годах. Эпилог романа доводит повествование до 1820 года.');

create table Book(
	Inventory_number INT PRIMARY KEY AUTO_INCREMENT,
    Authour_id INT,
    Name_of_book_id INT,
    Year_of_publishing INT,
    Page_amount INT,
    Info_id INT,
    Is_handed_out BOOL,
    FOREIGN KEY (Authour_id) REFERENCES Authour(Id),
    FOREIGN KEY (Name_of_book_id) REFERENCES Name_of_book(Id)
);

insert into Book values(1, 5, 1, 1958, 173, 1, 0);
insert into Book values(2, 9, 2, 1844, 680, 2 , 0);
insert into Book values(3, 1, 3, 1833, 400, 3, 0);
insert into Book values(4, 2, 4, 1837, 2, 4, 0);
insert into Book values(5, 10, 5, 1890, 320, 5, 0);
insert into Book values(6, 6, 6, 2009, 464, 6, 0);
insert into Book values(7, 4, 7, 1951, 213, 7, 0);
insert into Book values(8, 7, 8, 1867, 1225, 8, 0);

create table Book_turnover(
	Inventory_number INT,
    Reader_id INT,
    Date_of_getting DATE,
    FOREIGN KEY(Inventory_number) REFERENCES Book(Inventory_number),
    FOREIGN KEY(Reader_id) REFERENCES Reader(Id)
);
