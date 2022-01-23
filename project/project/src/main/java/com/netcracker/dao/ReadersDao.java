package com.netcracker.dao;

import com.netcracker.models.Reader;

import java.util.List;

public interface ReadersDao {
    List<Reader> getAllReaders();
    boolean addReader(Reader reader);
    boolean deleteReader(Reader reader);
    boolean updateReader(Reader oldReader, Reader newReader);

}
