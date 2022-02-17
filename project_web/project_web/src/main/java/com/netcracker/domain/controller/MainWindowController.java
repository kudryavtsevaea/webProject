package com.netcracker.domain.controller;

import com.netcracker.domain.dao.UserDaoImpl;
import com.netcracker.domain.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainWindowController {
    private UserDaoImpl users = new UserDaoImpl();

    @GetMapping("/")
    public String welcome(){
        return "Главная страница";
    }

    @GetMapping("/admin")
    public String getAdminsWindow(){
       return "Администратор.";
    }

    @GetMapping("/user")
    public String getUsersWindow(){
        return "Пользователь.";
    }

}
