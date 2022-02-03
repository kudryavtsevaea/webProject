package com.netcracker.domain.model;



public class Book {
    private int inventoryNumber;
    private int year;
    private int pages;
    private boolean isHandedOut;

    public Book(int inventoryNumber, int year, int pages, boolean isHandedOut){
        this.inventoryNumber = inventoryNumber;
        this.year = year;
        this.pages = pages;
        this.isHandedOut = isHandedOut;
    }

}
