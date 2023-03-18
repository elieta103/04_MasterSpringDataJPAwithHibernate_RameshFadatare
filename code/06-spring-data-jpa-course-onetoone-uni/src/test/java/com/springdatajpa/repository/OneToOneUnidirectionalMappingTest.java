package com.springdatajpa.repository;


import com.springdatajpa.entity.onetoone.Address;
import com.springdatajpa.entity.onetoone.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
public class OneToOneUnidirectionalMappingTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrderTest(){
        Order order = Order.builder()
                .orderTrackingNumber("1000ABC")
                .totalQuantity(5)
                .status("IN PROGRESS")
                .totalPrice(new BigDecimal("1000"))
                .build();

        Address address = Address.builder()
                .city("Mexico")
                .street("Guanajuato 198")
                .state("Mexico")
                .country("Mexico")
                .zipCode("54150")
                .build();

        order.setBillingAddress(address);

        orderRepository.save(order);
    }

    @Test
    void getOrderTest(){
        Order order = orderRepository.findById(1L).get();
        System.out.println("Order : "+order.toString());
    }

    @Test
    void updateOrderTest(){
        Order order = orderRepository.findById(1L).get();
        order.setStatus("DELIVERED");
        order.getBillingAddress().setZipCode("45602");

        orderRepository.save(order);
    }

    @Test
    void deleteOrderTest(){
        orderRepository.deleteById(1L);
    }
}
