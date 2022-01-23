package com.netcracker.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("main")
public class MainWindowController {
    @GetMapping
    public String welcome(){
        return "Welcome!";
    }
}
