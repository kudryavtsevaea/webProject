package com.netcracker.domain.services;

import com.netcracker.domain.model.Action;
import com.netcracker.domain.model.Book;
import com.netcracker.domain.model.User;
import com.netcracker.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

public class Transaction {
    @Autowired
    private UserRepository userRepository;

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

  public String print (Action action){
        if (action == Action.GIVE){
            date1 = new Date();
            return user.getUsername() +"\t" + "'" + book.getName() + "' \t" + date1 + "\t - \t";
        }
        else{
            date1 = new Date();
            date2 = new Date(12);
        }
            return user.getUsername() +"\t" + "'" + book.getName() + "' \t" + date1 + "\t - \t" + date2 +"\t";
  }

}
