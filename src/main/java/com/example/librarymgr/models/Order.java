package com.example.librarymgr.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Date dateOut;

    @Column
    private Date dateDue;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patron_id", referencedColumnName = "id")
    private Patron patron;

    @ManyToMany
    private Set<Book> children = new HashSet<>();


}
