package com.netcracker.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/")
public class IndexController {
    @RequestMapping
    public String index() {
        return "index";
    }
    @RequestMapping("index")
    public String indexAsItIs(){
        return "index";
    }
}
