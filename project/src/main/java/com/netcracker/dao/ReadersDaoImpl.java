package com.netcracker.dao;

import com.netcracker.models.Reader;
import com.netcracker.services.DataManagerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadersDaoImpl implements  ReadersDao{
    private static final Logger log = LoggerFactory.getLogger(ReadersDaoImpl.class);

    @Override
    public List<Reader> getAllReaders() {
        List<Reader> readers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = DataManagerService.getInstance()
                    .getConnection().prepareStatement("select * from reader");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                readers.add(new Reader(resultSet.getString(2)));
            }
        }
        catch(SQLException e){
            log.error("Ошибка при загрузке пользователей в классе ReadersDaoImpl.");
        }
        return readers;
    }

    @Override
    public boolean addReader(Reader reader) {
        try{
            CallableStatement stmt = DataManagerService.getConnection().prepareCall
                    ("insert into reader (readerName) values (?)");
            stmt.setString(1, reader.getName());

            stmt.executeUpdate();
        }
        catch (SQLException e){
            log.error("Ошибка добавления пользователя в классе ReadersDaoImpl.");
        }
        return false;
    }

    @Override
    public boolean deleteReader(Reader reader) {
        for (Reader r : getAllReaders()){
            if (r == reader)
            {
                try{
                    CallableStatement stmt = DataManagerService.getConnection().prepareCall
                            ("delete * from reader where readerName = ?");
                    stmt.setString(1, reader.getName());
                    stmt.executeUpdate();
                }
                catch (SQLException e){
                    log.error("Ошибка при удалении пользователя в классе ReadersDaoImpl.");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public boolean updateReader(Reader oldReader, Reader newReader) {
        try{
            CallableStatement stmt = DataManagerService.getConnection().prepareCall
                    ("update reader set readerName = ? where id = ?");
            stmt.setString(1,newReader.getName());
            stmt.setLong(2,oldReader.getId());
            stmt.executeUpdate();
        }
        catch (SQLException e){
            log.error("Ошибка при редактировании пользователя в классе ReadersDaoImpl.");
        }
        return false;
    }
}
