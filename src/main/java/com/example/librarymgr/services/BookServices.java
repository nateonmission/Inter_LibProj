package com.example.librarymgr.services;

import com.example.librarymgr.DTOs.BookDTO;
import com.example.librarymgr.models.Book;
import com.example.librarymgr.models.Status;
import com.example.librarymgr.repositories.BookRepo;
import com.example.librarymgr.repositories.OrderRepo;
import com.example.librarymgr.repositories.PatronRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import java.util.*;

@Service
public class BookServices {
    private static final Logger LOGGER = Logger.getLogger(BookServices.class.getName());

    // JavaBeans POJO - One Instance for whole class
    private BookRepo bookRepo;
    @Autowired
    public void setBookRepo(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    private PatronRepo patronRepo;
    @Autowired
    public void setPatronRepo(PatronRepo patronRepo) {
        this.patronRepo = patronRepo;
    }

    private OrderRepo orderRepo;
    @Autowired
    public void setOrderRepo(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    // SERVICES FOR ROUTES IN CONTROLLER
    public Status isAlive() {
        LOGGER.info("calling isAlive method ==>");
        Status current = new Status();
        current.setStatus(true);
        return current;
    }

    // POST /book -Creates new book from JSON payload
    public Book createBook(BookDTO bookDTO){
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setCategory(bookDTO.getCategory());
        book.setAuthor(bookDTO.getAuthor());
        bookRepo.save(book);
        return book;
    }

    // GET /book -Returns list of ALL books
    public List<Book> listAllBooks(){
        List<Book> books = bookRepo.findAll();
        return books;
    }

    //TODO GET /book/{id} -Returns individual book


    //TODO POST /patron -Creates new patron from JSON payload



    //TODO POST /order -Creates new order from JSON payload


    //TODO GET /order/{id} -Returns individual order




    // -----------------------------------------------
    //TODO OPT GET /patron -Returns list of all patrons

    //TODO OPT GET /patron/{id} -Returns individual patron and their current books



}
