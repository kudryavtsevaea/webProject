package com.netcracker.services;

import com.netcracker.controller.OperationsWithBooks;
import com.netcracker.controller.OperationsWithReaders;
import com.netcracker.controller.Transaction;
import com.netcracker.view.Authentication;
import com.netcracker.view.LibrarySystem;
import lombok.Data;

import java.sql.SQLException;

@Data
public class PrepOperations {
    private OperationsWithBooks operationsWithBooks = new OperationsWithBooks();
    private OperationsWithReaders operationsWithReaders = new OperationsWithReaders();
    private Transaction transaction= new Transaction();
    private Authentication authentication = new Authentication();

    private LibrarySystem lib = new LibrarySystem();

    public PrepOperations() throws SQLException {
    }
}
