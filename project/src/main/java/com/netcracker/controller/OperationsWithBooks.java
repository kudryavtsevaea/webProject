package com.netcracker.controller;

import com.netcracker.models.Book;
import com.netcracker.models.Library;
import com.netcracker.models.SpecificBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class OperationsWithBooks {
    Library lib = Library.getInstance();

    public OperationsWithBooks() throws SQLException {
    }

    public void showAllBooks() {
        lib.books.forEach(System.out::println);
    }

    public void addListOfBooks(String path){
        try(Scanner sc = new Scanner(new File(path))){
            while(sc.hasNextLine()){
                String s = sc.next();
                String[] str = s.split(";");
                Book book = new Book(str[0],str[1],Integer.parseInt(str[2]),Integer.parseInt(str[3]));
                lib.books.add(book);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Файл не найден.");
        }
    }

    public void searchByRegex(String requiredString){
        Pattern pattern = Pattern.compile(requiredString, Pattern.CASE_INSENSITIVE);
        for (Book w : lib.books) {
            Matcher matcher = pattern.matcher(w.getNameOfBook());
            while (matcher.find()) {
                System.out.println(w);
            }

        }
    }

    public void deleteBook(String name){
        if (lib.books.contains(name)) {
            lib.books.remove(name);
            List<SpecificBook> deletable = lib.specificBooks.stream().filter((b) -> b.equals(name))
                    .collect(Collectors.toList());
            lib.specificBooks.removeAll(deletable);
        }
        else {
            System.out.println("Данной книги нет в библиотеке.");
        }
    }

    public void addBook(String[] book){
        Book newBook = new Book(book[1], book[2], Integer.parseInt(book[3]), Integer.parseInt(book[4]));
        if (lib.books.contains(book)) {
            System.out.println("Такая книга уже существует.");
        }
        lib.books.add(newBook);
    }

    public void renameBook(Book oldBook, Book newBook){
        lib.books.remove(oldBook);
        lib.books.add(newBook);
    }

    public void replaceBook(String str1, String[] str) {
        if (lib.books.contains(str1)){
            lib.books.remove(str1);
            Book book = new Book(str[0],str[1],Integer.parseInt(str[2]),Integer.parseInt(str[3]));
            lib.books.add(book);
        }
        else{
            System.out.println("Данной книги не существует.");
        }

    }
}
