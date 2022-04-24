package com.example.librarymgr.repositories;

import com.example.librarymgr.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
