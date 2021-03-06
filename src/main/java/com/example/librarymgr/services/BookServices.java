package com.example.librarymgr.services;

import com.example.librarymgr.DTOs.BookDTO;
import com.example.librarymgr.DTOs.OrderCreateDTO;
import com.example.librarymgr.DTOs.OrderDTO;
import com.example.librarymgr.DTOs.PatronDTO;
import com.example.librarymgr.models.Book;
import com.example.librarymgr.models.Order;
import com.example.librarymgr.models.Patron;
import com.example.librarymgr.models.Status;
import com.example.librarymgr.repositories.BookRepo;
import com.example.librarymgr.repositories.OrderRepo;
import com.example.librarymgr.repositories.PatronRepo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    ModelMapper mm = modelMapper();

    // SERVICES FOR ROUTES IN CONTROLLER
    public Status isAlive() {
        LOGGER.info("calling isAlive method ==>");
        Status current = new Status();
        current.setStatus(true);
        return current;
    }

    // POST /book -Creates new book from JSON payload
    public BookDTO createBook(BookDTO bookDTO){
        LOGGER.info("service calling createBook ==>");
        Book book = mm.map(bookDTO, Book.class);
        bookRepo.save(book);
        bookDTO = getBookById(book.getId());
        return bookDTO;
    }

    // GET /book -Returns list of ALL books
    public List<BookDTO> listAllBooks(){
        LOGGER.info("service calling listAllBooks ==>");
        List<Book> books = bookRepo.findAll();
        List<BookDTO> booksDTO = new ArrayList<>();

        books.stream().forEach( b ->
                booksDTO.add(mm.map(b, BookDTO.class))
        );
        return booksDTO;
    }

    // GET /book/{id} -Returns individual book
    public BookDTO getBookById(long id){
        LOGGER.info("service calling getBookById ==>");
        Optional<Book> book = bookRepo.findById(id);
        BookDTO bookDTO = mm.map( book.get(), BookDTO.class);
        return bookDTO;
    }

    // POST /patron -Creates new patron from JSON payload
    public PatronDTO createPatron(PatronDTO patronDTO){
        LOGGER.info("service calling createPatron ==>");
        Patron patron = mm.map(patronDTO, Patron.class);
        patronRepo.save(patron);
        patronDTO = getPatronById(patron.getId());
        return patronDTO;
    }


    //TODO POST /order -Creates new order from JSON payload
    public OrderDTO createOrder(OrderCreateDTO orderCreateDTO){
        LOGGER.info("service calling createOrder ==>");
        LocalDate today = LocalDate.now();
        LocalDate dueDate = today.plusDays(7);

        Long pid = orderCreateDTO.getPatronId();
        PatronDTO patronDTO = getPatronById(pid);
        Patron parton = mm.map(patronDTO, Patron.class);

        Set<Book> books = new HashSet<>();
        orderCreateDTO.getBookIdList().forEach(b ->
                books.add(mm.map(getBookById(b), Book.class))
        );

        Order order = new Order();
        order.setPatron(parton);
        order.setDateOut(today);
        order.setDateDue(dueDate);
        order.setBooks(books);
        LOGGER.info(order.getPatron().getName());
        orderRepo.save(order);

        return getOrderById(order.getId());
    }


    //TODO GET /order/{id} -Returns individual order
    public OrderDTO getOrderById(long id){
        LOGGER.info("service calling getOrderById ==>");
        Optional<Order> order = orderRepo.findById(id);
        OrderDTO orderDTO = mm.map( order.get(), OrderDTO.class);
        return orderDTO;
    }

    // GET /book -Returns list of ALL books
    public List<OrderDTO> listAllOrders(){
        LOGGER.info("service calling listAllOrders ==>");
        List<Order> orders = orderRepo.findAll();
        List<OrderDTO> ordersDTO = new ArrayList<>();

        orders.stream().forEach( o ->
                ordersDTO.add(mm.map(o, OrderDTO.class))
        );
        return ordersDTO;
    }



    // OPT GET /patron -Returns list of all patrons
    public List<PatronDTO> listAllPatrons(){
        LOGGER.info("service calling listAllPatrons ==>");
        List<Patron> patrons = patronRepo.findAll();
        List<PatronDTO> patronsDTO = new ArrayList<>();

        patrons.stream().forEach( p ->
                patronsDTO.add(mm.map(p, PatronDTO.class))
        );
        return patronsDTO;
    }

    // OPT GET /patron/{id} -Returns individual patron and their current books
    public PatronDTO getPatronById(long id){
        LOGGER.info("service calling getPatronById ==>");
        Optional<Patron> patron = patronRepo.findById(id);
        PatronDTO patronDTO = mm.map( patron.get(), PatronDTO.class);
        return patronDTO;
    }



}
