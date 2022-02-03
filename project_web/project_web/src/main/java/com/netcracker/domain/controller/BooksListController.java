package com.netcracker.domain.controller;

import com.netcracker.domain.services.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BooksListController {
    private BookRepository bookRepository = BookRepository.getInstance();

    @GetMapping ("/booksRepository")
    public BookRepository getAllBooks(){
       return bookRepository;
    }
}
