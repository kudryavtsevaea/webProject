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


    @GetMapping("/")
    public String add(@RequestBody String text){
        String[] str = text.split(";");
        Book newBook = new Book(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]),
                Integer.parseInt(str[4]), str[5], false);
        bookRepository.getBookStorage().add(newBook);
        return "index";
    }

    @GetMapping("/")
    public String delete(@RequestBody int id){
        bookRepository.getBookStorage().remove(id);
        return "index";
    }

    @GetMapping("/")
    public String update(@RequestBody String text){
        String[] str = text.split(";");
        Book newBook = new Book(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]),
                Integer.parseInt(str[4]), str[5], false);
        int id = newBook.getInventoryNumber();
        bookRepository.getBookStorage().remove(id);
        bookRepository.getBookStorage().add(newBook);
        return "index";
    }

}
