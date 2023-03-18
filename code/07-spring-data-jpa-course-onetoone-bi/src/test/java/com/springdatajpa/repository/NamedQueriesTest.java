package com.springdatajpa.repository;


import com.springdatajpa.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
public class NamedQueriesTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void namedJPQLQuery(){

        Product product = productRepository.findByPrice(new BigDecimal(100));

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println(product.toString());
        System.out.println("---------------------- Final Resultados --------------------------------");
    }

    @Test
    void namedJPQLQueries(){

        List<Product> products = productRepository.findAllOrderByNameDesc();

        System.out.println("---------------------- Inicio Resultados --------------------------------");

        products.forEach((p) -> {
            System.out.println(p.toString());
        });

        Product product = productRepository.findByPrice(new BigDecimal(200));

        System.out.println(product.toString());
        System.out.println("---------------------- Final Resultados --------------------------------");;

    }

    @Test
    void namedNativeSQLQuery(){

        Product product = productRepository.findByDescription("Description Product 10");

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println(product.toString());
        System.out.println("---------------------- Final Resultados --------------------------------");

    }

    @Test
    void namedNativeSQLQueries() {
        Product product = productRepository.findByDescription("Description Product 10");

        System.out.println("---------------------- Inicio Resultados --------------------------------");
        System.out.println(product.toString());

        List<Product> products = productRepository.findAllOrderByNameASC();

        products.forEach((p) -> {
            System.out.println(p.toString());
        });
        System.out.println("---------------------- Final Resultados --------------------------------");

    }
}
