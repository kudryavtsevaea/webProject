package com.netcracker.models;

import java.sql.*;

public class Library {

    private static Library INSTANCE = null;

    public Reader currentReader;

    private Library(){

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

    public Reader getCurrentReader() {
        return currentReader;
    }
}