package com.netcracker.controller;

import com.netcracker.dao.TurnoversDao;
import com.netcracker.dao.TurnoversDaoImpl;
import com.netcracker.models.Turnover;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class Transaction {

    TurnoversDao turnoversDao = new TurnoversDaoImpl();

    public void showAllBooksOnHand() {
        turnoversDao.getAllBooksOnHnd().forEach(System.out::println);
    }

    public void getBook(String info){
        turnoversDao.getBook(info);
    }

    public void returnBook(long number){
        turnoversDao.returnBook(number);
    }
}
