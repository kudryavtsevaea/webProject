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
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static com.netcracker.domain.controller.CommonUtil.emptyToNull;

@Controller()
public class BooksController {

    private CommonUtil commonUtil = new CommonUtil();

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
        Book book = bookRepository.findById(bookId).get();
        model.addAttribute("book", book);
        model.addAttribute("bookId", book.getId());
        return "specificBook";
    }

    @PostMapping(value = "deleteBook", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView deleteBookById(@RequestBody MultiValueMap<String, String> paramMap, ModelAndView model) {
        commonUtil.getLogger().debug("Perform Delete {}", paramMap.get("id"));
        List<String> ids = paramMap.get("id");
        bookRepository.deleteById(Long.valueOf(ids.get(0)));
        return new ModelAndView(new RedirectView("/"));
    }


    @PostMapping(value = "addBook", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView addBook(@RequestBody MultiValueMap<String, String> paramMap, ModelAndView model) {
        commonUtil.getLogger().debug("Perform addition {}", paramMap.getFirst("book"));
        commonUtil.getLogger().debug("addBook paramMap {}", paramMap);

        Book book = new Book();

        try {
            commonUtil.getLogger().debug("book for update {}", book);
            Optional.ofNullable(emptyToNull(paramMap.getFirst("info"))).ifPresent(book::setInfo);
            Optional.ofNullable(emptyToNull(paramMap.getFirst("book"))).ifPresent(book::setName);
            Optional.ofNullable(emptyToNull(paramMap.getFirst("year")))
                    .filter((b) -> Integer.valueOf(b) > 1000)
                    .map(Integer::valueOf).ifPresent(book::setYear);
            Optional.ofNullable(emptyToNull(paramMap.getFirst("pages"))).map(Integer::valueOf)
                            .filter((b) -> Integer.valueOf(b) >= 1).ifPresent(book::setPages);
            Optional.ofNullable(emptyToNull(paramMap.getFirst("author"))).ifPresent(book::setAuthor);
        } catch (Exception ex) {
            commonUtil.getLogger().error("Error due to process request parameters", ex);
            throw ex;
        }
        book.setId((int) (bookRepository.count()));
        bookRepository.save(book);

        return
                new ModelAndView(new RedirectView("/"));
    }

    @PostMapping(value = "updateBook", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ModelAndView updateBook(@RequestBody MultiValueMap<String, String> paramMap) {

            Long bookId;
            try {
                bookId = Optional.of(paramMap.getFirst("bookId")).map(Long::valueOf).get();
            } catch (Exception ex) {

                throw ex;
            }

            Book book = bookRepository.findById(bookId).get();
            try {

                Optional.ofNullable(emptyToNull(paramMap.getFirst("info"))).ifPresent(book::setInfo);
                Optional.ofNullable(emptyToNull(paramMap.getFirst("bookName"))).ifPresent(book::setName);
                Optional.ofNullable(emptyToNull(paramMap.getFirst("dateOfPublishing"))).map(Integer::valueOf).ifPresent(book::setYear);
                Optional.ofNullable(emptyToNull(paramMap.getFirst("pages"))).map(Integer::valueOf).ifPresent(book::setPages);
                Optional.ofNullable(emptyToNull(paramMap.getFirst("author"))).ifPresent(book::setAuthor);
                commonUtil.getLogger().debug("book after update {}", paramMap);
            } catch (Exception ex) {

                throw ex;
            }

            bookRepository.save(book);
            ModelAndView specificBook = new ModelAndView(new RedirectView("specificBook"));
            specificBook.getModel().put("bookId", bookId);
            specificBook.getModel().put("book", book);
            return specificBook;

    }


}
