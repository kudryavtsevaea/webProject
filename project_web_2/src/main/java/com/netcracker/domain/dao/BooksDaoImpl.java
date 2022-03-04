package com.netcracker.domain.dao;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

//Not need if you use Spring Data
public class BooksDaoImpl {
  /*  @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.getAllBooks().add(book);
    }

    @Override
    public void deleteBook(int bookId) {
        bookRepository.getAllBooks()
                .remove(bookRepository.getAllBooks().get(bookId));
    }

    @Override
    public void updateBook(Book newBook) {
        int id = newBook.getInventoryNumber();
        bookRepository.getAllBooks().remove(id);
        bookRepository.getAllBooks().add(newBook);
    }

    @Override
    public Book getById(int id){
        return bookRepository.getAllBooks().get(id);
    }*/
}
