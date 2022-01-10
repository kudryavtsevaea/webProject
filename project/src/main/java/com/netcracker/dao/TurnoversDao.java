package com.netcracker.dao;

import com.netcracker.models.Book;
import com.netcracker.models.Turnover;

import java.util.List;

public interface TurnoversDao {
    List<Turnover> getAllBooksOnHnd();
    boolean getBook(String name);
    boolean returnBook(long id);
}
