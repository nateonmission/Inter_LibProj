package com.example.librarymgr.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private LocalDate dateOut;

    @Column
    private LocalDate dateDue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id", referencedColumnName = "id")
    private Patron patron;

    @ManyToMany
    private Set<Book> books = new HashSet<>();


}
