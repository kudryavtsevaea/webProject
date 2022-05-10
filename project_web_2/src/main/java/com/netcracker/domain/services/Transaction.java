package com.netcracker.domain.services;

import com.netcracker.domain.model.Action;
import com.netcracker.domain.model.Book;
import com.netcracker.domain.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

public class Transaction {
    private User user;
    private Book book;
    private Action action;
    private Date date1;
    private Date date2;

    @PostMapping("/handedBooks")
    private String getBackAction(Transaction transaction, Model model){
       model.addAttribute("massage", transaction.print(transaction.action));
        return "handedBooks";
    }

  public String print (Action ation){
        if (action == Action.GIVE)
            return user +"\t" + "'" + book.getNameOfBook() + "' \t" + date1 + "\t - \t";
        else
            return user +"\t" + "'" + book.getNameOfBook() + "' \t" + date1 + "\t - \t" + date2 +"\t";
  }
}
