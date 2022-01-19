package com.netcracker.view;

import com.netcracker.models.Reader;
import com.netcracker.services.PrepLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Scanner;

public class Authentication {
    private PrepLibrary preplyb = new PrepLibrary();
    private static final Logger log = LoggerFactory.getLogger(Authentication.class);

    public Authentication() throws SQLException {
        System.out.print("Добро пожаловать в библиотеку!\nАвторизуйтесь:");
        Scanner sc = new Scanner(System.in);
            nameCheck(sc.nextLine());
        preplyb.getLibsys().printMenu();
    }

    public void nameCheck(String name) throws SQLException {
        for (Reader r : preplyb.getReadersDao().getAllReaders()) {
            if (r.getName() != null && r.getName().equals(name) )
            {
                preplyb.getLib().getCurrentReader().setName(name);
                log.info("Пользователь {} найден в базе.", name);
                preplyb.getLibsys().printMenu();
                break;
            }

        }
        log.info("Пользователь добавлен в базу.");
            preplyb.getReadersDao().addReader(new Reader(0, name));
        preplyb.getLib().getCurrentReader().setName(name);
        preplyb.getLibsys().printMenu();
    }
}
