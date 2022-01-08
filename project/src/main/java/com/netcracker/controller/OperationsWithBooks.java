package com.netcracker.controller;

import com.netcracker.models.Book;
import com.netcracker.models.Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationsWithBooks {
    private Library lib = Library.getInstance();

    public OperationsWithBooks() throws SQLException {
    }

    public void showAllBooks() {
        if (lib.books.isEmpty()){
            System.out.println("Извините, в библиотеке нет книг.");
        }
        else {
            lib.books.forEach(System.out::println);
        }
    }

    public void addListOfBooks(String path){
        try(Scanner sc = new Scanner(new File(path))){
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                String[] str = s.split(";");
                Book book = new Book(Integer.parseInt(str[0]), str[1], str[2], Integer.parseInt(str[3]),
                        Integer.parseInt(str[4]));
                lib.books.add(book);
            }
        }
        catch(FileNotFoundException e2){
            System.out.println("Файл не найден.");
        }
        catch(IOException e1){
            System.out.println("Введена некорректная информация!");
        }
    }

    public void searchByRegex(String requiredString){
       try {
           Pattern pattern = Pattern.compile(requiredString, Pattern.CASE_INSENSITIVE);
           boolean flag = false;
           for (Book w : lib.books) {
               Matcher matcher = pattern.matcher(w.getNameOfBook());
               if (matcher.find()) {
                   System.out.println(w);
                   flag = true;
               }
           }
           if (!flag) {
               System.out.println("Нет подходящих книг!");
           }
       }
       catch (IllegalArgumentException e){
           System.out.println("Некорректно введено регулярное выражение.");
       }
    }

    public void deleteBook(String[] deletableBook){
       try {
           Book delete = new Book(Long.getLong(deletableBook[0]), deletableBook[1], deletableBook[2],
                   Integer.parseInt(deletableBook[3]), Integer.parseInt(deletableBook[4]));
           lib.books.remove(delete);
       }
       catch (IllegalArgumentException e){
           System.out.println("Данной книги не существует.");
       }
    }

    public void addBook(String[] book){
        try {
            Book newBook = new Book(Integer.parseInt(book[0]), book[1], book[2], Integer.parseInt(book[3]),
                Integer.parseInt(book[4]));
        lib.books.add(newBook);
        }
        catch(IllegalArgumentException e){
            System.out.println("Неверный формат ввода!");
        }

    }

    public void correctBook(Book oldBook, String[] book){
        try {
            lib.books.remove(oldBook);
            Book newBook = new Book(Integer.parseInt(book[0]), book[1], book[2], Integer.parseInt(book[3]),
                Integer.parseInt(book[4]));
            lib.books.add(newBook);
        }
        catch(IllegalArgumentException e){
            System.out.println("Неверный формат ввода!");
        }
    }
}
