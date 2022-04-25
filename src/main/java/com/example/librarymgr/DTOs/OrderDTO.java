package com.example.librarymgr.DTOs;

import com.example.librarymgr.models.Book;
import com.example.librarymgr.models.Patron;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private LocalDate dateOut;
    private LocalDate dateDue;
    private Patron patron;
    private Set<Book> books = new HashSet<>();


}
