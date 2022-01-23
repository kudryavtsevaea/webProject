package com.netcracker.controller;

import com.netcracker.dao.BooksDao;
import com.netcracker.dao.BooksDaoImpl;
import com.netcracker.models.Book;


public class OperationsWithBooks {
    private BooksDao books = new BooksDaoImpl();


    public void showAllBooks() {
        if (books.getAllBooks().isEmpty()){
            System.out.println("Извините, в библиотеке нет книг.");
        }
        else {
            books.getAllBooks().forEach(System.out::println);
        }
    }

    public void addListOfBooks(String path){
        books.addFromFile(path);
    }

    public void searchByRegex(String requiredString){
        books.getBookByRegex(requiredString).forEach(System.out::println);
    }

    public void deleteBook(String[] deletableBook){
       Book book = new Book(Integer.parseInt(deletableBook[0]), deletableBook[1], deletableBook[2],
               Integer.parseInt(deletableBook[3]), Integer.parseInt(deletableBook[4]));
        books.deleteBook(book);
    }

    public void addBook(String[] book){
        Book newBook = new Book(Integer.parseInt(book[0]), book[1], book[2],
                Integer.parseInt(book[3]), Integer.parseInt(book[4]));
       books.addBook(newBook);

    }

    public void updateBook(Book oldBook, String[] book){
        books.updateBook(oldBook, new Book(Integer.parseInt(book[0]),book[1], book[2], Integer.parseInt(book[3]),
                Integer.parseInt(book[4])));
    }
}
