package com.netcracker.controller;

import com.netcracker.models.Library;
import com.netcracker.models.Reader;

import java.sql.SQLException;

public class OperationsWithReaders {
    private Library lib = Library.getInstance();

    public OperationsWithReaders() throws SQLException {
    }

    public void addReader(String newUser){
        lib.readers.add(new Reader(newUser));
    }

    public void deleteReader(String removableUser){
        lib.readers.remove(removableUser);
    }

    public void correctReader(Reader oldName, String newName){
        lib.readers.remove(oldName);
        Reader correctUser = new Reader(oldName.getId(), newName);
        lib.readers.add(correctUser);

    }
}
