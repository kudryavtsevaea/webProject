package com.netcracker.controller;

import com.netcracker.models.Library;
import com.netcracker.models.SpecificBook;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperationsWithSpecificBooks {
    private Library lib = Library.getInstance();

    public OperationsWithSpecificBooks() throws SQLException {
    }

    public void getBook(String name){
        for (SpecificBook b : lib.specificBooks){
            if (name == b.getNameOfBook()){
                b.setHandedOut(false);
            }
        }
    }

    public void putBook(int inventoryNumber){
        for (SpecificBook b : lib.specificBooks){
            if (inventoryNumber == b.getInventoryNumber()){
                b.setHandedOut(true);
            }
        }
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

    public void addSpecificBook(String[] str){
        SpecificBook specificBook = new SpecificBook(Integer.parseInt(str[0]),
               str[1],str[2],Integer.parseInt(str[3]),Integer.parseInt(str[4]));
        specificBook.setHandedOut(false);
        lib.specificBooks.add(specificBook);
    }

    public void addListOfSpecificBook(String path){
        try (Scanner sc = new Scanner(new File(path))){
            while (sc.hasNextLine()){
                String s = sc.nextLine();
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
//        for (SpecificBook s: lib.specificBooks){
//            if (inventoryNumber == s.getInventoryNumber()){
//                lib.specificBooks.remove(s);
//            }
//
    }

    public void replaceSpecificBook(int inventoryNumber, String[] str) {
//        if (lib.specificBooks.contains(inventoryNumber)){
//            boolean hands = lib.specificBooks.stream().filter((b) -> b.equals(inventoryNumber))
//                    .findFirst().get().isHandedOut();
//            lib.specificBooks.remove(inventoryNumber);
//            SpecificBook specificBook = new SpecificBook(Integer.parseInt(str[0]), str[1],str[2]
//                    ,Integer.parseInt(str[3]), Integer.parseInt(str[4]));
//            specificBook.setHandedOut(hands);
//            lib.specificBooks.add(specificBook);
//        }
//        else{
//            System.out.println("Такой книги не существует.");
//        }

    }
}
