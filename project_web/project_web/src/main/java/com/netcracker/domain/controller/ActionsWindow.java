package com.netcracker.domain.controller;

import com.netcracker.domain.dao.BooksDaoImpl;
import com.netcracker.domain.model.BookWithInfo;
import com.netcracker.domain.services.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActionsWindow {
    private BookRepository bookRepository = BookRepository.getInstance();
    private BooksDaoImpl booksDao = new BooksDaoImpl();

    @GetMapping ("/booksRepository")
    public List<BookWithInfo> getAllBooks(){
        return bookRepository.getAllBooks();
    }

    @GetMapping(path = "/booksRepository/{id}")
    public BookWithInfo getBookById(@PathVariable int id){
        return bookRepository.getAllBooks().get(id - 1);
    }

    @PostMapping("/book")
    public void addBook(@RequestBody BookWithInfo book){
        booksDao.addBook(book);
    }

    @PutMapping("/book")
    public void updateBookOnPage(@RequestBody BookWithInfo newBook){
        booksDao.updateBook(newBook);
    }

    @DeleteMapping("book/{id}")
    public void deleteBookById(@PathVariable int id){
        booksDao.deleteBook(id - 1);
    }
}
