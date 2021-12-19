package com.netcracker.models;

import java.awt.print.Book;

public class SpecificBook extends Book {
    private int inventoryNumber;
    private Book book;
    private boolean isHandedOut;

    public long getInventoryNumber() {
        return inventoryNumber;
    }

    public boolean isHandedOut() {
        return isHandedOut;
    }

    public void setHandedOut(boolean handedOut) {
        isHandedOut = handedOut;
    }

    public SpecificBook(int inventoryNumber, String author, String nameOfBook
            , int yearOfPublishing, int amountOfPages) {
        this.book = new Book();
        this.inventoryNumber = inventoryNumber;
        this.isHandedOut = false;
    }
}
