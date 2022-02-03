package com.netcracker.domain.controller;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.services.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActionsWindow {
    private BookRepository bookRepository = BookRepository.getInstance();

    @GetMapping("/addBook")
    public void addBookOnPage(@RequestParam Book book){
        bookRepository.getBookStorage().add(book);
    }

    @GetMapping("/updateUser")
    public void updateBookOnPage(@RequestParam Book oldBook, @RequestParam Book newBook){
        bookRepository.getBookStorage().remove(oldBook);
        bookRepository.getBookStorage().add(newBook);
    }
}
