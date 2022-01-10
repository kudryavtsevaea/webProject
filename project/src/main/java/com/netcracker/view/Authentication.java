package com.netcracker.view;

import com.netcracker.models.Reader;
import com.netcracker.services.PrepLibrary;

import java.sql.SQLException;
import java.util.Scanner;

public class Authentication {

    private PrepLibrary preplyb = new PrepLibrary();

    public Authentication() throws SQLException {
        System.out.print("Добро пожаловать в библиотеку!\nАвторизуйтесь:");
        Scanner sc = new Scanner(System.in);
        nameCheck(sc.nextLine());
        preplyb.getLibsys().printMenu();
    }

    public void nameCheck(String name) throws SQLException {
        for (Reader r : preplyb.getReadersDao().getAllReaders()) {
            if (r.getName() == name) {
                preplyb.getLib().currentReader.setName(name);
                preplyb.getLibsys().printMenu();
                break;
            }
        }
    }
}
