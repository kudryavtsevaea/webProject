package com.netcracker.domain.dao;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.model.BookWithInfo;

import java.util.List;

public interface BooksDao {
    void addBook(BookWithInfo book);
    void addListOfBooks(List<BookWithInfo> books);
    void deleteBook(int bookId);
    void updateBook(BookWithInfo newBook);
}
