package com.netcracker.models;

import java.sql.*;
import java.util.*;

public class Library {

    public Set<Book> books = new TreeSet<>();
    public Set<SpecificBook> specificBooks = new TreeSet<>();
    private static Library INSTANCE = null;
    Connection connection = DriverManager.getConnection
            ("jdbc:mysql://127.0.0.1:3306/librarydb", "root", "kryasan2");

    private Library() throws SQLException {
        PreparedStatement preparedStatement1 = connection.prepareStatement("select * from book");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        while (resultSet1.next()) {
            Book book = new Book(resultSet1.getString(1), resultSet1.getString(2),
                    resultSet1.getInt(3), resultSet1.getInt(4));
            books.add(book);
        }

        PreparedStatement preparedStatement2 = connection.prepareStatement("select * from specificBookWithInfo");
        ResultSet resultset2 = preparedStatement2.executeQuery();
        while (resultset2.next()) {
            SpecificBook specificBook = new SpecificBook(resultset2.getInt(1), resultset2.getString(2),
                    resultset2.getString(3), resultset2.getInt(4),
                    resultset2.getInt(5));
            specificBooks.add(specificBook);
        }

    }

    public static Library getInstance() throws SQLException {
        if (INSTANCE == null) {
            synchronized (Library.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Library();
                }
            }
        }
        return INSTANCE;
    }
}