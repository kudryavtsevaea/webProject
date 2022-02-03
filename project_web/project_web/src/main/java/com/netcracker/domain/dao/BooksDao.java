package com.netcracker.domain.dao;

import com.netcracker.domain.model.Book;

import java.util.List;

public interface BooksDao {
    void addBook(Book book);
    void addListOfBooks(List<Book> books);
    void deleteUser(Book book);
    void updateUser(Book oldBook, Book newBook);
}
