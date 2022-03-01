package com.netcracker.domain.dao;

import com.netcracker.domain.model.Book;

public interface BooksDao {
    void addBook(Book book);
    void deleteBook(int bookId);
    void updateBook(Book newBook);
    Book getById(int id);
}

