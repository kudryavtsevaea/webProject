package com.netcracker.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataManagerService {

    private static DataManagerService INSTANCE = null;

    private DataManagerService(){

    }

    public static DataManagerService getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DataManagerService();
        }
        return INSTANCE;
    }

    public static Connection getConnection(){
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream("src/prop/config.properties");
            property.load(fis);
           return DriverManager.getConnection
                    (property.getProperty("db.host"), property.getProperty("db.login"),
                            property.getProperty("db.password"));
        }
        catch(SQLException | IOException e){
            System.out.println("Не удалось подключиться к базе данных.");
        }
        return null;
    }
}
