package com.netcracker.domain.dao;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.services.BookRepository;

import java.util.List;

public class BooksDaoImpl implements BooksDao{
    private BookRepository bookRepository = BookRepository.getInstance();

    @Override
    public void addBook(Book book) {
        bookRepository.getBookStorage().add(book);
    }

    @Override
    public void addListOfBooks(List<Book> books) {
        bookRepository.getBookStorage().addAll(books);
    }

    @Override
    public void deleteUser(Book book) {
        bookRepository.getBookStorage().remove(book);
    }

    @Override
    public void updateUser(Book oldBook, Book newBook) {
        bookRepository.getBookStorage().remove(oldBook);
        bookRepository.getBookStorage().add(newBook);
    }
}
