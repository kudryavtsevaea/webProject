package com.netcracker.controller;

import com.netcracker.models.Book;
import com.netcracker.models.Library;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationsWithBooks {
    private Library lib = Library.getInstance();

    public OperationsWithBooks() throws SQLException {
    }

    public void showAllBooks() {
        lib.books.forEach(System.out::println);
    }

    public void addListOfBooks(String path){
        try(Scanner sc = new Scanner(new File(path))){
            while(sc.hasNextLine()){
                String s = sc.nextLine();
                String[] str = s.split(";");
                Book book = new Book(str[0], str[1], Integer.parseInt(str[2]),
                        Integer.parseInt(str[3]));
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
            if (matcher.find()) {
                System.out.println(w);
            }

        }
    }

    public void deleteBook(String name){
//        for (Book b: lib.books){
//            if (b.getNameOfBook() == name){
//                lib.books.remove(b);
//            }
//        }
//        for (SpecificBook sb : lib.specificBooks){
//            if (sb.getNameOfBook() == name){
//                lib.specificBooks.remove(sb);
//            }
//        }
//        // if (lib.books.contains(name)) {
        //lib.books.remove(lib.books.stream().filter((b) -> b.equals(name)).findFirst().get());
//            List<SpecificBook> deletable = lib.specificBooks.stream().filter((b) -> b.equals(name))
//                    .collect(Collectors.toList());
//            lib.specificBooks.removeAll(deletable);
////        }
////        else {
////            System.out.println("Данной книги нет в библиотеке.");
////        }
       // for (Book b: lib.books)
//        List<SpecificBook> deletable = lib.books.stream().filter((b) -> b.equals(name))
//                    .collect(Collectors.toList());
//            lib.specificBooks.removeAll(deletable);
    }

    public void addBook(String[] book){
        Book newBook = new Book(book[0], book[1], Integer.parseInt(book[2]),
                Integer.parseInt(book[3]));
        lib.books.add(newBook);
    }

    public void replaceBook(String str1, String[] str) {
    //    if (lib.books.contains(str1)){
       //     lib.books.remove(str1);
//        String[] s = str1.split(";");
//        for (Book b: lib.books) {
//            if (b.getNameOfBook() == s[1]) {
//                lib.books.remove(b);
//                Book book = new Book(str[0], str[1], Integer.parseInt(str[2]),
//                        Integer.parseInt(str[3]));
//                lib.books.add(book);
//            }
//        }
//        }
//        else{
//            System.out.println("Данной книги не существует.");
//        }

    }
}
