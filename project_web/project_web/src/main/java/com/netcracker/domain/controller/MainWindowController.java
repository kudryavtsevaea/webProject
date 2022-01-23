package com.netcracker.domain.controller;

import com.netcracker.domain.model.User;
import com.netcracker.domain.services.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/library")
public class MainWindowController {
    private UserRepository userRepository = new UserRepository();


    @GetMapping
    public String welcome(){
        return "Welcome to the library!";
    }


    //registration
    @GetMapping("/registration")
    public void registration(@RequestBody int id, @RequestBody String name){
        userRepository.add(id,name);
    }

    @GetMapping("/admin")
    public void getAdminsWindow(){

    }

    @GetMapping("/{name}")
    public void getUsersWaindow(){

    }

    public void authorization(@RequestBody int id, @RequestBody String name){
        if (id == 123 && name == "admin"){
            getAdminsWindow();
        }
        else
        {
           if (!userRepository.equals(new User(id,name))){
               registration(id,name);
           }
           else{
               getUsersWaindow();
           }
        }
    }
}
