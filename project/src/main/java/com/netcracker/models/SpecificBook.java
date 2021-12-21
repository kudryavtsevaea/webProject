package com.netcracker.models;

public class SpecificBook extends Book{
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

    public SpecificBook(int inventoryNumber, String author, String nameOfBook, int yearOfPublishing,
                        int amountOfPages) {
        super(author,nameOfBook,yearOfPublishing,amountOfPages);
        this.book = new Book(author,nameOfBook,yearOfPublishing,amountOfPages);
        this.inventoryNumber = inventoryNumber;
        this.isHandedOut = false;
    }

    @Override
    public String toString() {
        return "{" +
                "inventoryNumber = " + inventoryNumber +
                ", book = " + book.toString() +
                '}';
    }

}
