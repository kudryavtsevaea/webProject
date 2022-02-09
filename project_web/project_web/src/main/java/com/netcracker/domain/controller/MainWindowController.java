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

    @GetMapping("/registration")
    public void registration(@RequestBody int id, @RequestBody String name){
        users.addUser(new User(id, name));
    }

    @GetMapping("/admin")
    public String getAdminsWindow(){
       return "Администратор.";
    }

   // @GetMapping("/{name}")
   // public String getUsersWindow(){
     //   return "Пользователь.";
    //}

    public void authorization(@RequestBody int id, @RequestBody String name){
        if (id == 123 && name == "admin"){
            getAdminsWindow();
        }
        else
        {
           if (!users.getUserRepository().equals(new User(id,name))){
               registration(id,name);
           }
           else{
      //         getUsersWindow();
           }
        }
    }
}
