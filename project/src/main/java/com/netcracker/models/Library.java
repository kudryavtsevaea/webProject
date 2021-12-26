package com.netcracker.models;

import java.sql.*;
import java.util.*;

public class Library {

    public Set<Book> books = new TreeSet<>();
    public Set<Reader> readers = new TreeSet<>();
    public Reader currentReader = new Reader();
    public List<Turnover> turnovers = new ArrayList<>();
    private static Library INSTANCE = null;
    private Connection connection = DriverManager.getConnection
            ("jdbc:mysql://127.0.0.1:3306/librarydb2", "root", "kryasan2");

    private Library() throws SQLException {
        PreparedStatement preparedStatement1 = connection.prepareStatement("select * from book");
        ResultSet resultSet1 = preparedStatement1.executeQuery();
        while (resultSet1.next()) {
            books.add(new Book(resultSet1.getLong(1), resultSet1.getString(2),
                    resultSet1.getString(3), resultSet1.getInt(4),
                    resultSet1.getInt(5)));
        }

        PreparedStatement preparedStatement2 = connection.prepareStatement("select * from reader");
        ResultSet resultSet2 = preparedStatement2.executeQuery();
        while (resultSet2.next()) {
            readers.add(new Reader(resultSet2.getInt(1), resultSet2.getString(2)));
        }

        PreparedStatement preparedStatement3 = connection.prepareStatement(
                "select * from book_turnover_with_info2");
        ResultSet resultSet3 = preparedStatement3.executeQuery();
        while (resultSet3.next()) {
            Reader reader = new Reader(resultSet3.getString(1));
            Book book = new Book(resultSet3.getLong(2), resultSet3.getString(3),
                    resultSet3.getString(4), resultSet3.getInt(5),
                    resultSet3.getInt(6));
            book.setHandedOut(resultSet3.getBoolean(8));

            turnovers.add(new Turnover(reader, book, resultSet3.getDate(7)));
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