package com.netcracker.domain.controller;


import com.netcracker.domain.model.Role;
import com.netcracker.domain.model.User;
import com.netcracker.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public ModelAndView addUser(User user, Map<String, Object> model){
        User userFromDb= userRepository.findByUsername(user.getUsername());
        if (userFromDb != null){
            model.put("massage", "User is already exists.");
            return new ModelAndView("registration");
        }

        user.setRole(Role.USER.name());
        userRepository.save(user);
        return new ModelAndView(new RedirectView("/login"));
    }
}
