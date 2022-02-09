package com.netcracker.domain.controller;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.services.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BooksListController {
    private BookRepository bookRepository = BookRepository.getInstance();

    @GetMapping ("/booksRepository")
    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
}
