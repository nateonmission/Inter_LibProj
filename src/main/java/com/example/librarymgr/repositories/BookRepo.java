package com.example.librarymgr.repositories;

import com.example.librarymgr.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Long> {


}
