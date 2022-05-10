package com.netcracker.domain.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataManagerService {

    private static DataManagerService INSTANCE = null;
    private static final Logger log = LoggerFactory.getLogger(DataManagerService.class);

    private DataManagerService(){

    }

    public static DataManagerService getInstance(){
        if (INSTANCE == null){
            INSTANCE = new DataManagerService();
        }
        return INSTANCE;
    }

    public static Connection getConnection(){
        Properties property = new Properties();
        try(FileInputStream fis = new FileInputStream("E:\\NetCracker2021\\webProject\\project_web_2" +
                "\\src\\main\\resources\\application.properties")){
            property.load(fis);
            return DriverManager.getConnection
                    (property.getProperty("spring.datasource.url"), property.getProperty("spring.datasource.username"),
                            property.getProperty("spring.datasource.password"));
        }
        catch(SQLException | IOException e){
            log.error("Не удалось подключиться к базе данных.");
        }
        return null;
    }
}