package com.netcracker.domain.controller;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller()
public class BooksController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("bookRepository")
    public String getAllBooks(Model model) {
        Iterable<Book> allBooks = bookRepository.findAll();

        model.addAttribute("books", allBooks);
        return "bookRepository";
    }

    @GetMapping("specificBook")
    public String getBookById(@RequestParam long bookId, Model model) {

        Book book = bookRepository.findById((long) bookId + 1).get();
        model.addAttribute("book", book);
        return "specificBook";
    }

    @PostMapping(value = "deleteBook",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView deleteBookById(@RequestBody MultiValueMap<String, String> paramMap, ModelAndView model) {
        System.out.println("Perform Delete " + paramMap.get("id"));
        List<String> ids = paramMap.get("id");
        bookRepository.deleteById(Long.valueOf(ids.get(0)) + 1);

        return
                new ModelAndView(new RedirectView("/"));
    }

    @PostMapping(value = "addBook",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView addBook(@RequestBody MultiValueMap<String, String> paramMap, ModelAndView model) {
        System.out.println("Perform addition " + paramMap.get("book").get(0));
        List<String> ids = paramMap.get("id");
        Book newBook= new Book();
        newBook.setNameOfBook(paramMap.get("book").get(0));
        newBook.setAuthor(paramMap.get("author").get(0));
        newBook.setInfo(paramMap.get("info").get(0));
        newBook.setYear(Integer.valueOf(paramMap.get("year").get(0)));
        newBook.setPages(Integer.valueOf(paramMap.get("pages").get(0)));
        newBook.setInventoryNumber((int) (bookRepository.count()));

        bookRepository.save(newBook);
        return
                new ModelAndView(new RedirectView("/"));

    }

    @PostMapping(value = "updateBook",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView updateBook(@RequestBody MultiValueMap<String, String> paramMap, ModelAndView model) {
        List<String> ids = paramMap.get("id");
        getBookById(Long.valueOf(ids.get(0)), (Model) paramMap);
        bookRepository.deleteById(Long.valueOf(ids.get(0)) + 1);

        Book newBook= new Book();
        newBook.setNameOfBook(paramMap.get("book").get(0));
        newBook.setAuthor(paramMap.get("author").get(0));
        newBook.setInfo(paramMap.get("info").get(0));
        newBook.setYear(Integer.valueOf(paramMap.get("year").get(0)));
        newBook.setPages(Integer.valueOf(paramMap.get("pages").get(0)));
        newBook.setInventoryNumber((int) (bookRepository.count()));

        bookRepository.save(newBook);


        return
                new ModelAndView(new RedirectView("/bookRepository"));
    }


}
