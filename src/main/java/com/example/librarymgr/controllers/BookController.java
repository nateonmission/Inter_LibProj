package com.example.librarymgr.controllers;

import com.example.librarymgr.DTOs.BookDTO;
import com.example.librarymgr.models.Book;
import com.example.librarymgr.models.Status;
import com.example.librarymgr.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @CrossOrigin(origins = "*")
    @GetMapping("")
    public Status isAlive(){
        LOGGER.info("calling isAlive service from controller");
        return bookServices.isAlive();
    }

    // POST Creates a Book
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/book")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody BookDTO bookDTO){
        LOGGER.info("calling createBook service from controller");
        return bookServices.createBook(bookDTO);
    }

    // GET All People
    @CrossOrigin(origins = "*")
    @GetMapping("/books")
    public List<BookDTO> listAllBooks() {
        LOGGER.info("calling listAllBooks service from controller");
        return bookServices.listAllBooks();
    }

    // GET a book by ID
    @CrossOrigin(origins = "*")
    @GetMapping("/book/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        LOGGER.info("calling getBookById service from controller");
        BookDTO bookDTO = bookServices.getBookById(id);
        return bookDTO;
    }



}
