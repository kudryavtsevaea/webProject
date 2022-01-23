package com.netcracker;

import com.netcracker.controller.KeyListener;

import java.lang.reflect.Executable;
import java.sql.SQLException;
import java.util.Scanner;

public class App{
    public static void main(String[] args) throws SQLException {
        KeyListener keyListeners = new KeyListener();
        try(Scanner sc = new Scanner(System.in)){
            while (true){
                String option = sc.nextLine();
                keyListeners.keyPressed(option);
            }
        }
        catch (Exception e){
            System.out.println("Ошибка в main классе.");
        }

    }
}
