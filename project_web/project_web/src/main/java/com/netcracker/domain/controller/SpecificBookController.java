package com.netcracker.domain.controller;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.services.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class SpecificBookController {
    private BookRepository bookRepository = BookRepository.getInstance();

    @GetMapping("/{inventoryNumber}")
    public Book getBookById(@RequestParam int id){
        List<Book> books = null;
        books.add(new Book(1,1,1,1298,100,1,false));
        books.add(new Book(2,1,1,1999,1,1,false));

        return books.get(id);
        //return bookRepository.getBookStorage().get(id);
    }
}
