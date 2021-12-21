package com.netcracker.models;

import java.util.concurrent.ThreadLocalRandom;

public class Book implements Comparable<Book>{
    private int id;
    private String author;
    private String nameOfBook;
    private int yearOfPublishing;
    private int amountOfPages;

    public Book(String author, String nameOfBook, int yearOfPublishing, int amountOfPages) {
        this.id = ThreadLocalRandom.current().nextInt(0, 100);
        this.author = author;
        this.nameOfBook = nameOfBook;
        this.yearOfPublishing = yearOfPublishing;
        this.amountOfPages = amountOfPages;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    @Override
    public String toString() {
        return " {id = " + id + ", " +
                "author = '" + author + '\'' +
                ", nameOfBook = '" + nameOfBook + '\'' +
                ", yearOfPublishing = " + yearOfPublishing +
                ", amountOfPages = " + amountOfPages +
                '}';

    }

    @Override
    public int compareTo(Book o) {
        return this.nameOfBook.compareTo(o.nameOfBook);
    }
}

