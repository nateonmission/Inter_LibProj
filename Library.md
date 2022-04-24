# Getting Started

## Requirements

This is the backend service of a simple library management system for a library. Suggest putting together an ERD in
order to visualize the relationships. Make sure to test your code using Mokito and JUnit.

### Support book persistence

* The library maintains multiple books. Each book has id. book name and category.
    ```
    ID   BOOK_NAME     CATEGORY
     1   Book_name      Sci-Fi
     2   Book_name      Horror
     3   Book_name      Romance
    ```

### Maintain Customers

* The library maintains multiple customers. Each customer has id, customer name. For example, the system may have the
  following customers.
    ```
    ID   CUSTOMER_NAME    
    1    Customer1     
    2    Customer2      
    ```
* Each customer can check out multiple books. For example,
    ```
    Customer_Order 101  contains 
    ```

### Maintain Orders

* The library keeps track of books checked out and when they are due. Each book that is checked out, by the customer,
  has an id and links the book and customer.

```
ID     BOOK       CUSTOMER_ID     CHECK_OUT_DATE    DATE_DUE    
101    book_name  Customer_ID     Date              Date        
102    book_name  Customer_ID     Date              Date        
103    book_name  Customer_ID     Date              Date        
```

### Endpoints supported

It is expected to support the following endpoints,

* Get the information of one book
   ```
   GET /book/1
   ```

* Retrieve the information of all books
   ```
   GET/books
   ```

* Create one Order
   ```
   POST/order with payload of an order 
   ```
* Retrieve the information of one order which include the order ID, customer name, name of book, date checked out, date
  due, and date checked in (if applicable). It also includes information of all books in this order (the book id, book
  name, and category)
   ```
   GET /order/101
   ```

### Useful Annotations/syntax

* Spring Web
   ```
   @RestController
   @GetMapping("/product/{productId}")
   @PathVariable Long productId
   @PostMapping("/product")
   @RequestBody ProductDTO productDTO
   ```
* Lombok
   ```
   @Setter
   @Getter
   @NoArgsConstructor
   @AllArgsConstructor
   ```
* Spring Data/JPA
   ```
   @Entity
   @Id
   @ManyToOne
   @JoinColumn
   @OneToMany(mappedBy = "object name")
   @Repository
   public interface OrderRepository extends JpaRepository<OrderEntity,Long> 
   ```
* ModelMapper between DTO and Entity
   ```
  ModelMapper modelMapper = new ModelMapper();
  // user here is a prepopulated User instance
  UserDTO userDTO = modelMapper.map(user, UserDTO.class);
   ``` 

### Access H2 Database Console - (You can use Postgresql if necessary)

* Launch the following url:
   ```
   http://localhost:8080/h2
   ```
* Provide the following information:
   ```
   JDBC URL:jdbc:h2:mem:testdb
   User Name:sa
   Password: sa
   ```
