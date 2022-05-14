package com.netcracker.domain.controller;


import com.netcracker.domain.model.Role;
import com.netcracker.domain.model.User;
import com.netcracker.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb= userRepository.findByUsername(user.getUsername());
        if (userFromDb != null){
            model.put("massage", "User is already exists");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(user.getRoles());
        userRepository.save(user);
        return "redirect:/login";
    }
}
