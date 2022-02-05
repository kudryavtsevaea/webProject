package com.netcracker.domain.services;

import com.netcracker.domain.model.User;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
@Data
public class UserRepository {
    private static UserRepository INSTANCE = null;
    private HashMap <Integer, String> userStorage = new HashMap<>();
    private static final Logger log = LoggerFactory.getLogger(UserRepository.class);

    private UserRepository(){
//        try {
//            PreparedStatement preparedStatement = DataManagerService.getInstance()
//                    .getConnection().prepareStatement("select * from reader");
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                User newUser = new User(resultSet.getInt(1), resultSet.getString(2));
//                userStorage.put(newUser.getId(), newUser.getName());
//            }
//        }
//        catch(SQLException e){
//            log.error("Ошибка при загрузке пользователей в классе UserRepository.");
//        }
    }

    public static UserRepository getInstance(){
        if (INSTANCE == null){
            INSTANCE = new UserRepository();
        }
        return INSTANCE;
    }
}
