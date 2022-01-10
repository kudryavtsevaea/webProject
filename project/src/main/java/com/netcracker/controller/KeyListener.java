package com.netcracker.controller;

import com.netcracker.models.Book;
import com.netcracker.models.Reader;
import com.netcracker.services.PrepOperations;
import com.netcracker.view.Authentication;
import com.netcracker.view.LibrarySystem;

import java.sql.SQLException;
import java.util.Scanner;

public class KeyListener {
   private PrepOperations prepOperations = new PrepOperations();

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
                System.out.println("До свидания!");
                System.exit(0);
                break;
            case ONE:
                //показать все выданные книги
                prepOperations.getTransaction().showAllBooksOnHand();
                prepOperations.getLib().backToMenu();
                break;
            case TWO:
                //все книги в библиотеке
                prepOperations.getOperationsWithBooks().showAllBooks();
                prepOperations.getLib().backToMenu();
                break;
            case THREE:
                //взять книгу
                System.out.print("Введите автора и название через точку с запятой: ");
                Scanner sc = new Scanner(System.in);
                prepOperations.getTransaction().getBook(sc.nextLine());
                prepOperations.getLib().backToMenu();
                break;
            case FOUR:
                //вернуть книгу
                System.out.print("Введите инвентарный номер: ");
                sc = new Scanner(System.in);
                prepOperations.getTransaction().returnBook(sc.nextLong());
                prepOperations.getLib().backToMenu();
                break;
            case FIVE:
                //регулярное выражение
                System.out.print("Введите регулярное выражение для поиска: ");
                sc = new Scanner(System.in);
                String regex = sc.nextLine();
                prepOperations.getOperationsWithBooks().searchByRegex(regex);
                prepOperations.getLib().backToMenu();
                break;
            case SIX:
                //добавить книгу
                System.out.print("Введите информацию через точку с запятой: ");
                sc = new Scanner(System.in);
                String[] book = sc.nextLine().split(";");
                prepOperations.getOperationsWithBooks().addBook(book);
                prepOperations.getLib().backToMenu();
                break;
            case SEVEN:
                //добавить из файла
                System.out.print("Введите путь к файлу: ");
                sc = new Scanner(System.in);
                prepOperations.getOperationsWithBooks().addListOfBooks(sc.nextLine());
                prepOperations.getLib().backToMenu();
                break;
            case EIGHT:
                //удалить книгу
                System.out.print("Введите информацию через точку с запятой: ");
                sc = new Scanner(System.in);
                String[] deletableBook = sc.nextLine().split(";");
                prepOperations.getOperationsWithBooks().deleteBook(deletableBook);
                prepOperations.getLib().backToMenu();
                break;
            case NINE:
                //добавить пользователя
                System.out.print("Введите имя добавляемого пользователя: ");
                sc = new Scanner(System.in);
                String userName = sc.nextLine();
                prepOperations.getOperationsWithReaders().addReader(userName);
                prepOperations.getLib().backToMenu();
                break;
            case TEN:
                //удалить пользователя
                System.out.print("Введите имя удаляемого пользователя: ");
                sc = new Scanner(System.in);
                String deletableUser = sc.nextLine();
               prepOperations.getOperationsWithReaders().deleteReader(deletableUser);
                prepOperations.getLib().backToMenu();
                break;
            case ELEVEN:
                //редактировать пользователя
                System.out.print("Введите имя редактируемого пользователя: ");
                sc = new Scanner(System.in);
                Reader oldReader = new Reader(sc.nextLine());
                sc = new Scanner("Введите измененные данные");
                prepOperations.getOperationsWithReaders().correctReader(oldReader, sc.nextLine());
                prepOperations.getLib().backToMenu();
                break;
            case TWELVE:
                //редактировать книгу
                System.out.print("Введите строку которую хотите изменить: ");
                sc = new Scanner(System.in);
                String[] oldBookArray = sc.nextLine().split(";");
                Book oldBook = new Book(Integer.parseInt(oldBookArray[0]), oldBookArray[1], oldBookArray[2],
                        Integer.parseInt(oldBookArray[3]), Integer.parseInt(oldBookArray[4]));
                System.out.print("Введите новую строку: ");
                sc = new Scanner(System.in);
                prepOperations.getOperationsWithBooks().correctBook(oldBook, sc.nextLine().split(";"));
                prepOperations.getLib().backToMenu();
                break;
            case LEFT:
                //переход в меню
                prepOperations.getLib().backToMenu();
                break;
            default:
                System.out.println("Некорректная операция! Попробуйте снова.");
                break;
        }
    }
}