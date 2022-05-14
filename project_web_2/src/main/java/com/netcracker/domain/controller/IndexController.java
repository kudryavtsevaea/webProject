package com.netcracker.domain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller("/")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping("index")
    public String indexAsItIs() {
        return "index";
    }

    @ExceptionHandler(Exception.class)
    ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.debug("handle error {}", ex.getMessage());
        ModelAndView error = new ModelAndView("error");
        error.addObject("exceptionMessage", ex.getMessage());
        return error;
    }
}
