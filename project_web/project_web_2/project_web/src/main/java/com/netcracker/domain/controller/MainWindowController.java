package com.netcracker.domain.controller;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainWindowController {
    private BookRepository bookRepository = BookRepository.getInstance();

    @RequestMapping("/bookRepository")
    public String showAll(Model model){
        List<Book> books = new ArrayList<>();
        for (Book b: bookRepository.getAllBooks()) {
           books.add(b);
        }
        model.addAttribute("books", books);
        return "bookRepository";
    }

    @RequestMapping("/specificBook")
    public String showOne(@RequestBody int id, Model model){
        model.addAttribute("book", bookRepository.getBookStorage().get(id));
        return "specificBook";
    }

    //add,delete,update

}
