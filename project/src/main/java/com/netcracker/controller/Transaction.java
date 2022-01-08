package com.netcracker.controller;

import com.netcracker.models.Library;
import com.netcracker.models.Turnover;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class Transaction {
    private Library lib = Library.getInstance();

    public Transaction() throws SQLException {
    }

    public void showAllBooksOnHand() {
        List<Turnover> turnoverArray= new ArrayList<>();
        turnoverArray =
            lib.turnovers.stream().filter(b -> b.getBook().isHandedOut() == true &&
                            b.getReader().getName().equals(lib.currentReader))
                    .collect(Collectors.toList());
        if (!turnoverArray.isEmpty()){
            turnoverArray.forEach(System.out::println);
        }
        else {
            System.out.println("Вы не взяли ни одну книгу!");
        }

    }

    public void getBook(String info){
        String[] infoBook = info.split(";");
        Turnover turnover = lib.turnovers.stream().filter(b -> b.getBook().isHandedOut() == false &&
                b.getBook().getBookName().equals(infoBook[1]) && b.getBook().getAuthor().equals(infoBook[0]))
                .findFirst().get();
        lib.books.stream().filter(b -> b.equals(turnover.getBook())).findFirst().get().setHandedOut(true);
    }

    public void returnBook(long number){
        Turnover turnover = lib.turnovers.stream().filter(b -> b.getBook().getId() == number)
                .findFirst().get();
        lib.books.stream().filter(b -> b.equals(turnover.getBook())).findFirst().get().setHandedOut(false);
    }
}
