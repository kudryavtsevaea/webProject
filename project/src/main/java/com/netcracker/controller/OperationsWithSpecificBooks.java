package com.netcracker.controller;

import com.netcracker.models.Book;
import com.netcracker.models.Library;
import com.netcracker.models.SpecificBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OperationsWithSpecificBooks {
    private Library lib = Library.getInstance();

    public OperationsWithSpecificBooks() throws SQLException {
    }

    public void getBook(String name){
        lib.specificBooks.stream().filter((b) -> b.equals(name))
                .findFirst().get().setHandedOut(true);
    }

    public void putBook(int inventoryNumber){
        lib.specificBooks.stream().filter((b) -> b.equals(inventoryNumber))
                .findFirst().get().setHandedOut(false);
    }

    public void showAllSpecificBooks() {
        lib.specificBooks.forEach(System.out::println);
    }

    public void showAllBooksOnHands(){
        List<SpecificBook> booksOnHands = new ArrayList<>();
        for (SpecificBook s : lib.specificBooks){
            if (s.isHandedOut()) {
                booksOnHands.add(s);
            }
            if (booksOnHands.isEmpty()) {
                System.out.println("Нет выданных книг.");
            } else {
                booksOnHands.forEach(System.out::println);
            }
        }
    }

    public void addSpecificBook(String[] book){
        for (SpecificBook s : lib.specificBooks){
            if (s.getInventoryNumber() == Integer.parseInt(book[0])){
                System.out.println("Книга с таким инвентарным номером уже существует.");
            }
        }
        SpecificBook newSpecificBook = new SpecificBook(Integer.parseInt(book[0]), book[1], book[2],
                Integer.parseInt(book[3]), Integer.parseInt(book[4]));
        newSpecificBook.setHandedOut(false);
        lib.specificBooks.add(newSpecificBook);
    }


    public void addListOfSpecificBook(String path){
        try (Scanner sc = new Scanner(new File(path))){
            while (sc.hasNextLine()){
                String s = sc.next();
                String[] str = s.split(";");
                SpecificBook specificBook = new SpecificBook(Integer.parseInt(str[0]),
                        str[1],str[2],Integer.parseInt(str[3]),Integer.parseInt(str[4]));
                lib.specificBooks.add(specificBook);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Файл не найден");
        }
    }

    public void deleteSpecificBook(int inventoryNumber){
        if (lib.specificBooks.contains(inventoryNumber)) {
            lib.specificBooks.remove(inventoryNumber);
        }
        else {
            System.out.println("Данной книги нет в библиотеке.");
        }
    }

    public void replaceSpecificBook(int inventoryNumber, String[] str) {
        if (lib.specificBooks.contains(inventoryNumber)){
            boolean hands = lib.specificBooks.stream().filter((b) -> b.equals(inventoryNumber))
                    .findFirst().get().isHandedOut();
            lib.specificBooks.remove(inventoryNumber);
            SpecificBook specificBook = new SpecificBook(Integer.parseInt(str[0]),str[1],str[2]
                    ,Integer.parseInt(str[3]), Integer.parseInt(str[4]));
            specificBook.setHandedOut(hands);
            lib.specificBooks.add(specificBook);
        }
        else{
            System.out.println("Такой книги не существует.");
        }
    }
}
