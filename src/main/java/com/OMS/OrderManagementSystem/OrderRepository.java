package com.OMS.OrderManagementSystem;

import model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface OrderRepository extends JpaRepository<Order, Long> {
    }

