package com.netcracker.domain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class CommonUtil {
    private static final Logger logger = LoggerFactory.getLogger(BooksController.class);
    static final String emptyToNull(String v) {
        return (v == null || v.isEmpty()) ? null : v;
    }

    public Logger getLogger(){
        return logger;
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        logger.debug("BookRepository error handled {}", ex.getMessage());
        ModelAndView error = new ModelAndView("error");
        error.addObject("exceptionMessage", ex.getMessage());
        return error;
    }
}
