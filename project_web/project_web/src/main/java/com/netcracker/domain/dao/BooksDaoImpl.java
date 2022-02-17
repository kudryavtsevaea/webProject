package com.netcracker.domain.dao;

import com.netcracker.domain.model.BookWithInfo;
import com.netcracker.domain.services.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BooksDaoImpl implements BooksDao{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(BookWithInfo book) {
        bookRepository.getBookStorage().add(book);
    }

    @Override
    public void addListOfBooks(List<BookWithInfo> books) {
        bookRepository.getBookStorage().addAll(books);
    }

    @Override
    public void deleteBook(int bookId) {
        bookRepository.getBookStorage()
                .remove(bookRepository.getBookStorage().get(bookId));
    }

    @Override
    public void updateBook(BookWithInfo newBook) {
        int id = newBook.getInventoryNumber();
        bookRepository.getBookStorage().remove(id);
        bookRepository.getBookStorage().add(newBook);
    }

}
