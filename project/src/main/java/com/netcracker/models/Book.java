package com.netcracker.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book implements Comparable<Book>{
    private long id;
    private String author;
    private String bookName;
    private int yearOfPublishing;
    private int amountOfPages;
    private boolean isHandedOut;

    public Book(long id, String author, String nameOfBook, int yearOfPublishing, int amountOfPages) {
        this.id = id;
        this.author = author;
        this.bookName = nameOfBook;
        this.yearOfPublishing = yearOfPublishing;
        this.amountOfPages = amountOfPages;
        this.isHandedOut = false;
    }

    public String getNameOfBook() {
        return bookName;
    }

    @Override
    public int compareTo(Book o) {

        int result = this.bookName.compareTo(o.bookName);

        if (result == 0) {
            result = this.author.compareTo(o.author);
        }

        return result;
    }
}

