package com.netcracker.models;

import java.util.Date;

public class Turnover {
    private Reader reader;
    private Book book;
    private Date date;

    public Turnover(Reader reader, Book book, java.sql.Date date) {
        this.reader = reader;
        this.book = book;
        this.date = date;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }
}
