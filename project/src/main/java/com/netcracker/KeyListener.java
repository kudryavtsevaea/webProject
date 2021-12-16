package com.netcracker;

import java.sql.SQLException;
import java.util.Scanner;

public class KeyListener {
    private Library lib;

    final String TEN = "10";
    final String ELEVEN = "11";
    final String TWELVE = "12";
    final String LEFT = "<";
    final String QUIT = "q";

    public void keyPressed(String e) throws SQLException {
        String info;
        try (Scanner sc = new Scanner(System.in)) {
            info = sc.nextLine();
        }
        switch (e) {
            case QUIT:
                System.out.println("До свидания!");
                System.exit(0);
                break;
            case "1":
                //просмотреть все взятые книги
                lib.showAllBooksOnHands();
                System.out.println("<- Назад         Выход(q)");
                break;
            case "2":
                //взять книгу
                lib.getBook(info);
                System.out.println("<- Назад         Выход(q)");
                break;
            case "3":
                //вернуть книгу
                System.out.println("<- Назад         Выход(q)");
                break;
            case "4":
                //найти книгу
                lib.findBookByName(info);
                System.out.println("<- Назад         Выход(q)");
                break;
            case "5":
                lib.showAllBooks();
                System.out.println("<- Назад         Выход(q)");
                break;
            case "6":
                //добавить пользователя
                //addUser
                System.out.println("<- Назад         Выход(q)");
                break;
            case "7":
                //удалить пользователя
                lib.deleteReader(info);
                System.out.println("<- Назад         Выход(q)");
                break;
            case "8":
                //удалить книгу
                lib.deleteBook(info);
                System.out.println("<- Назад         Выход(q)");
                break;
            case "9":
                //добавить книгу
                //addBook
                System.out.println("<- Назад         Выход(q)");
                break;
            case TEN:
                //просмотреть всех пользователей
                lib.showAllUsers();
                System.out.println("<- Назад         Выход(q)");
                break;
            case ELEVEN:
                //изменить поле читателя
                System.out.println("<- Назад         Выход(q)");
                break;
            case TWELVE:
                //изменить поле книги
                System.out.println("<- Назад         Выход(q)");
                break;
            case LEFT:
                //переход в меню
                LibrarySystem.printMenu();
                break;
            default:
                System.out.println("Некорректная операция! Попробуйте снова");
                break;
        }

    }
}