package com.netcracker.controller;

import com.netcracker.dao.ReadersDao;
import com.netcracker.dao.ReadersDaoImpl;
import com.netcracker.models.Reader;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

@NoArgsConstructor
public class OperationsWithReaders{
    private static final Logger log = LoggerFactory.getLogger(OperationsWithReaders.class);

    private ReadersDao readers = new ReadersDaoImpl();

    public void addReader(String newUser) {
        try {
            readers.addReader(new Reader(newUser));
        }
        catch(SQLException e){
            log.error("Ошибка при добавлении пользователя из класса OperationsWithReaders.");
        }

    }

    public void deleteReader(String removableUser){
        try {
            readers.deleteReader(new Reader(removableUser));
        }
        catch(SQLException e){
            log.error("Ошибка при удалении пользователя из класса OperationsWithReaders.");
        }
    }

    public void correctReader(Reader oldReader, Reader newReader){
        readers.updateReader(oldReader, newReader);
    }
}
