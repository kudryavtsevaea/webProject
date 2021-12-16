package com.netcracker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User {
    private int id;
    private String readerName;
    private boolean hasBook;
    private int whichBook;

    public User(int id, String readerName, boolean hasBook, int whichBook) {
        this.id = id;
        this.readerName = readerName;
        this.hasBook = hasBook;
        this.whichBook = whichBook;
    }

    public String getReaderName() {
        return readerName;
    }

    public boolean isHasBook() {
        return hasBook;
    }


    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public void setHasBook(boolean hasBook) {
        this.hasBook = hasBook;
    }

    public void setWhichBook(int whichBook) {
        this.whichBook = whichBook;
    }

    public int getWhichBook() {
        return whichBook;
    }

    public String getNameOfBookByNumber(Connection connection, int number) throws SQLException {
        PreparedStatement preparedStatement = connection
                .prepareStatement("select whichBook from readerwithbook");
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getString(3);

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", readerName='" + readerName + '\'' +
                ", hasBook=" + hasBook +
                ", whichBook=" + whichBook +
                '}';
    }
}
