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
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";

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
        try(FileInputStream fis = new FileInputStream("src/main/resources/application.properties")){
            Class.forName(DRIVER);
            property.load(fis);
            Connection connection = DriverManager.getConnection
                    (property.getProperty("db.host"), property.getProperty("db.login"),
                            property.getProperty("db.password"));
            log.info("connection ", connection);
            return connection;
        }
        catch(IOException e){
            log.error("Property-файл не найден.", e);
            e.printStackTrace();
        }
        catch(SQLException e){
            log.error("Не удалось подключиться к базе данных.", e);
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

