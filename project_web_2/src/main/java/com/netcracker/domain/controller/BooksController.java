package com.netcracker.domain.controller;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.repository.BookRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


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

        Book book = bookRepository.findById((long) bookId).get();
        model.addAttribute("book", book.getNameOfBook());
        return "specificBook";
    }


//    @GetMapping("/book/{id}")
//    public String add(@RequestBody String text){
//        String[] str = text.split(";");
//        Book newBook = new Book(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]),
//                Integer.parseInt(str[4]), str[5], false);
//        bookRepository.getBookStorage().add(newBook);
//        return "index";
//    }

    @PostMapping(value = "deleteBook",consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView deleteBookById(@RequestBody MultiValueMap<String, String> paramMap, ModelAndView model) {
        System.out.println("Perform Delete "+paramMap.get("id"));
        List<String> ids = paramMap.get("id");
        bookRepository.deleteById(Long.valueOf(ids.get(0)));

        return
                new ModelAndView(new RedirectView("/"));
                //new ModelAndView(new RedirectView("index")); -- this Work Fine
    }

    @GetMapping("book/{id}")
    public String updateBookById(@RequestBody String text) {
        String[] str = text.split(";");
        Book newBook = new Book(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]),
                Integer.parseInt(str[4]), str[5], false);
        int id = newBook.getInventoryNumber();

       /* bookRepository.getAllBooks().remove(id);
        bookRepository.getAllBooks().add(newBook);*/
        return "index";
    }

}
