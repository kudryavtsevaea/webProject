package com.netcracker.domain.model;

public class Book {
    private int inventoryNumber;
    private int authorId;
    private int nameOfBookId;
    private int year;
    private int pages;
    private int infoId;
    private boolean isHandedOut;

    public Book(int inventoryNumber, int authorId, int nameOfBookId, int year, int pages, int infoId,
                boolean isHandedOut) {
        this.inventoryNumber = inventoryNumber;
        this.authorId = authorId;
        this.nameOfBookId = nameOfBookId;
        this.year = year;
        this.pages = pages;
        this.infoId = infoId;
        this.isHandedOut = isHandedOut;
    }
}
