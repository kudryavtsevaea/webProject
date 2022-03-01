package com.netcracker.domain.controller;

import com.netcracker.domain.dao.BooksDaoImpl;
import com.netcracker.domain.dao.UserDaoImpl;
import com.netcracker.domain.model.BookWithInfo;
import com.netcracker.domain.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private BookRepository bookRepository = BookRepository.getInstance();
    private BooksDaoImpl booksDao = new BooksDaoImpl();

    @GetMapping("/")
    public String greeting () {
        return "mainWindow";
    }

    @GetMapping ("/booksRepository")
    public String getAllBooks(Model model){
       String s = "";
        for (BookWithInfo b : bookRepository.getAllBooks()){
           s += b.toString();

       }
        model.addAttribute("book",s +"\n");
       return "allBooks";
     //   return bookRepository.getAllBooks();
    }

    @GetMapping(path = "/booksRepository/{id}")
    public BookWithInfo getBookById(@PathVariable int id){
        return bookRepository.getAllBooks().get(id - 1);
    }

    //

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
