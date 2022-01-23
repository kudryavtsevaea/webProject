package com.netcracker.domain.services;

import com.netcracker.domain.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {
    private List<Book> bookStorage = new ArrayList<>();
}
