package com.netcracker;

import java.sql.SQLException;
import java.util.Scanner;

public class KeyListener {
    private Library lib;

    final String ONE = "1";
    final String TWO = "2";
    final String THREE = "3";
    final String FOUR = "4";
    final String FIVE = "5";
    final String SIX = "6";
    final String SEVEN = "7";
    final String EIGHT = "8";
    final String NINE = "9";
    final String TEN = "10";
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
            case ONE:
                //просмотреть все взятые книги
                lib.showAllBooksOnHands();
                System.out.println("<- Назад         Выход(q)");
                break;
            case TWO:
                //взять книгу
                lib.getBook(info);
                System.out.println("<- Назад         Выход(q)");
                break;
            case THREE:
                //вернуть книгу
                System.out.println("<- Назад         Выход(q)");
                break;
            case FOUR:
                //найти книгу
                lib.findBookByName(info);
                System.out.println("<- Назад         Выход(q)");
                break;
            case FIVE:
                //просмотреть все книги в библиотеке
                lib.showAllBooks();
                System.out.println("<- Назад         Выход(q)");
                break;
            case SIX:
                //удалить книгу
                lib.deleteBook(info);
                System.out.println("<- Назад         Выход(q)");
                break;
            case SEVEN:
                //добавить книгу
                lib.addBook(info);
                System.out.println("<- Назад         Выход(q)");
                break;
            case EIGHT:
                /*изменить поле книги
                lib.renameBook();
                System.out.println("<- Назад         Выход(q)");
                */
                break;
            case NINE:
                //найти книгу по регулярному выражению
                lib.searchByRegex(info);
                System.out.println("<- Назад         Выход(q)");
                break;
            case TEN:
                //добавить список книг из файла
                lib.addListOfBooks(info);
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