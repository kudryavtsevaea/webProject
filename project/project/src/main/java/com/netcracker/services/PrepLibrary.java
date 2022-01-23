package com.netcracker.services;

import com.netcracker.dao.ReadersDao;
import com.netcracker.dao.ReadersDaoImpl;
import com.netcracker.models.Library;
import com.netcracker.view.LibrarySystem;
import lombok.Data;

@Data
public class PrepLibrary {
    private ReadersDao readersDao = new ReadersDaoImpl();
    private Library lib = Library.getInstance();
    private LibrarySystem libsys = new LibrarySystem();

}
