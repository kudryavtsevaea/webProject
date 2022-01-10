package com.netcracker.controller;

import com.netcracker.dao.ReadersDao;
import com.netcracker.dao.ReadersDaoImpl;
import com.netcracker.models.Reader;
import lombok.NoArgsConstructor;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class OperationsWithReaders {

    private ReadersDao readers = new ReadersDaoImpl();

    public void addReader(String newUser) {
        readers.getAllReaders().forEach(System.out::println);
    }

    public void deleteReader(String removableUser) throws SQLException {
        readers.deleteReader(new Reader(removableUser));
    }

    public void correctReader(Reader oldName, String newName) throws SQLException {


    }
}
