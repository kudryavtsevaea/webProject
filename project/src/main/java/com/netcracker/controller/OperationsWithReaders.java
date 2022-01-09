package com.netcracker.controller;

import com.netcracker.models.Library;
import com.netcracker.models.Reader;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class OperationsWithReaders {
    private Library lib = Library.getInstance();

    public OperationsWithReaders() throws SQLException {
    }

    public void addReader(String newUser) throws SQLException {
        lib.readers.add(new Reader(newUser));
    }

    public void deleteReader(String removableUser) throws SQLException {
        lib.readers.remove(removableUser);
        CallableStatement stmt = lib.getConnection().prepareCall
                ("{delete from reader where readerName = ?}");
        stmt.setString(2,removableUser);
        stmt.executeUpdate();
    }

    public void correctReader(Reader oldName, String newName) throws SQLException {
        lib.readers.remove(oldName);
        Reader correctUser = new Reader(newName);
        lib.readers.add(correctUser);
        CallableStatement stmt = lib.getConnection().prepareCall("{UPDATE Reader SET value = ? " +
                "WHERE reader readerName = ?}");
        stmt.setString(2, newName);

    }
}
