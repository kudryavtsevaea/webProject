package com.netcracker.dao;

import com.netcracker.models.Turnover;

import java.util.List;

public interface TurnoversDao {
    List<Turnover> getAllBooksOnHnd();
    boolean getBook(long id);
    boolean returnBook(long id);
}
