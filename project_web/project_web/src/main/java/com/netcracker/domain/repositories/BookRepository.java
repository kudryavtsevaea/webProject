package com.netcracker.domain.services;

import com.netcracker.domain.model.BookWithInfo;
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
    private List<BookWithInfo> bookStorage = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(BookRepository.class);

    private BookRepository(){
    }

    public static BookRepository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new BookRepository();
        }
        return INSTANCE;
    }

    public List<BookWithInfo> getAllBooks(){
        try {
                PreparedStatement preparedStatement = DataManagerService.getInstance()
                        .getConnection().prepareStatement("select * from book_with_info");
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    bookStorage.add(new BookWithInfo(resultSet.getInt(1), resultSet.getString(2),
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
