package com.netcracker.domain.repository;

import com.netcracker.domain.model.Book;
import com.netcracker.domain.services.DataManagerService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Data
@Slf4j
public class BookRepository{
    private static BookRepository INSTANCE = null;
    private List<Book> bookStorage = new ArrayList<>();

    private BookRepository(){
    }

    public static BookRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookRepository();
        }
        return INSTANCE;
    }

    public List<Book> getAllBooks(){
        try {
            PreparedStatement preparedStatement = DataManagerService.getInstance()
                    .getConnection().prepareStatement("select * from book_with_info");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bookStorage.add(new Book(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getInt(4),
                        resultSet.getInt(5),resultSet.getString(6),
                        resultSet.getBoolean(7)));
            }

        }
        catch(SQLException e){
            log.error("Ошибка при загрузке книг в классе BookRepository.");
            e.printStackTrace();
        }
        return bookStorage;
    }
}
