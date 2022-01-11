package com.netcracker.dao;

import com.netcracker.models.Book;

import java.util.List;

public interface BooksDao {
    List<Book> getAllBooks();
    List<Book> getBookByRegex(String reg);
    boolean addBook(Book book);
    boolean deleteBook(Book book);
    boolean updateBook(Book oldBook, Book newBook);
    List<Book> addFromFile(String path);

}
