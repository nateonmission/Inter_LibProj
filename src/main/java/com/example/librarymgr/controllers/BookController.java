package com.example.librarymgr.controllers;

import com.example.librarymgr.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/")
public class BookController {

    private static final Logger LOGGER = Logger.getLogger(BookController.class.getName());

    private BookServices bookServices;
    @Autowired
    public void setBookServices(BookServices bookServices) {

        this.bookServices = bookServices;
    }



}
