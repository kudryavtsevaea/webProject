package com.netcracker.controller;

import com.netcracker.dao.TurnoversDao;
import com.netcracker.dao.TurnoversDaoImpl;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Transaction {

    TurnoversDao turnoversDao = new TurnoversDaoImpl();

    public void showAllBooksOnHand() {
        turnoversDao.getAllBooksOnHnd().forEach(System.out::println);
    }

    public void getBook(long id){
        turnoversDao.getBook(id);
    }

    public void returnBook(long number){
        turnoversDao.returnBook(number);
    }
}
