package com.netcracker.services;

import com.netcracker.models.Book;
import com.netcracker.models.Reader;

import java.sql.SQLException;
import java.util.Scanner;

public class KeyListenerService {
    private PrepOperations prepOperations = new PrepOperations();

    public KeyListenerService() throws SQLException {
    }

    public void quit(){
        System.out.println("До свидания!");
        System.exit(0);
    }

    public void showAllBooksOnHand(){
        prepOperations.getTransaction().showAllBooksOnHand();
        prepOperations.getLib().backToMenu();
    }

    public void showAllBooks(){
        prepOperations.getOperationsWithBooks().showAllBooks();
        prepOperations.getLib().backToMenu();
    }

    public void getBook(){
        System.out.print("Введите инвентарный номер: ");
        try(Scanner sc = new Scanner(System.in)){
            prepOperations.getTransaction().getBook(sc.nextLong());
        }
        prepOperations.getLib().backToMenu();
    }

    public void returnBook(){
        System.out.print("Введите инвентарный номер: ");
        try(Scanner sc = new Scanner(System.in)){
            prepOperations.getTransaction().returnBook(sc.nextLong());
        }
        prepOperations.getLib().backToMenu();
    }

    public void getBookByRegex(){
        System.out.print("Введите регулярное выражение для поиска: ");
        try(Scanner sc = new Scanner(System.in)) {
            String regex = sc.nextLine();
            prepOperations.getOperationsWithBooks().searchByRegex(regex);
        }
        prepOperations.getLib().backToMenu();
    }

    public void addBook(){
        System.out.print("Введите информацию через точку с запятой: ");
        try(Scanner sc = new Scanner(System.in)) {
            String[] book = sc.nextLine().split(";");
            prepOperations.getOperationsWithBooks().addBook(book);
        }
        prepOperations.getLib().backToMenu();
    }

    public void addBooksFromFile(){
        System.out.print("Введите путь к файлу: ");
        try(Scanner sc = new Scanner(System.in)){
            prepOperations.getOperationsWithBooks().addListOfBooks(sc.nextLine());
        }
        prepOperations.getLib().backToMenu();
    }

    public void deleteBook(){
        System.out.print("Введите информацию через точку с запятой: ");
        try(Scanner sc = new Scanner(System.in)){
            String[] deletableBook = sc.nextLine().split(";");
            prepOperations.getOperationsWithBooks().deleteBook(deletableBook);
        }
        prepOperations.getLib().backToMenu();
    }

    public void addUser(){
        System.out.print("Введите имя добавляемого пользователя: ");
        try(Scanner sc = new Scanner(System.in)){
            String userName = sc.nextLine();
            prepOperations.getOperationsWithReaders().addReader(userName);
        }
        prepOperations.getLib().backToMenu();
    }

    public void deleteUser() throws SQLException {
        System.out.print("Введите имя удаляемого пользователя: ");
        try(Scanner sc = new Scanner(System.in)){
        String[] deletableUser = sc.nextLine().split(";");
        Reader reader = new Reader(Integer.parseInt(deletableUser[0]), deletableUser[1]);
        prepOperations.getOperationsWithReaders().deleteReader(reader);
        }
        prepOperations.getLib().backToMenu();
    }

    public void updateUser() throws SQLException {
        System.out.print("Введите имя редактируемого пользователя: ");
        try(Scanner sc = new Scanner(System.in)){
            Reader oldReader = new Reader(Integer.parseInt(sc.nextLine().split(";")[0]),
                    sc.nextLine().split(";")[1]);
            Scanner sc1 = new Scanner("Введите измененные данные");
            Reader newReader = new Reader(Integer.parseInt(sc1.nextLine().split(";")[0]),
                    sc1.nextLine().split(";")[1]);
            prepOperations.getOperationsWithReaders().updateReader(oldReader, newReader);
            prepOperations.getLib().backToMenu();
        }
    }

    public void updateBook(){
        System.out.print("Введите строку которую хотите изменить: ");
        try(Scanner sc = new Scanner(System.in)){
            String[] oldBookArray = sc.nextLine().split(";");
            Book oldBook = new Book(Integer.parseInt(oldBookArray[0]), oldBookArray[1], oldBookArray[2],
                    Integer.parseInt(oldBookArray[3]), Integer.parseInt(oldBookArray[4]));
            System.out.print("Введите новую строку: ");
            Scanner sc1 = new Scanner(System.in);
            prepOperations.getOperationsWithBooks().updateBook(oldBook, sc1.nextLine().split(";"));
        }

        prepOperations.getLib().backToMenu();
    }

    public void back(){
        prepOperations.getLib().printMenu();
    }
}
