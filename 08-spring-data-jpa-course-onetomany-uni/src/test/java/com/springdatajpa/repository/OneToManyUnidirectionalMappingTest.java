package com.springdatajpa.repository;


import com.springdatajpa.entity.onetomany.unidirectional.Address;
import com.springdatajpa.entity.onetomany.unidirectional.Order;
import com.springdatajpa.entity.onetomany.unidirectional.OrderItem;
import com.springdatajpa.entity.onetomany.unidirectional.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest
public class OneToManyUnidirectionalMappingTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;


    @Test
    void saveOrderTest(){
        saveProductsTest();

        //Save order along with also save it's order items
        Set<OrderItem> orderItemSet = new HashSet<>();

        //Create Order Item 1
        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProduct(productRepository.findById(1L).get());
        orderItem1.setQuantity(2);
        orderItem1.setPrice(orderItem1.getProduct().getPrice().multiply(new BigDecimal(2)));
        orderItem1.setImageUrl("image1.png");
        orderItemSet.add(orderItem1);

        //Create Order Item 2
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(productRepository.findById(2L).get());
        orderItem2.setQuantity(3);
        orderItem2.setPrice(orderItem2.getProduct().getPrice().multiply(new BigDecimal(3)));
        orderItem2.setImageUrl("image2.png");
        orderItemSet.add(orderItem2);

        //Create Address Billing
        Address address = new Address();
        address.setCity("México");
        address.setStreet("Av. Mario Colin");
        address.setState("Estado de México");
        address.setCountry("Mexico");
        address.setZipCode("54150");

        Order order = new Order();
        order.setOrderTrackingNumber("ID-123");
        order.setStatus("IN PROGRESS");
        order.setOrderItems(orderItemSet);
        order.setTotalPrice(order.getTotalAmount());
        order.setTotalQuantity(2);
        order.setBillingAddress(address);    // Se realiza en ambos lados porque la relacion
        address.setOrder(order);             // Entre Order y Address es bidirectional, sino no lo graba

        orderRepository.save(order);
    }

    @Test
    void fetchOrderTest(){
        Order order = orderRepository.findById(1L).get();
        System.out.println("********* Status : "+order.getStatus());
        System.out.println("********* Order : "+order.getOrderItems());
        for (OrderItem orderItem : order.getOrderItems()){
            System.out.println("Nombre : "+orderItem.getProduct().getName());
        }
    }

    @Test
    void deleteOrderMethod(){
        // Elimina Order, OrderItems, Address
        orderRepository.deleteById(1L);
    }

    @Test
    void saveProductsTest(){
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setDescription("Description Product 1");
        product1.setSku("100ABC");
        product1.setPrice(new BigDecimal(100));
        product1.setActive(true);
        product1.setImageUrl("product1.png");

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Description Product 2");
        product2.setSku("200ABC");
        product2.setPrice(new BigDecimal(200));
        product2.setActive(true);
        product2.setImageUrl("product2.png");

        productRepository.saveAll(List.of(product1, product2));

    }

}
