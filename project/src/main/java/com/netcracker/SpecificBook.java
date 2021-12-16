package com.netcracker;

import java.awt.print.Book;

public class SpecificBook<I extends Number, B> extends Book {
    private long inventoryNumber;
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

    public SpecificBook(long inventoryNumber, String author, String nameOfBook
            , int yearOfPublishing, int amountOfPages) {
        this.book = new Book();
        this.inventoryNumber = inventoryNumber;
        this.isHandedOut = false;
    }
}
