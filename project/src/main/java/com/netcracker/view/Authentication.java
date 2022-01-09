package com.netcracker.view;

import com.netcracker.models.Library;
import com.netcracker.models.Reader;
import java.sql.SQLException;
import java.util.Scanner;

public class Authentication {
    private boolean admin = false;
    private Library lib = Library.getInstance();
    private final LibrarySystem libsys = new LibrarySystem();

    public Authentication() throws SQLException {
        libsys.authentication();
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        nameCheck(name);
    }

    public void printMenu(){
        if (admin == true){
            libsys.printMenuAdmin();
        }
        else {
            libsys.printMenuUser();
        }
    }

    public void nameCheck(String name) throws SQLException {
        boolean flag = false;
        if (name == "admin"){
            admin = true;
            lib.currentReader.setId(0);
            lib.currentReader.setName("admin");
            libsys.printMenuAdmin();
            flag = true;
        }
        for (Reader r : lib.readers) {
            if (r.getName() == name){
                lib.currentReader.setId(r.getId());
                lib.currentReader.setName(name);
                libsys.printMenuUser();
                flag = true;
                break;
            }
        }
        if (flag){
            System.out.println("Данного пользователя не существует. Зарегистрируйтесь.");
            lib.readers.add(new Reader(name));
            lib.currentReader.setId(lib.readers.size());
            lib.currentReader.setName(name);
        }
    }
}
