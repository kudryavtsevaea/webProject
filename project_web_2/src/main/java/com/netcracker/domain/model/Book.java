package com.netcracker.domain.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table(name = "bks")
public class Book {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String author;
    private String name;
    private int year;
    private int pages;
    private String info;

    public Book(long id, String author, String nameOfBook, int year, int pages, String info) {
        this.id = id;
        this.author = author;
        this.name = nameOfBook;
        this.year = year;
        this.pages = pages;
        this.info = info;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String nameOfBook) {
        this.name = nameOfBook;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "№" + id +
                "\n " + author +
                ",  \"" + name + '\"' +
                ", " + year +
                ", " + pages + " стр."
                + "\n {" + info + "}\n";
    }
}
