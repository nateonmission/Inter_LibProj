package com.example.librarymgr.controllers;

import com.example.librarymgr.DTOs.BookDTO;
import com.example.librarymgr.DTOs.OrderCreateDTO;
import com.example.librarymgr.DTOs.OrderDTO;
import com.example.librarymgr.DTOs.PatronDTO;
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

    // GET All Books
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

    // POST Creates a Patron
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/patron")
    @ResponseStatus(HttpStatus.CREATED)
    public PatronDTO createPatron(@RequestBody PatronDTO patronDTO){
        LOGGER.info("calling createPatron service from controller");
        return bookServices.createPatron(patronDTO);
    }

    // GET a patron by ID
    @CrossOrigin(origins = "*")
    @GetMapping("/patron/{id}")
    public PatronDTO getPatronById(@PathVariable Long id) {
        LOGGER.info("calling getPatronById service from controller");
        PatronDTO patronDTO = bookServices.getPatronById(id);
        return patronDTO;
    }

    // GET All Patrons
    @CrossOrigin(origins = "*")
    @GetMapping("/patrons")
    public List<PatronDTO> listAllPatrons() {
        LOGGER.info("calling listAllPatrons service from controller");
        return bookServices.listAllPatrons();
    }

    // POST create ORDER
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/order")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO createOrder(@RequestBody OrderCreateDTO orderCreateDTO){
        LOGGER.info("calling createOrder service from controller");
        return bookServices.createOrder(orderCreateDTO);
    }

    // GET All Orders
    @CrossOrigin(origins = "*")
    @GetMapping("/orders")
    public List<OrderDTO> listAllOrders() {
        LOGGER.info("calling listAllOrders service from controller");
        return bookServices.listAllOrders();
    }

    // GET a order by ID
    @CrossOrigin(origins = "*")
    @GetMapping("/order/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        LOGGER.info("calling getOrderById service from controller");
        OrderDTO orderDTO = bookServices.getOrderById(id);
        return orderDTO;
    }


}
