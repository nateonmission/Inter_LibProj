package com.example.librarymgr.repositories;

import com.example.librarymgr.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepo extends JpaRepository<Patron, Long> {
}
