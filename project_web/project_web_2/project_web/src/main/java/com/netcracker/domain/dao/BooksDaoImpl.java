package com.netcracker.domain.dao;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BooksDaoImpl implements BooksDao{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.getBookStorage().add(book);
    }

    @Override
    public void deleteBook(int bookId) {
        bookRepository.getBookStorage()
                .remove(bookRepository.getBookStorage().get(bookId));
    }

    @Override
    public void updateBook(Book newBook) {
        int id = newBook.getInventoryNumber();
        bookRepository.getBookStorage().remove(id);
        bookRepository.getBookStorage().add(newBook);
    }

    @Override
    public Book getById(int id){
        return bookRepository.getBookStorage().get(id);
    }
}
