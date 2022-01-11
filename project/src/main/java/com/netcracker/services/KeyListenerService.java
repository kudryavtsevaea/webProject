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
        System.out.print("Введите автора и название через точку с запятой: ");
        Scanner sc = new Scanner(System.in);
        prepOperations.getTransaction().getBook(sc.nextInt());
        prepOperations.getLib().backToMenu();
    }

    public void returnBook(){
        System.out.print("Введите инвентарный номер: ");
        Scanner sc = new Scanner(System.in);
        prepOperations.getTransaction().returnBook(sc.nextLong());
        prepOperations.getLib().backToMenu();
    }

    public void getBookByRegex(){
        System.out.print("Введите регулярное выражение для поиска: ");
        Scanner sc = new Scanner(System.in);
        String regex = sc.nextLine();
        prepOperations.getOperationsWithBooks().searchByRegex(regex);
        prepOperations.getLib().backToMenu();
    }

    public void addBook(){
        System.out.print("Введите информацию через точку с запятой: ");
        Scanner sc = new Scanner(System.in);
        String[] book = sc.nextLine().split(";");
        prepOperations.getOperationsWithBooks().addBook(book);
        prepOperations.getLib().backToMenu();
    }

    public void addBooksFromFile(){
        System.out.print("Введите путь к файлу: ");
        Scanner sc = new Scanner(System.in);
        prepOperations.getOperationsWithBooks().addListOfBooks(sc.nextLine());
        prepOperations.getLib().backToMenu();
    }

    public void deleteBook(){
        System.out.print("Введите информацию через точку с запятой: ");
        Scanner sc = new Scanner(System.in);
        String[] deletableBook = sc.nextLine().split(";");
        prepOperations.getOperationsWithBooks().deleteBook(deletableBook);
        prepOperations.getLib().backToMenu();
    }

    public void addUser() throws SQLException {
        System.out.print("Введите имя добавляемого пользователя: ");
        Scanner sc = new Scanner(System.in);
        String userName = sc.nextLine();
        prepOperations.getOperationsWithReaders().addReader(userName);
        prepOperations.getLib().backToMenu();
    }

    public void deleteUser() {
        System.out.print("Введите имя удаляемого пользователя: ");
        Scanner sc = new Scanner(System.in);
        String deletableUser = sc.nextLine();
        prepOperations.getOperationsWithReaders().deleteReader(deletableUser);
        prepOperations.getLib().backToMenu();
    }

    public void correctUser() throws SQLException {
        System.out.print("Введите имя редактируемого пользователя: ");
        Scanner sc = new Scanner(System.in);
        Reader oldReader = new Reader(sc.nextLine());
        sc = new Scanner("Введите измененные данные");
        Reader newReader = new Reader(sc.nextLine());
        prepOperations.getOperationsWithReaders().correctReader(oldReader, newReader);
        prepOperations.getLib().backToMenu();
    }

    public void correctBook(){
        System.out.print("Введите строку которую хотите изменить: ");
        Scanner sc = new Scanner(System.in);
        String[] oldBookArray = sc.nextLine().split(";");
        Book oldBook = new Book(Integer.parseInt(oldBookArray[0]), oldBookArray[1], oldBookArray[2],
                Integer.parseInt(oldBookArray[3]), Integer.parseInt(oldBookArray[4]));
        System.out.print("Введите новую строку: ");
        sc = new Scanner(System.in);
        prepOperations.getOperationsWithBooks().correctBook(oldBook, sc.nextLine().split(";"));
        prepOperations.getLib().backToMenu();
    }

    public void back(){
        prepOperations.getLib().backToMenu();
    }
}
