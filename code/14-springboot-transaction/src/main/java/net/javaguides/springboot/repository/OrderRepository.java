package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.springboot.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
