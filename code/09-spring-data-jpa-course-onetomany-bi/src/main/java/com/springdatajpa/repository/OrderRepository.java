package com.springdatajpa.repository;

import com.springdatajpa.entity.manytomany.bidirectional.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findByOrderTrackingNumber(String orderTrackingNumber);
}
