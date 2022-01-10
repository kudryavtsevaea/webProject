package com.netcracker.dao;

import com.netcracker.models.Reader;
import com.netcracker.services.DataManagerService;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReadersDaoImpl implements  ReadersDao{

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
            System.out.println("Ошибка при загрузке пользователей.");
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
            System.out.println("Ошибка добавления пользователя.");
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
                    System.out.println("Ошибка при удалении пользователя.");
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
            System.out.println("Ошибка при редактировании пользователя.");
        }
        return false;
    }
}
