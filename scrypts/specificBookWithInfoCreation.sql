create view specificBookWithInfo as
SELECT specificbook.inventoryNumber as inventoryNumber,
book.author AS author, 
		book.nameOfBook as nameOfBook,
        book.yearOfPublishing AS yearOfPublishing,
        book.amountOfPages as amountOfPages,
        specificbook.isHandedOut as isHandedOut
FROM book INNER JOIN specificbook ON book.nameOfBook = specificbook.booksName;

select * from specificBookWithInfo

