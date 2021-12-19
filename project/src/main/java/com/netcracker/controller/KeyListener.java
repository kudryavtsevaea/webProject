package com.netcracker.controller;

import com.netcracker.models.Book;
import com.netcracker.models.SpecificBook;
import com.netcracker.view.LibrarySystem;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.sql.SQLException;
import java.util.Scanner;

public class KeyListener {
    private OperationsWithBooks operationsWithBooks;
    private OperationsWithSpecificBooks operationsWithSpecificBooks;

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
    private final String THIRTEEN = "13";
    private final String FOURTEEN = "14";
    private final String LEFT = "<";
    private final String QUIT = "q";

    public void keyPressed(String e) throws SQLException {
        switch (e) {
            case QUIT:
                System.out.println("До свидания!");
                System.exit(0);
                break;
            case ONE:
                //показать все выданные книги
                operationsWithSpecificBooks.showAllBooksOnHands();
                LibrarySystem.backToMenu();
                break;
            case TWO:
                //показать все экземпляры книг
                operationsWithSpecificBooks.showAllSpecificBooks();
                LibrarySystem.backToMenu();
                break;
            case THREE:
                //показать все книги
                operationsWithBooks.showAllBooks();
                LibrarySystem.backToMenu();
                break;
            case FOUR:
                //добавить экземпляр книги
                System.out.println("Введите поля экземпляра книги, который хотите добавить" +
                        ", через точку с запятой.");
                Scanner sc = new Scanner(System.in);
                String[] s = sc.nextLine().split(";");
                operationsWithSpecificBooks.addSpecificBook(s);
                LibrarySystem.backToMenu();
                break;
            case FIVE:
                //добавить книгу
                System.out.println("Введите поля книги, которую хотите добавить, через точку с запятой.");
                sc = new Scanner(System.in);
                String[] s2 = sc.nextLine().split(";");
                operationsWithBooks.addBook(s2);
                LibrarySystem.backToMenu();
                break;
            case SIX:
                //взять книгу (изменить onHands на true)
                System.out.println("Введите название книги.");
                sc = new Scanner(System.in);
                String name = sc.nextLine();
                operationsWithSpecificBooks.getBook(name);
                LibrarySystem.backToMenu();
                break;
            case SEVEN:
                //вернуть книгу (изменить onHands на false)
                System.out.println("Введите инвентарный номер.");
                sc = new Scanner(System.in);
                int inventoryNumber = sc.nextInt();
                operationsWithSpecificBooks.putBook(inventoryNumber);
                LibrarySystem.backToMenu();
                break;
            case EIGHT:
                //добавить из файла список экземпляров
                System.out.println("Введите путь к файлу.");
                sc = new Scanner(System.in);
                String path = sc.nextLine();
                operationsWithSpecificBooks.addListOfSpecificBook(path);
                LibrarySystem.backToMenu();
                break;
            case NINE:
                //добавить из файла список книг
                System.out.println("Введите путь к файлу со списком книг, которые хотите добавить.");
                sc = new Scanner(System.in);
                path = sc.nextLine();
                operationsWithBooks.addListOfBooks(path);
                LibrarySystem.backToMenu();
                break;
            case TEN:
                //удалить книгу
                System.out.println("Введите название книги, которую хотите удалить.");
                sc = new Scanner(System.in);
                name = sc.nextLine();
                operationsWithBooks.deleteBook(name);
                LibrarySystem.backToMenu();
                break;
            case ELEVEN:
                //удалить экземпляр книги
                System.out.println("Введите инвентарный номер книги, которую хотите удалить.");
                sc = new Scanner(System.in);
                inventoryNumber = sc.nextInt();
                operationsWithSpecificBooks.deleteSpecificBook(inventoryNumber);
                LibrarySystem.backToMenu();
                break;
            case TWELVE:
                //найти по регулярному выражению
                System.out.println("Введите шаблон для поиска.");
                sc = new Scanner(System.in);
                String regex = sc.nextLine();
                operationsWithBooks.searchByRegex(regex);
                LibrarySystem.backToMenu();
                break;
            case THIRTEEN:
                //изменить поля книги
                System.out.println("Введите название книги, которую хотите отредактировать.");
                sc = new Scanner(System.in);
                String str1 = sc.nextLine();
                System.out.println("Введите новые значения полей книги через точку с запятой.");
                sc = new Scanner(System.in);
                String[] str2 = sc.nextLine().split(";");
                operationsWithBooks.replaceBook(str1, str2);
                LibrarySystem.backToMenu();
                break;
            case FOURTEEN:
                //изменить поля экземпляра
                System.out.println("Введите инвентарный номер книги, которую хотите отредактировать.");
                sc = new Scanner(System.in);
                inventoryNumber = sc.nextInt();
                System.out.println("Введите новые значения полей экземпляра книги через точку с запятой.");
                sc = new Scanner(System.in);
                String[] str3 = sc.nextLine().split(";");
                operationsWithSpecificBooks.replaceSpecificBook(inventoryNumber, str3);
                LibrarySystem.backToMenu();
                break;
            case LEFT:
                //переход в меню
                LibrarySystem.printMenu();
                break;
            default:
                System.out.println("Некорректная операция! Попробуйте снова.");
                break;
        }
    }
}