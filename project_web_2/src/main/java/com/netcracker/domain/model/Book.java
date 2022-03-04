package com.netcracker.domain.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book {

    public Book() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int inventoryNumber;
    private String author;
    private String nameOfBook;
    private int year;
    private int pages;
    private String info;
    private boolean isHandedOut;

    public Book(int inventoryNumber, String author, String nameOfBook, int year, int pages, String info,
                        boolean isHandedOut) {
        this.inventoryNumber = inventoryNumber;
        this.author = author;
        this.nameOfBook = nameOfBook;
        this.year = year;
        this.pages = pages;
        this.info = info;
        this.isHandedOut = isHandedOut;
    }

    @Override
    public String toString() {
        return "№" + inventoryNumber +
                "\n " + author +
                ",  \"" + nameOfBook + '\"' +
                ", " + year +
                ", " + pages + " стр."
                + "\n {" + info + "}\n";
    }
}
