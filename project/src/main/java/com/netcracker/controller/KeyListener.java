package com.netcracker.controller;

import com.netcracker.services.KeyListenerService;
import java.sql.SQLException;

public class KeyListener {
    private KeyListenerService keyListenerService = new KeyListenerService();

    private final String ONE = "1";
    private final String TWO = "2";
    private final String THREE = "3";
    private final String FOUR = "4";
    private final String FIVE = "5";
    private final String SIX = "6";
    private final String SEVEN = "7";
    private final String EIGHT = "8";
    private final String NINE = "9";
    private final String TEN = "10";
    private final String ELEVEN = "11";
    private final String TWELVE = "12";
    private final String LEFT = "<";
    private final String QUIT = "q";

    public KeyListener() throws SQLException {
    }

    public void keyPressed(String e) throws SQLException {
        switch (e) {
            case QUIT:
                keyListenerService.quit();
                break;
            case ONE:
                //показать все выданные книги
                keyListenerService.showAllBooksOnHand();
                break;
            case TWO:
                //все книги в библиотеке
                keyListenerService.showAllBooks();
                break;
            case THREE:
                //взять книгу
                keyListenerService.getBook();
                break;
            case FOUR:
                //вернуть книгу
                keyListenerService.returnBook();
                break;
            case FIVE:
                //регулярное выражение
                keyListenerService.getBookByRegex();
                break;
            case SIX:
                //добавить книгу
                keyListenerService.addBook();
                break;
            case SEVEN:
                //добавить из файла
                keyListenerService.addBooksFromFile();
                break;
            case EIGHT:
                //удалить книгу
                keyListenerService.deleteBook();
                break;
            case NINE:
                //добавить пользователя
                keyListenerService.addUser();
                break;
            case TEN:
                //удалить пользователя
                keyListenerService.deleteUser();
                break;
            case ELEVEN:
                //редактировать пользователя
                keyListenerService.updateUser();
                break;
            case TWELVE:
                //редактировать книгу
                keyListenerService.updateBook();
                break;
            case LEFT:
                //переход в меню
                keyListenerService.back();
                break;
            default:
                System.out.println("Некорректная операция! Попробуйте снова.");
                break;
        }
    }
}