package com.netcracker.domain.services;

import com.netcracker.domain.model.Book;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Data
public class BookRepository {
    private static BookRepository INSTANCE = null;
    private List<Book> bookStorage = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(BookRepository.class);

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
                        .getConnection().prepareStatement("select * from book");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    bookStorage.add(new Book(resultSet.getInt(1), resultSet.getInt(2),
                            resultSet.getInt(3), resultSet.getInt(4),
                            resultSet.getInt(5),resultSet.getInt(6),
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
