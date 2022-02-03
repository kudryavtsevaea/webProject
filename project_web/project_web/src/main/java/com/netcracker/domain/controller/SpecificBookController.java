package com.netcracker.domain.controller;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.services.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class SpecificBookController {
    private BookRepository bookRepository = BookRepository.getInstance();

    @GetMapping("/booksRepository")
    public Book getBookById(@RequestBody int id){
        return bookRepository.getBookStorage().get(id);
    }
}
