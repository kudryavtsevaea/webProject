package com.netcracker;

public class Book {
    private String author;
    private String nameOfBook;
    private int yearOfPublishing;
    private int amountOfPages;

    public Book(String author, String nameOfBook, int yearOfPublishing, int amountOfPages) {
        this.author = author;
        this.nameOfBook = nameOfBook;
        this.yearOfPublishing = yearOfPublishing;
        this.amountOfPages = amountOfPages;
    }

    public String getAuthor() {
        return author;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public int getAmountOfPages() {
        return amountOfPages;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setAmountOfPages(int amountOfPages) {
        this.amountOfPages = amountOfPages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", nameOfBook='" + nameOfBook + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                ", amountOfPages=" + amountOfPages +
                '}';
    }
}

